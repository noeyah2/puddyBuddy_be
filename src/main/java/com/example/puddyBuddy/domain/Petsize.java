package com.example.puddyBuddy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "petsize")
@Getter
@Setter
public class Petsize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_size_id")
    private Long petsizeId;

    @ManyToOne
    @JoinColumn(name = "prefer_id")
    private Prefer prefer;

    @ManyToOne
    @JoinColumn(name = "breed_tag_id")
    private BreedTag breedTag;

    @Column(name = "neck_size")
    private Float neck;

    @Column(name = "chest_size")
    private Float chest;

    @Column(name = "back_length")
    private Float back;

    @Column(name = "leg_size")
    private Float leg;
}
