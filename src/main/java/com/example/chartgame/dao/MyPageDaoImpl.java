package com.example.chartgame.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.chartgame.model.Member;

@Repository
public class MyPageDaoImpl implements MyPageDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public Member myPage(String sessionId, Member member) {
		System.out.println("MyPageDaoImpl myPage start...");
		try {
			member = session.selectOne("MemberMyPage", sessionId);
		} catch (Exception e) {
			System.out.println("MyPageDaoImpl myPage Exception -> " + e.getMessage());
		}
		
		return member;
	}
}
