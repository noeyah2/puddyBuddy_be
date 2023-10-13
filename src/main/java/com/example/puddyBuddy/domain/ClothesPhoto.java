package com.example.puddyBuddy.domain;
import jakarta.persistence.*;

@Entity
@Table(name = "clothes_photos")
public record ClothesPhoto (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "clothes_photo_id")
        Long clothesPhotoId)
{
}
