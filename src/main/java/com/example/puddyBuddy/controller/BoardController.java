package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.dto.clothes.ClothesListRes;
import com.example.puddyBuddy.repository.BoardRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.puddyBuddy.domain.*;
import com.example.puddyBuddy.dto.board.*;
import com.example.puddyBuddy.service.BoardService;
import com.example.puddyBuddy.exception.common.*;
import com.example.puddyBuddy.response.BaseResponse;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RestController
@RequestMapping( value = "/boards",  produces = "application/json;charset=utf8")
@Tag(name = "게시판 API")
public class BoardController {
    private final BoardService boardService;

    private final BoardRepository boardRepository;

    public BoardController(BoardService boardService, BoardRepository boardRepository) {
        this.boardService = boardService;
        this.boardRepository = boardRepository;
    }

    @Operation(summary = "게시글 전체 목록")
    @GetMapping("/all")
    public BaseResponse<List<BoardListRes>>getBoards() {
        try {
            List<Board> boards = boardService.getBoards();
            List<BoardListRes> boardList = boards.stream()
                    .map(BoardListRes::new)
                    .collect(Collectors.toList());
            return new BaseResponse<>(boardList);
        } catch(BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
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
    }

    @Operation(summary = "게시글 상세 조회", description = "게시글 번호를 주면 그 게시글을 하나 불러옵니다.")
    @GetMapping("/{boardId}")
    public BaseResponse<BoardRes> getBoard(@PathVariable Long boardId){
        try {
            return new BaseResponse<>(boardService.getBoardOne(boardId));
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }

    @Operation(summary = "회원별 의류별 게시글 조회", description = "회원 번호 또는 상품 번호를 주면 그 게시글 리스트들을 불러옵니다. 만약 아무것도 주지 않는다면 전체 목록")
    @GetMapping()
    public BaseResponse<List<BoardListRes>> getUserBoard(
            @RequestParam(name = "user_id", required = false, defaultValue = "-1") Long userId,
            @RequestParam(name = "clothes_id", required = false, defaultValue = "-1") Long clothesId
    ){
        try {
            Specification<Board> spec = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();

                if (userId != null && userId != -1) {
                    predicates.add(criteriaBuilder.equal(root.get("user").get("userId"), userId));
                }

                if (clothesId != null && clothesId != -1) {
                    predicates.add(criteriaBuilder.equal(root.get("clothes").get("clothesId"), clothesId));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            Sort sort = Sort.by(Sort.Direction.DESC, "createDate");
            List<Board> boards = boardRepository.findAll(spec, sort);
            List<BoardListRes> boardList = boards.stream()
                    .map(BoardListRes::new)
                    .collect(Collectors.toList());

            return new BaseResponse<>(boardList);
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }
}
