package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.domain.Board;
import com.example.puddyBuddy.domain.Comment;
import com.example.puddyBuddy.domain.User;

import com.example.puddyBuddy.dto.comment.CommentCreateReq;
import com.example.puddyBuddy.dto.comment.CommentCreateRes;
import com.example.puddyBuddy.dto.comment.CommentListRes;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.response.BaseResponse;
import com.example.puddyBuddy.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RestController
@RequestMapping( value = "/comments",  produces = "application/json;charset=utf8")
@Tag(name = "댓글 API")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Operation(summary = "댓글 전체 목록")
    @GetMapping

    public BaseResponse<List<CommentListRes>> getUsers() {
        try {
            List<Comment> comments = commentService.getComments();
            List<CommentListRes> commentList = comments.stream()
                    .map(CommentListRes::new)
                    .collect(Collectors.toList());
            return new BaseResponse<>(commentList);
        } catch(BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }

    @Operation(summary = "댓글 등록", description = "해당 게시글에 댓글을 등록했습니다.")
    @PostMapping("/create")
    public BaseResponse<CommentCreateRes> createComment(@RequestBody CommentCreateReq CommentInsertReq) {
        try{
            CommentCreateRes CommentInsertRes = commentService.createComment(CommentInsertReq.getBoardId(), CommentInsertReq.getUserId(),CommentInsertReq.getContent());
            return new BaseResponse<>(CommentInsertRes);
        } catch(BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }

    @Operation(summary = "댓글 삭제", description = "게시글에서 해당 댓글을 삭제했습니다.")
    @GetMapping("/delete/{commentId}")
    public String deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
        return "redirect:/comments";
    }
}
