package com.example.puddyBuddy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "prefers")
@Getter
@Setter
public class Prefer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "prefer_id")
        private Long preferId;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne
        @JoinColumn(name = "breed_tag_id")
        private BreedTag breedTag;

        @ManyToOne
        @JoinColumn(name = "personal_color_id")
        private PersonalColor personalColor;

        @OneToOne(mappedBy = "prefer")
        private Petsize petsize;

        @Column(name = "name")
        private String name;
}