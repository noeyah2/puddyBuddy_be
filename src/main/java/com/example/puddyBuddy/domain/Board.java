package com.example.puddyBuddy.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Entity
@Table(name = "boards")
@Getter
@Setter
public class Board {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "board_id")
        private Long boardId;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne
        @JoinColumn(name = "prefer_id")
        private Prefer prefer;

        @ManyToOne
        @JoinColumn(name = "clothes_id")
        private Clothes clothes;

        @Column(name = "content")
        private String content;

        @Column(name = "photo_url")
        private String photoUrl;

        @Column(name = "name")
        private String name;

        @CreationTimestamp
        @Column(name = "create_date")
        private LocalDateTime createDate;
}
