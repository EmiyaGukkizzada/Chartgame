package com.example.chartgame.service;

import java.util.List;

import com.example.chartgame.model.Member;

public interface LoginService {
	List<Member> getIdPw(String id);
}
