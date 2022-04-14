package com.example.chartgame.service;

import com.example.chartgame.model.Member;

public interface FindService {

	String findId(Member member);
	String findPw(Member member);
	int findPwResult(Member member);
	
}
