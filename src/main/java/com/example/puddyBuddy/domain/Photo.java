package com.example.puddyBuddy.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "photos")
public record Photo (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "photo_id")
        Long photoId)
{
}