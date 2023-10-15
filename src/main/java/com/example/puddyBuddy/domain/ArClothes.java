package com.example.puddyBuddy.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "ar_clothes")
public record ArClothes (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ar_clothes_id")
        Long arClothesId,

        @ManyToOne
        @JoinColumn(name = "clothes_id")
        Clothes clothes,

        @Column(name = "pattern_url")
        String PatternUrl
)
{
}