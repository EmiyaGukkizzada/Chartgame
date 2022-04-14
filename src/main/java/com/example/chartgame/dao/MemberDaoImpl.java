package com.example.chartgame.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.chartgame.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int memberJoin(Member member) {
		int result = 0;
		System.out.println("MemberDaoImpl memberJoin() start...");
		try {
			result = session.insert("memberJoin", member);
		} catch (Exception e) {
			System.out.println("MemberDaoImpl memberJoin() Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public int memberIdChk(Member member) {
		int result = 0;
		
		System.out.println("MemberDaoImpl memberIdChk() start...");
		try {
			result = session.selectOne("memberIdChk", member);
		} catch (Exception e) {
			System.out.println("MmeberDaoImpl memberIdChk() Exception -> " + e.getMessage());
		}
		return result;
	}
}
