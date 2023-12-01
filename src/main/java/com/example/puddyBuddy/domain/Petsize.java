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
    private Long petSizeId;

    @ManyToOne
    @JoinColumn(name = "prefer_id")
    private Prefer prefer;

    @Column(name = "back-length")
    private Float back;

    @Column(name = "chest-size")
    private Float chest;

    @Column(name = "photo_url")
    private String photoUrl;
}
