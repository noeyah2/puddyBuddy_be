package com.example.puddyBuddy.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.puddyBuddy.domain.*;
import com.example.puddyBuddy.dto.board.*;
import com.example.puddyBuddy.service.BoardService;
import com.example.puddyBuddy.exception.common.*;
import com.example.puddyBuddy.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RestController
@RequestMapping( value = "/boards",  produces = "application/json;charset=utf8")
@Tag(name = "게시판 API")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @Operation(summary = "게시글 전부 보기")
    @GetMapping
    public @ResponseBody List<Board> getBoards() {
        List<Board> boards = boardService.getBoards();
        return boards;
    }

    @Operation(summary = "게시글 등록", description = "게시글에서 글을 등록했습니다.")
    @PostMapping("/create")
    public BaseResponse<BoardCreateRes> createBoard(@RequestBody BoardCreateReq boardInsertReq) {
        try{
            BoardCreateRes boardInsertRes = boardService.createBoard(boardInsertReq.getUserId(), boardInsertReq.getPreferId(), boardInsertReq.getClothesId(), boardInsertReq.getContent(), boardInsertReq.getPhotoUrl());
            return new BaseResponse<>(boardInsertRes);
        } catch(BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }

    @Operation(summary = "게시글 삭제", description = "게시글에서 해당 글을 삭제했습니다.")
    @GetMapping("/delete/{boardId}")
    public String deleteBoard(@PathVariable Long boardId){
        boardService.deleteBoard(boardId);
        return "redirect:/boards";
//        return new RedirectView("/boards");
    }
    @Operation(summary = "게시글 상세 조회", description = "게시글을 하나씩 불러옵니다.")
    @GetMapping("/{boardId}")
    public BoardRes getBoard(@PathVariable Long boardId){
        return boardService.getBoardOne(boardId);
    }
}
