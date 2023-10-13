package com.example.puddyBuddy.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "clothes")
public record Clothes (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "clothes_id")
        Long clothesId)
{
}
