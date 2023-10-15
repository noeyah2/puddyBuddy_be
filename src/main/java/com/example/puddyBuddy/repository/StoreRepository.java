package com.example.puddyBuddy.repository;

import com.example.puddyBuddy.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findAll();
}
