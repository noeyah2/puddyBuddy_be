package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByCommentId(Long CommentId);

    List<Comment> findAll();

    List<Comment> findByBoard_BoardId(Long boardId);
}
