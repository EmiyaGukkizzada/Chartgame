package com.example.chartgame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class URLController {
	
	@RequestMapping(value = "getUrl", produces = "application/text;charset=UTF-8")
	@ResponseBody
	public String getUrl(String url) {
		System.out.println("URLController getURL -> " + url);
		
		return url;
	}
}
