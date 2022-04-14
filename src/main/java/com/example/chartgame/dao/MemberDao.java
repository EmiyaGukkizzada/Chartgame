package com.example.chartgame.dao;

import com.example.chartgame.model.Member;

public interface MemberDao {
	
	int memberJoin(Member member);

	int memberIdChk(Member member);
}
