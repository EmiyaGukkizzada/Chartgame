package com.example.chartgame.dao;

import com.example.chartgame.model.Member;

public interface MyPageDao {

	Member myPage(String sessionId, Member member);

}
