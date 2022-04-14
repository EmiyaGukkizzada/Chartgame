package com.example.chartgame.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PriceDisplayController {
	
	@RequestMapping(value = "getPriceCal", produces = "application/text;charset=UTF-8")
	@ResponseBody
	public String getPriceCal(String price, String cash) {
	
		return price; /* 배열로 두값을 모두 보내줘야함 */
	}
	
}
