package com.example.puddyBuddy.dto.clothesphoto;

import com.example.puddyBuddy.domain.ClothesPhoto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "옷 사진 정보 조회 response")
public class ClothesPhotoRes {
    private Long clothesPhotoId;
    private Long clothesId;
    private String photourl1;
    private String photourl2;
    private String photourl3;

    public ClothesPhotoRes(ClothesPhoto clothesPhoto) {
        this.clothesPhotoId = clothesPhoto.getClothesPhotoId();
        this.clothesId = clothesPhoto.getClothes().getClothesId();
        this.photourl1 = clothesPhoto.getPhoto1_url();
        this.photourl2 = clothesPhoto.getPhoto2_url();
        this.photourl3 = clothesPhoto.getPhoto3_url();
    }
}
