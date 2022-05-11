package com.example.sbjpa.repository;

import java.util.List;

import com.example.sbjpa.model.Storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Integer> {

    @Query(value = "SELECT * FROM STORAGE WHERE boardId = :boardId", nativeQuery = true)
    List<Storage> findAllById(@Param(value = "boardId") int boardId);
}
