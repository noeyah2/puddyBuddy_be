package com.example.puddyBuddy.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "prefers")
public record Prefer (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "prefer_id")
        Long preferId)
{
}