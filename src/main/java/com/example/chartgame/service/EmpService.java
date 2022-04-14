package com.example.chartgame.service;

import com.example.chartgame.model.Emp;
import com.example.chartgame.model.Member;



public interface EmpService {
	Emp selectEmp(String id);
	
	int newEmp(Member member, String dept);
	
}
