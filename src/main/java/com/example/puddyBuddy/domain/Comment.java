package com.example.puddyBuddy.domain;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "comments")
public record Comment (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "comment_id")
        Long commentId)
{
}
