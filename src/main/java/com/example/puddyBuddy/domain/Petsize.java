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

    @OneToOne
    @JoinColumn(name = "prefer_id", unique = true)
    private Prefer prefer;

    @ManyToOne
    @JoinColumn(name = "breed_tag_id")
    private BreedTag breedTag;

    @Column(name = "neck-size")
    private Float neck;

    @Column(name = "chest-size")
    private Float chest;

    @Column(name = "back-length")
    private Float back;

    @Column(name = "leg-size")
    private Float leg;
}
