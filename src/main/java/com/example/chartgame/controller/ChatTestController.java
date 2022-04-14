package com.example.chartgame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatTestController {
	
	@GetMapping("/")
	public String chat() {
		return "chat";
	}
	
}
