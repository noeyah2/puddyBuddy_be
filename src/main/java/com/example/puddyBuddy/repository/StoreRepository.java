package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findAll();

    Optional<Store> findByStoreId(Long storeId);
}
