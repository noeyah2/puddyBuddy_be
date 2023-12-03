package com.example.puddyBuddy;

import com.example.puddyBuddy.domain.Size;
import com.example.puddyBuddy.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final BreedTagRepository breedTagRepository;
    private final ColorRepository colorRepository;
    private final PersonalColorRepository personalColorRepository;
    private final PreferRepository preferRepository;
    private final SizeRepository sizeRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final  BoardRepository boardRepository;
    private final ClothesRepository clothesRepository;
    private final ClothesPhotoRepository clothesPhotoRepository;
    private final ArClothesRepository arClothesRepository;
    private final PetsnalColorRepository petsnalColorRepository;

    private final PetsizeRepository petsizeRepository;

    @Autowired
    public SpringConfig(BreedTagRepository breedTagRepository, ColorRepository colorRepository, PersonalColorRepository personalColorRepository, PreferRepository preferRepository, SizeRepository sizeRepository, StoreRepository storeRepository, UserRepository userRepository             ,CommentRepository commentRepository, BoardRepository boardRepository, ClothesRepository clothesRepository, ClothesPhotoRepository clothesPhotoRepository ,ArClothesRepository arClothesRepository, PetsnalColorRepository petsnalColorRepository, PetsizeRepository petsizeRepository) {

        this.breedTagRepository = breedTagRepository;
        this.colorRepository = colorRepository;
        this.personalColorRepository = personalColorRepository;
        this.preferRepository = preferRepository;
        this.sizeRepository = sizeRepository;
        this.storeRepository = storeRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.boardRepository = boardRepository;
        this.clothesRepository = clothesRepository;
        this.clothesPhotoRepository = clothesPhotoRepository;
        this.arClothesRepository = arClothesRepository;
        this.petsnalColorRepository = petsnalColorRepository;
        this.petsizeRepository = petsizeRepository;
    }
}
