package com.Beom.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TestController {
	
	@GetMapping("/")
	public String test() {
		//trace, debug, info, warn, error
		log.error("익셉션 빌생");
		log.warn("warn message");
		log.info("카카오 api키");
		log.debug("debug message");
		log.trace("trace message");
		
		return "index";
	}
}
