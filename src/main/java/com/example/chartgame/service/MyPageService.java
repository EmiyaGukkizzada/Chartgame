package com.example.chartgame.service;

import com.example.chartgame.model.Member;

public interface MyPageService {

	Member myPage(String sessionId, Member member);

}
