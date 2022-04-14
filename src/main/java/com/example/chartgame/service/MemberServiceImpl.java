package com.example.chartgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chartgame.dao.MemberDao;
import com.example.chartgame.model.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao md;
	
	@Override
	public int memberJoin(Member member) {
		
		System.out.println("MemberServiceImpl memberJoin() start...");
		
		int result = md.memberJoin(member);
		System.out.println("MemberServiceImpl memberJoin() result -> " +result);
		
		return result;
	}

	@Override
	public int memberIdChk(Member member) {
		System.out.println("MemberServiceImpl memberIdChk() start...");
		int result = md.memberIdChk(member);
		System.out.println("MemberServiceImpl memberIdChk() result -> " + result);
		return result;
	}

}
