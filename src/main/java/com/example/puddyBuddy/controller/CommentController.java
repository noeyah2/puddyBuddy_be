package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.domain.Board;
import com.example.puddyBuddy.domain.Comment;
import com.example.puddyBuddy.dto.board.BoardCreateReq;
import com.example.puddyBuddy.dto.board.BoardCreateRes;
import com.example.puddyBuddy.dto.comment.CommentCreateReq;
import com.example.puddyBuddy.dto.comment.CommentCreateRes;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.response.BaseResponse;
import com.example.puddyBuddy.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Operation(summary = "댓글 전부 보기")
    @GetMapping
    public @ResponseBody List<Comment> getComments() {
        List<Comment> Comments = commentService.getComments();
        return Comments;
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
