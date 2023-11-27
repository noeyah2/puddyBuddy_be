package com.example.puddyBuddy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "petsnal_colors")
@Getter
@Setter
public class PetsnalColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "petsnal_color_id")
    private Long petsnalColorId;

    @ManyToOne
    @JoinColumn(name = "prefer_id")
    private Prefer prefer;

    @Column(name = "stage_id")
    private Long stageId;

    @Column(name = "photo_id")
    private Long photo_id;

    @Column(name = "photo_url")
    private String photoUrl;

}
