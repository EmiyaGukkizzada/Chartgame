package com.example.chartgame.controller;

//import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.chartgame.model.Member;
import com.example.chartgame.service.FindService;

//아이디, 비밀번호 찾기
@Controller
public class FindController {
	
	@Autowired
	private FindService fs;
	
	/*
	@Autowired
	private JavaMailSender mailSender;
	*/
	@RequestMapping(value = "findId")
	public String findId() {
		return "findId";
	}
	
	@RequestMapping(value = "findIdResult")
	public String findId(Member member, Model model) {
		System.out.println("FindController findId start...");
		String fid = null;
		fid = fs.findId(member);
		System.out.println("fid-> " + fid);
		model.addAttribute("fid", fid);
		
		return "findIdResult";
	}
	
	@RequestMapping(value = "findPw")
	public String findPw() {
		return "findPw";
	}
	/* 개인정보로 인하여 임시 패스워드 발송 기능은 막아 두었습니다. 
	@RequestMapping(value = "findPwResult")
	public String findPwResult(Member member, Model model) {
		System.out.println("findController pwfind start...");
		System.out.println("mailSending...");
		String tomail = member.getEmail();	//받는사람 이메일
		System.out.println(tomail);
		String setform = "it118197@gmail.com";
		String title = "차트게임 임시 비밀번호";
		
		try {
			// 1. Mime 전자우편 Internet 표준 Format
			MimeMessage message = mailSender.createMimeMessage();
			// 2. MimeMessage -> MimeMessageHelper
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
			messageHelper.setFrom(setform); 	//보내는사람 생략하면 정상작동 안함.
			messageHelper.setTo(tomail); 		//받는사람 이메일
			messageHelper.setSubject(title); 	//메일제목은 생략 가능
			String tempPassword = (int)(Math.random() * 999999) + 1 + "";
			messageHelper.setText("임시 비밀번호 : " + tempPassword);
			System.out.println("임시 비밀번호 : " + tempPassword);
			mailSender.send(message);
			member.setPw(tempPassword);
			int result = 0;
			result = fs.findPwResult(member);
			model.addAttribute("result", result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "findPwResult"; 
	}
	*/
}
