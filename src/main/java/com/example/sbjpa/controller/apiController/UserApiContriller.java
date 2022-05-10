package com.example.sbjpa.controller.apiController;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		try {
			userService.signup(user);
			return new ResponseDto<String>(HttpStatus.OK.value(), "완료");
		} catch (Exception e) {
			System.out.println("===========================");
			System.out.println("getLocalizedMessage");
			System.out.println(e.getLocalizedMessage());
			System.out.println("===========================");
			System.out.println("getMessage");
			System.out.println(e.getMessage());
			System.out.println("===========================");
			System.out.println("toString");
			System.out.println(e.toString());
			System.out.println("===========================");
			System.out.println("getStackTrace");
			System.out.println(e.getStackTrace());
			System.out.println("===========================");

			return new ResponseDto<String>(HttpStatus.BAD_REQUEST.value(), "실패");
		}
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
