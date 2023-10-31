package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.Board;
import com.example.puddyBuddy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAll();
    Optional<Board> findByBoardId(Long boardId);
}