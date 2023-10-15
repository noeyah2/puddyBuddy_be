package com.example.puddyBuddy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "colors")
@Getter
@Setter
public class Color {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "color_id")
        private Long colorId;

        @Column(name = "name")
        private String name;

}
