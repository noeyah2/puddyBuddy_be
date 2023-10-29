package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.Board;
import com.example.puddyBuddy.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
//@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> getBoards(){
        List<Board> boards = boardRepository.findAll();
        return boards;
    }

    public Long create(Board board) {
        Board savedBoard = boardRepository.save(board);
        return savedBoard.getBoardId();
    }
}