package com.example.puddyBuddy.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clothes_photos")
@Getter
@Setter
public class ClothesPhoto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "clothes_photo_id")
        private Long clothesPhotoId;

        @ManyToOne
        @JoinColumn(name = "clothes_id")
        private Clothes clothes;

        @Column(name = "photo1_url")
        private String photo1_url;

        @Column(name = "photo2_url")
        private String photo2_url;

        @Column(name = "photo3_url")
        private String photo3_url;


}
