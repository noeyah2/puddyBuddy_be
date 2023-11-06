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
}
