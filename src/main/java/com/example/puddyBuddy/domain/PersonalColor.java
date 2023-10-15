package com.example.puddyBuddy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "personal_colors")
@Getter
@Setter
public class PersonalColor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "personal_color_id")
        private Long personalColorId;

        @Column(name = "name")
        private String name;

}
