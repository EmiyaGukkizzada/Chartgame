package com.example.chartgame.service;

import com.example.chartgame.model.Member;

public interface MemberService {
	
	int memberJoin(Member member);
	
	int memberIdChk(Member member);
}
