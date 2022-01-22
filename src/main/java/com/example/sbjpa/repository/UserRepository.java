package com.example.sbjpa.repository;

import com.example.sbjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// DAO
// 자등으로 bean 등록
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // 대소문자 잘지켜야함
    // User findByUseridAndPassword(String userId, String password);

    @Query(value = "select * from where userId = ?1 and where password = ?2", nativeQuery = true)
    User login(String userId, String password);
}
