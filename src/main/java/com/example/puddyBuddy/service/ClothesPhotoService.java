package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.Board;
import com.example.puddyBuddy.domain.ClothesPhoto;
import com.example.puddyBuddy.dto.board.BoardRes;
import com.example.puddyBuddy.dto.clothesphoto.ClothesPhotoRes;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.exception.common.ErrorCode;
import com.example.puddyBuddy.repository.ClothesPhotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesPhotoService {
    private final ClothesPhotoRepository clothesPhotoRepository;

    public ClothesPhotoService(ClothesPhotoRepository clothesPhotoRepository) {
        this.clothesPhotoRepository = clothesPhotoRepository;
    }

    public ClothesPhotoRes getClothesPhotos(Long clothesId){
        ClothesPhoto clothesPhoto = clothesPhotoRepository.findByClothes_ClothesId(clothesId);
        ClothesPhotoRes response = new ClothesPhotoRes(clothesPhoto);

        return response;
    }
}
