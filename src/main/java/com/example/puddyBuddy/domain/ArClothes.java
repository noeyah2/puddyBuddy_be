package com.example.puddyBuddy.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "ar_clothes")
public record ArClothes (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ar_clothes_id")
        Long arClothesId)
{
}