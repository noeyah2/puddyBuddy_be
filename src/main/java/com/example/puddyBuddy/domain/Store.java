package com.example.puddyBuddy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "stores")
@Getter
@Setter
public class Store {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "store_id")
        private Long storeId;

        @Column(name = "store_name")
        private String storeName;

}