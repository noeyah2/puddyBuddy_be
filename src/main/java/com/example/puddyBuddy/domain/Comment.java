package com.example.puddyBuddy.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Entity
@Table(name = "comments")
@Getter
@Setter
public class Comment {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "comment_id")
        private Long commentId;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne
        @JoinColumn(name = "Board_id")
        private Board board;

        @Column(name = "content")
        private String content;

        @CreationTimestamp
        @Column(name = "create_date")
        private LocalDateTime createDate;

}
