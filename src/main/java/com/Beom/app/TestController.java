package com.Beom.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TestController {


	@GetMapping("/")
	public String test() {

		return "index";
	}
	
	@GetMapping("/expired")
	public String expired(Model model) {
		model.addAttribute("result", "로그아웃");
		model.addAttribute("path", "/");
		System.out.println("들어왓니 ?");
		return "commons/result";
	}
}
