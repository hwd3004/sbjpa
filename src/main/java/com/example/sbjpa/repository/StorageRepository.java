package com.example.sbjpa.repository;

import com.example.sbjpa.model.Storage;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Integer> {

}
