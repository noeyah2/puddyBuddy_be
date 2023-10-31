package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.Comment;
import com.example.puddyBuddy.repository.CommentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository userRepository;

    public CommentService(CommentRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Comment> getComments(){
        List<Comment> comments = userRepository.findAll();
        return comments;
    }
}