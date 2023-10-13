package com.example.puddyBuddy.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "board_photos")
public record BoardPhoto (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "board_photo_id")
        Long boardPhotoId)
{
}
