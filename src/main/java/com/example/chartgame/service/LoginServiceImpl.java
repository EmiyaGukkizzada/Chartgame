package com.example.chartgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chartgame.dao.LoginDao;
import com.example.chartgame.model.Member;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao Id;
	
	@Override
	public List<Member> getIdPw(String id) {
		System.out.println("LoginServiceImpl getIdPw() start...");
		
		return Id.getIdPw(id);
	}

}
