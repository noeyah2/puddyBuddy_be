package com.example.puddyBuddy.domain;

import jakarta.persistence.*;
@Entity
@Table(name = "breed_tags")
public record BreedTag(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "breed_tag_id")
        Long breedTagsId,
        @Column(name = "breed_tag_name")
        String breedTagName)
{
}