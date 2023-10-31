package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.domain.Board;
import com.example.puddyBuddy.domain.Comment;
import com.example.puddyBuddy.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping( value = "/comments",  produces = "application/json;charset=utf8")
@Tag(name = "댓글 api")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Operation(summary = "게시글 전부 보기")
    @GetMapping
    public @ResponseBody List<Comment> getComments() {
        List<Comment> Comments = commentService.getComments();
        return Comments;
    }

}
