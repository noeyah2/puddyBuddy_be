package com.example.puddyBuddy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "sizeclothes")
@Getter
@Setter
public class SizeClothes {
    @EmbeddedId
    private SizeClothesId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id", insertable = false, updatable = false)
    private Size size;

    @ManyToOne
    @JoinColumn(name = "clothes_id", insertable = false, updatable = false)
    private Clothes clothes;
}
