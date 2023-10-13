package com.example.puddyBuddy.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "tags")
public record Tag (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "tag_id")
        Long tagId)
{
}