package com.example.sbjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sbjpa.model.Simple;

@Repository
public interface SimpleRepository extends JpaRepository<Simple, Integer> {

}
