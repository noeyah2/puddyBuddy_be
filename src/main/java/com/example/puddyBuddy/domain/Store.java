package com.example.puddyBuddy.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "stores")
public record Store (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "store_id")
        Long storeId)
{
}