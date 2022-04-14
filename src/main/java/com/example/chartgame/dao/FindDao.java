package com.example.chartgame.dao;

import com.example.chartgame.model.Member;

public interface FindDao {
	String findId(Member member);
	String findPw(Member member);
	int findPwResult(Member member);
}
