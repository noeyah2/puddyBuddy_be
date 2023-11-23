package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.Board;
import com.example.puddyBuddy.domain.Clothes;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long>, JpaSpecificationExecutor<Board> {
    List<Board> findAll(Sort sort);
    Optional<Board> findByBoardId(Long boardId);

//    Optional<Object> findByUserUserId(Long userId);
}