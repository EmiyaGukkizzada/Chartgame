package com.example.chartgame.dao;

import java.util.List;

import com.example.chartgame.model.Member;

public interface LoginDao {
	List<Member> getIdPw(String id);
}
