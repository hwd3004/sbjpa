package com.example.sbjpa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.sbjpa.service.BoardService;

@Controller
public class WebController {

	@Autowired
	private BoardService boardService;

	@GetMapping({ "/", "" })
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}

	@GetMapping("/post/create")
	public String post_create() {
		return "/post/create";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("principal");

		return "redirect:/";
	}

	@GetMapping("/post/{id}")
	public String post() {
		return "/post/detail";
	}

	@GetMapping("/index2")
	public String index2(HttpServletRequest httpServletRequest, Model model) {
		try {

			String queryString = httpServletRequest.getQueryString();

			int boardsPerPage = 3;
			int offset = 0;
			int limit = boardsPerPage;
			long count = boardService.countBoards();

			long totalPage = 0;

			if (count % boardsPerPage == 0) {
				totalPage = count / boardsPerPage;
			} else {
				totalPage = count / boardsPerPage + 1;
			}

			System.out.println("totalPage : " + totalPage);

			if (queryString == null) {
				model.addAttribute("boards", boardService.findBoards(limit, offset));
				model.addAttribute("totalPage", totalPage);

			} else {
				int page = Integer.parseInt(queryString.split("=")[1]);

				offset = page * boardsPerPage - boardsPerPage;

				model.addAttribute("boards", boardService.findBoards(limit, offset));
				model.addAttribute("totalPage", totalPage);
			}

			return "/index2";

		} catch (Exception e) {
			e.printStackTrace();
			return "/index2";
		}

	}

}
