package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.Board;
import com.example.puddyBuddy.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository userRepository;

    public BoardService(BoardRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Board> getBoards(){
        List<Board> objs = userRepository.findAll();
        return objs;
    }
}