package com.example.sbjpa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.sbjpa.dto.ResponseDto;
import com.example.sbjpa.model.Board;
import com.example.sbjpa.model.User;
import com.example.sbjpa.service.BoardService;
import com.example.sbjpa.service.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private StorageService storageService;

    @GetMapping("/api/post/index")
    public List<Board> post_index(int page) {
        try {
            System.out.println("asd page : " + page);

            int offset;

            if (page == 0) {
                offset = 0;
            } else {
                offset = page * 2 - 2;
            }

            List<Board> list = boardService.list(offset);

            System.out.println("asd list : " + list);
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/api/post/create")
    public ResponseDto<Integer> post_create(Board board, MultipartFile[] file, HttpSession session) {
        try {
            // MultipartFile[] file
            // 배열로 받아야함

            User user = (User) session.getAttribute("principal");

            if (user == null) {
                return new ResponseDto<>(HttpStatus.OK.value(), -1);
            }

            // System.out.println("board : " + board);
            // System.out.println("session : " + session.getAttribute("principal"));
            // System.out.println("user : " + user);

            Board createVO = new Board();
            createVO.setTitle(board.getTitle());
            createVO.setContent(board.getContent());
            createVO.setUser(user);

            // System.out.println("createVO : " + createVO);

            boardService.create(createVO);

            Board lastBoard = boardService.findLastBoard();

            // System.out.println("lastBoard : " + lastBoard);

            // System.out.println("file length : " + file.length);

            storageService.createFile(lastBoard, file);

            return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
        } catch (Exception e) {
            e.printStackTrace();

            return new ResponseDto<Integer>(HttpStatus.OK.value(), -1);
        }
    }

}
