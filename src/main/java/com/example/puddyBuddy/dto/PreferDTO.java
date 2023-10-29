package com.example.puddyBuddy.dto;

import com.example.puddyBuddy.domain.Prefer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PreferDTO {
    private long preferId;
    private long userId;
    private long breedTagId;
    private long personalColorId;
    private String name;
    private float chest;
    private float back;

    public PreferDTO(long preferId, long userId, long breedTagId, long personalColorId, String name, float chest, float back) {
        this.preferId = preferId;
        this.userId = userId;
        this.breedTagId = breedTagId;
        this.personalColorId = personalColorId;
        this.name = name;
        this.chest = chest;
        this.back = back;
    }

    public static PreferDTO toPreferDTO(Prefer prefer) {
        return new PreferDTO(
                prefer.getPreferId(),
                prefer.getUser().getUserId(),
                prefer.getBreedTag().getBreedTagId(),
                prefer.getPersonalColor().getPersonalColorId(),
                prefer.getName(),
                prefer.getChest(),
                prefer.getBack()
        );
    }
}
