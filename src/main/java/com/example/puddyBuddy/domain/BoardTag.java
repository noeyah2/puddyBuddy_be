package com.example.puddyBuddy.domain;

import jakarta.persistence.*;
@Entity
@Table(name = "board_tags")
public record BoardTag (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "board_tag_id")
        Long boardTagsId)
{
}