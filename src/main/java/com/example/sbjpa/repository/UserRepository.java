package com.example.sbjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sbjpa.model.User;

// DAO
// 자등으로 bean 등록
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByuserId(String userId);

	User findByuserName(String userName);

	@Query(value = "select * from user where userId = ?1 and password = ?2", nativeQuery = true)
	User login(String userId, String password);

	User findByuserIdAndPassword(String userId, String password);

}
