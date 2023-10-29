package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.Board;
import com.example.puddyBuddy.domain.Clothes;
import com.example.puddyBuddy.domain.Prefer;
import com.example.puddyBuddy.domain.User;
import com.example.puddyBuddy.dto.board.BoardCreateRes;
import com.example.puddyBuddy.repository.BoardRepository;
import com.example.puddyBuddy.repository.ClothesRepository;
import com.example.puddyBuddy.repository.PreferRepository;
import com.example.puddyBuddy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.puddyBuddy.exception.common.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final PreferRepository preferRepository;
    private final ClothesRepository clothesRepository;

//    public BoardService(BoardRepository boardRepository) {
//        this.boardRepository = boardRepository;
//    }

    public List<Board> getBoards(){
        List<Board> boards = boardRepository.findAll();
        return boards;
    }

    public BoardCreateRes createBoard(Long userId, Long preferId, Long clothesId, String content, String photoUrl) {
//        Board savedBoard = boardRepository.save(board);
        Board newBoard = new Board(); // 새로운 Board 객체
        BoardCreateRes boardCreateRes = new BoardCreateRes();// 반환해줄 값

        // user
        Optional<User> user = userRepository.findByUserId(userId);

        if(user.isEmpty()){
            throw new BusinessException(ErrorCode.NO_EXIST_USER);
        }
        // User 객체 불러와서 user 채워주기
        newBoard.setUser(user.get());

        // prefer
        Optional<Prefer> prefer = preferRepository.findByPreferId(preferId);

        if(prefer.isEmpty()){
            throw new BusinessException(ErrorCode.NO_EXIST_PREFERCODE);
        }

        // Prefer 객체 repo에서 불러와서 prefer 채워주기
        newBoard.setPrefer(prefer.get());

        //clothes
        Optional<Clothes> clothes = clothesRepository.findByClothesId(clothesId);

        if(clothes.isEmpty()){
            throw new BusinessException(ErrorCode.NO_EXIST_CLOTHESCODE);
        }
        // Clothes 객체 repo에서 불러와서 clothes 채워주기
        newBoard.setClothes(clothes.get());

        // content
        newBoard.setContent(content);
        newBoard.setPhotoUrl(photoUrl);

        Long newBoardId = boardRepository.save(newBoard).getBoardId();

        boardCreateRes.setBoardId(newBoardId);

        return boardCreateRes;
    }
}