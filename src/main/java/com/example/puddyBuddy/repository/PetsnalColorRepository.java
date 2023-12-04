package com.example.puddyBuddy.repository;
import com.example.puddyBuddy.domain.Board;
import com.example.puddyBuddy.domain.PersonalColor;
import com.example.puddyBuddy.domain.PetsnalColor;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PetsnalColorRepository extends JpaRepository<PetsnalColor, Long> {
    List<PetsnalColor> findAll();

    List<PetsnalColor> findPhotoUrlByStageIdAndPrefer_PreferIdOrderByPetsnalColorIdAsc(Long stageId, Long preferId);

    List<PetsnalColor> findByPreferIdOrderByPetsnalColorIdAsc(Long PreferId);
}
