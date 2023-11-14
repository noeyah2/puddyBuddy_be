package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.Board;
import com.example.puddyBuddy.domain.Clothes;
import com.example.puddyBuddy.domain.Prefer;
import com.example.puddyBuddy.domain.User;
import com.example.puddyBuddy.dto.board.BoardCreateRes;
import com.example.puddyBuddy.dto.board.BoardRes;
import com.example.puddyBuddy.repository.BoardRepository;
import com.example.puddyBuddy.repository.ClothesRepository;
import com.example.puddyBuddy.repository.PreferRepository;
import com.example.puddyBuddy.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.puddyBuddy.exception.common.*;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final PreferRepository preferRepository;
    private final ClothesRepository clothesRepository;

    public List<Board> getBoards(){
        List<Board> boards = boardRepository.findAll();
        return boards;
    }

    public BoardCreateRes createBoard(Long userId, Long preferId, Long clothesId, String content, String photoUrl) {
        Board newBoard = new Board();
        BoardCreateRes boardCreateRes = new BoardCreateRes();

        // user
        Optional<User> user = userRepository.findByUserId(userId);
        if(user.isEmpty()){
            throw new BusinessException(ErrorCode.NO_EXIST_USER);
        }
        newBoard.setUser(user.get());

        // prefer
        Optional<Prefer> prefer = preferRepository.findByPreferId(preferId);
        if(prefer.isEmpty()){
            throw new BusinessException(ErrorCode.NO_EXIST_PREFERCODE);
        }
        newBoard.setPrefer(prefer.get());

        //clothes
        Optional<Clothes> clothes = clothesRepository.findByClothesId(clothesId);
        if(clothes.isEmpty()){
            throw new BusinessException(ErrorCode.NO_EXIST_CLOTHESCODE);
        }
        newBoard.setClothes(clothes.get());

        // etc
        newBoard.setContent(content);
        newBoard.setPhotoUrl(photoUrl);

        Long newBoardId = boardRepository.save(newBoard).getBoardId();
        boardCreateRes.setBoardId(newBoardId);

        return boardCreateRes;
    }

    public void deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    public BoardRes getBoardOne(Long boardId) {
        Board board = boardRepository.findByBoardId(boardId).orElseThrow(() -> new BusinessException(ErrorCode.EMPTY_DATA));
        BoardRes response = new BoardRes(board);

        return response;
    }

//    public BoardRes getUserBoard(Long userId) {
//        Board board = (Board) boardRepository.findByUserUserId(userId).orElseThrow(() -> new BusinessException(ErrorCode.EMPTY_DATA));
//        BoardRes response = new BoardRes(board);
//
//        return response;
//    }
}