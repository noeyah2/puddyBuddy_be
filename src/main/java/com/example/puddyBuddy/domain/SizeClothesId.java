package com.example.puddyBuddy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class SizeClothesId implements Serializable {
    @Column(name = "size_id")
    private Long sizeId;

    @Column(name = "clothes_id")
    private Long clothesId;
}
