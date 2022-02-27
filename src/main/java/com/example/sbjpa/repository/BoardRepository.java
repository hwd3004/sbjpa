package com.example.sbjpa.repository;

import com.example.sbjpa.model.Board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    @Query(value = "SELECT id FROM board ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Board findLastBoard();
}
