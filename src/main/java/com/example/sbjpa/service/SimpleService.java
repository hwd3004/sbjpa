package com.example.sbjpa.service;

import java.util.List;
import java.util.Optional;

import com.example.sbjpa.model.Board;
import com.example.sbjpa.model.Simple;
import com.example.sbjpa.repository.BoardRepository;
import com.example.sbjpa.repository.SimpleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SimpleService {

	@Autowired
	private SimpleRepository simpleRepository;

	@Transactional(readOnly = true)
	public List<Simple> findeAll() {
		return simpleRepository.findAll();
	}

	@Transactional
	public Simple create(Simple simple) {
		return simpleRepository.save(simple);
	}
}
