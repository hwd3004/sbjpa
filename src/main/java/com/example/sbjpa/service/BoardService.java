package com.example.sbjpa.service;

import java.util.List;
import java.util.Optional;

import com.example.sbjpa.model.Board;
import com.example.sbjpa.repository.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Transactional
	public Board create(Board createVO) {
		return boardRepository.save(createVO);
	}

	@Transactional(readOnly = true)
	public Optional<Board> findById(int id) {
		Optional<Board> board = boardRepository.findById(id);

		return board;
	}

	@Transactional(readOnly = true)
	public List<Board> boardsOffset(int offset) {
		return boardRepository.findBoardsOffset(offset);
	}

	@Transactional(readOnly = true)
	public List<Board> findBoards(int limit, int offset) {
		return boardRepository.findBoards(limit, offset);
	}

	@Transactional(readOnly = true)
	public long countBoards() {
		return boardRepository.count();
	}

	@Transactional(readOnly = true)
	public Board findLastBoard() {
		return boardRepository.findLastBoard();
	}

}
