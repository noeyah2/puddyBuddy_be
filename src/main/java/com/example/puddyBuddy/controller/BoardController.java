package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.domain.*;
import com.example.puddyBuddy.service.BoardService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping( value = "/boards",  produces = "application/json;charset=utf8")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public @ResponseBody List<Board> getBoards() {
        List<Board> boards = boardService.getBoards();
        return boards;
    }

    @PostMapping("/create")
    public Long createBoard(
            @RequestParam("user_id") Long userId,
            @RequestParam("prefer_id") Long preferId,
            @RequestParam("clothes_id") Long clothesId,
            @RequestParam("content") String content,
            @RequestParam("photo_url") String photoUrl) {

        Board board = new Board();
        // 여기에서 Board 객체에 필요한 데이터를 설정
        User user = new User();
        user.setUserId(userId);
        Prefer prefer = new Prefer();
        prefer.setPreferId(preferId);
        Clothes clothes = new Clothes();
        clothes.setClothesId(clothesId);

        board.setUser(user);
        board.setPrefer(prefer);
        board.setClothes(clothes);
        board.setContent(content);
        board.setPhotoUrl(photoUrl);

        Long boardId = boardService.create(board);
        return boardId;
    }
}
