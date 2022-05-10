package com.example.sbjpa.service;

import com.example.sbjpa.dto.ResponseDto;
import com.example.sbjpa.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbjpa.repository.UserRepository;

// 서비스 어노테이션이 선언된 클래스에는 비지니스 로직을 작성하는 곳이며,
// 스프링 측에서 익셉션 핸들링을 해주려고 개선 작업 중이다
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public User login(User user) {
		return userRepository.login(user.getUserId(), user.getPassword());
	}

	@Transactional
	public User signup(User user) {
		User result = userRepository.save(user);

//			System.out.println(result);
//			User(id=3, userId=asd, userName=asd, password=asd, role=null, createdAt=2022-05-09 18:16:52.851)

//			중복시 SQL Error: 1062, SQLState: 23000
		return result;
	}
}
