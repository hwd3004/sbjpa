package com.example.sbjpa.controller;

import javax.servlet.http.HttpSession;

import com.example.sbjpa.dto.ResponseDto;
import com.example.sbjpa.model.User;
import com.example.sbjpa.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiContriller {

	@Autowired
	private UserService userService;

	@PostMapping("/api/signup")
	public ResponseDto<Integer> signup(User user) {

		User signupUser = userService.signup(user);

		System.out.println("asdasd signupUser : " + signupUser);

		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

	@PostMapping("/api/login")
	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
		User principal = userService.login(user);

		System.out.println(principal);

		if (principal != null) {
			session.setAttribute("principal", principal);

			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
		} else {
			return new ResponseDto<>(HttpStatus.OK.value(), -1);
		}

	}

}
