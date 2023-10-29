package com.example.puddyBuddy.controller;
import com.example.puddyBuddy.domain.Board;
import com.example.puddyBuddy.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping( value = "/boards",  produces = "application/json;charset=utf8")
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public @ResponseBody List<Board> getBoards() {
        List<Board> boards = boardService.getBoards();
        return boards;
    }

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }
}
