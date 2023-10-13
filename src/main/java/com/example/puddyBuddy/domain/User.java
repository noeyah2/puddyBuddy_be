package com.example.puddyBuddy.domain;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "users")
public record User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        Long userId,
        @Column(name = "name")
        String Name,
        @Column(name = "nickname")
        String nickname,
        @Column(name = "email")
        String email,
        @Column(name = "create_time")
        LocalDateTime createTime
) {
}
