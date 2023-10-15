package com.example.puddyBuddy.domain;
import jakarta.persistence.*;

@Entity
@Table(name = "personal_colors")
public record PersonalColor (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "personal_color_id")
        Long personalColorId,
        @Column(name = "name")
        String name
)
{
}
