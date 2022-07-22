package com.example.sbjpa.controller.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbjpa.model.Simple;
import com.example.sbjpa.service.SimpleService;

@RestController
public class SimpleApiController {

	@Autowired
	private SimpleService simpleService;

	@GetMapping("/api/simple/index")
	public List<Simple> index() {
		return simpleService.findeAll();
	}

	@PostMapping("/api/simple/create")
	public Simple create(Simple simple) {
		System.out.println("simple : " + simple);

		Simple res = simpleService.create(simple);

		System.out.println("res : " + res);

		return res;
	}

}
