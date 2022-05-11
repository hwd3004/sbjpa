package com.example.sbjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbjpa.dto.ResponseDto;
import com.example.sbjpa.model.User;
import com.example.sbjpa.repository.UserRepository;

// 서비스 어노테이션이 선언된 클래스에는 비지니스 로직을 작성하는 곳이며,
// 스프링 측에서 익셉션 핸들링을 해주려고 개선 작업 중이다
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public User login(User user) {
		User tryLogin = userRepository.findByuserId(user.getUserId());

		return tryLogin;
	}

	@Transactional
	public ResponseDto<String> signup(User user) {
		if (user.getUserId().length() < 3) {
			return new ResponseDto<String>(HttpStatus.BAD_REQUEST.value(), "id 3자 이상 입력");
		}

		if (user.getUserName().length() < 3) {
			return new ResponseDto<String>(HttpStatus.BAD_REQUEST.value(), "user name 3자 이상 입력");
		}

		if (user.getPassword().length() < 3) {
			return new ResponseDto<String>(HttpStatus.BAD_REQUEST.value(), "password 3자 이상 입력");
		}

		User existUserId = userRepository.findByuserId(user.getUserId());

		if (existUserId != null) {
			return new ResponseDto<String>(HttpStatus.BAD_REQUEST.value(), "이미 있는 id");
		}

		User existUserName = userRepository.findByuserName(user.getUserName());

		if (existUserName != null) {
			return new ResponseDto<String>(HttpStatus.BAD_REQUEST.value(), "이미 있는 user name");
		}

		userRepository.save(user);

		return new ResponseDto<String>(HttpStatus.OK.value(), "가입 완료");
	}
}
