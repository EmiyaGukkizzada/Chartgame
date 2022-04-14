package com.example.chartgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chartgame.dao.MyPageDao;
import com.example.chartgame.model.Member;

@Service
public class MyPageServiceImpl implements MyPageService {
	
	@Autowired
	private MyPageDao md;
	
	@Override
	public Member myPage(String sessionId, Member member) {
		System.out.println("MyPageServiceImpl myPage start...");
		member = md.myPage(sessionId, member);
		System.out.println("MyPageServiceImpl myPage member -> " + member);
		
		return member;
	}
}
