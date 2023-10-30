package com.example.puddyBuddy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clothes")
@Getter
@Setter
public class Clothes {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "clothes_id")
        private Long clothesId;


        @ManyToOne
        @JoinColumn(name = "store_id")
        private Store store;

        @Column(name = "name")
        private String name;

        @Column(name = "shopping_site_url")
        private String shoppingSiteUrl;

        @Column(name = "content")
        private String content;

        @ManyToOne
        @JoinColumn(name = "personal_color_id")
        private PersonalColor personalColor;

        @ManyToOne
        @JoinColumn(name = "color_id")
        private Color color;

}
