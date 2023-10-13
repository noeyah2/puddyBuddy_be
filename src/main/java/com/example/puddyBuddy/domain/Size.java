package com.example.puddyBuddy.domain;
import jakarta.persistence.*;

@Entity
@Table(name = "sizes")
public record Size (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "size_id")
        Long sizeId)
{
}
