package com.example.chartgame.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.chartgame.model.Member;
import com.example.chartgame.service.MyPageService;

@Controller
public class mypageController {
	
	@Autowired
	private MyPageService ms;
	
	@RequestMapping(value = "myPage")
	public String myPage(HttpServletRequest request, Model model, Member member) {
		System.out.println("MyPageController myPage start...");
		String sessionId = (String)request.getSession().getAttribute("sessionId");
		System.out.println("sessionId -> " + sessionId);
		member = ms.myPage(sessionId, member);
		model.addAttribute("member", member);
		
		return "myPage";
		
	}
}
