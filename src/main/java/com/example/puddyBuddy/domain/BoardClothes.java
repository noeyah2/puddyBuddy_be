package com.example.puddyBuddy.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "board_clothes")
public record BoardClothes (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "board_clothes_id")
        Long boardClothesId)
{
}