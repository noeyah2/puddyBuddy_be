package com.example.puddyBuddy.domain;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "boards")
public record Board (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "board_id")
        Long boardId)
{
}
