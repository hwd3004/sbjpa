package com.example.sbjpa.controller.apiController;

import java.io.File;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.sbjpa.dto.BoardResponseDto;
import com.example.sbjpa.dto.ResponseDto;
import com.example.sbjpa.model.Board;
import com.example.sbjpa.model.Storage;
import com.example.sbjpa.model.User;
import com.example.sbjpa.service.BoardService;
import com.example.sbjpa.service.StorageService;

@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private StorageService storageService;

	@GetMapping("/api/post/{id}")
	public BoardResponseDto post(@PathVariable int id) {
		Optional<Board> board = boardService.findById(id);

		BoardResponseDto response = new BoardResponseDto();

		if (board.isEmpty()) {
			return null;
		}

		if (!board.isEmpty()) {
			response.setBoard(board);

			int boardId = board.get().getId();

			List<Storage> storages = storageService.findStorages(boardId);

			response.setStorages(storages);

		} else {
			response.setBoard(null);
		}

		return response;
	}

	@GetMapping("/api/post/index")
	public BoardResponseDto post_index(@RequestParam(required = false, defaultValue = "1") int page) {
		try {
			List<Board> boards;
			int offset;

			if (page == 1) {
				offset = 0;
			} else {
				offset = page * 2 - 2;
			}

			boards = boardService.boardsOffset(offset);

			BoardResponseDto boardResponseDto = new BoardResponseDto();

			boardResponseDto.setBoards(boards);

			return boardResponseDto;
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping("/api/post/create")
	public ResponseDto<String> post_create(Board board, MultipartFile[] file, HttpSession session) {
		try {
			// MultipartFile[] file
			// 배열로 받아야함

			User currentUser = (User) session.getAttribute("principal");

			if (currentUser == null) {
				return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), "로그인 필요");
			}

			Board newBoard = new Board();
			newBoard.setTitle(board.getTitle());
			newBoard.setContent(board.getContent());
			newBoard.setUser(currentUser);

			Board createdBoard = boardService.create(newBoard);
			System.out.println("createdBoard : " + createdBoard);

//			Board lastBoard = boardService.findLastBoard();

			storageService.createFile(createdBoard, file);

			return new ResponseDto<String>(HttpStatus.OK.value(), "글 생성 완료");
		} catch (Exception e) {
			System.out.println(e);

			return new ResponseDto<String>(HttpStatus.BAD_REQUEST.value(), "에러");
		}
	}

	@GetMapping("/download/{id}")
	public ResponseEntity<Object> download(@PathVariable int id) {
		try {
			Optional<Storage> storage = storageService.findStorage(id);

			String path = storage.get().getPath();

			String absolutePath = new File("").getAbsolutePath() + "\\";
			// System.out.println("asd path : " + absolutePath);
			// System.out.println("asd path : " + absolutePath + "/" + path);

			path = absolutePath + "/" + path;

			Path filePath = Paths.get(path);

			// System.out.println(filePath);

			Resource resource = new InputStreamResource(Files.newInputStream(filePath));

			// System.out.println(resource);

			// File file = new File(path);

			// System.out.println(file);

			HttpHeaders headers = new HttpHeaders();

			// System.out.println(headers);

			// System.out.println(file.getName());

			// headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());

			String filename = URLEncoder.encode(storage.get().getFilename(), "UTF-8");
			filename = filename.replaceAll("\\+", "%20");

			headers.setContentDisposition(ContentDisposition.builder("attachment").filename(filename).build());

			// System.out.println(headers);

			// return null;

			// return new FileResponseDto(resource, headers, HttpStatus.OK.value());
			return new ResponseEntity<Object>(resource, headers, HttpStatus.OK.value());
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}

}
