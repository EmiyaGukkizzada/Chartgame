package com.example.chartgame.dao;

import com.example.chartgame.model.Emp;
import com.example.chartgame.model.Member;

public interface EmpDao {
	
	Emp selectEmp(String id);
	
	int insertEmp(Member member, String dept);
}
