package com.example.puddyBuddy.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "colors")
public record Color (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "color_id")
        Long colorId,
        @Column(name = "name")
        String name)
{
}