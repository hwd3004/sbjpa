package com.example.sbjpa.repository;

import com.example.sbjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


// DAO
// 자등으로 bean 등록
// @Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {
}
