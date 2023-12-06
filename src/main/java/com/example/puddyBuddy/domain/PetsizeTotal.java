package com.example.puddyBuddy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pet_size_total")
@Getter
@Setter
public class PetsizeTotal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_size_total_id")
    private Long petsizetotalId;

    @ManyToOne
    @JoinColumn(name = "breed_tag_id")
    private BreedTag breedTag;

    @Column(name = "part")
    private String part;

    @Column(name = "min")
    private Float min;

    @Column(name = "max")
    private Float max;

    @Column(name = "avg")
    private Float avg;
}
