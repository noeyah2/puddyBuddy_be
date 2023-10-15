package com.example.puddyBuddy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ar_clothes")
@Getter
@Setter
public class ArClothes {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ar_clothes_id")
        private Long arClothesId;

        @ManyToOne
        @JoinColumn(name = "clothes_id")
        private Clothes clothes;

        @Column(name = "pattern_url")
        private String patternUrl;

}
