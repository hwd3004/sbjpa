package com.example.sbjpa.controller.apiController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbjpa.dto.ResponseDto;
import com.example.sbjpa.model.User;
import com.example.sbjpa.service.UserService;

@RestController
public class UserApiContriller {

	@Autowired
	private UserService userService;

	@PostMapping("/api/signup")
	public ResponseDto<String> signup(User user) {
		return userService.signup(user);
	}

	@PostMapping("/api/login")
	public ResponseDto<String> login(User user, HttpSession session) {
		if (user.getUserId().length() < 3) {
			return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), "id 입력 필요");
		}

		if (user.getPassword().length() < 3) {
			return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), "password 필요");
		}

		User principal = userService.login(user);

		if (principal == null) {
			return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), "없는 id");
		}

		if (!principal.getPassword().equals(user.getPassword())) {
			return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), "비밀번호 일치하지 않음");
		}

		session.setAttribute("principal", principal);

		return new ResponseDto<>(HttpStatus.OK.value(), "로그인 성공");

	}

}
