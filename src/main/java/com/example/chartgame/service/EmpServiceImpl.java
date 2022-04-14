package com.example.chartgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chartgame.dao.EmpDao;
import com.example.chartgame.model.Emp;
import com.example.chartgame.model.Member;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpDao empDao;
	
	@Override
	public Emp selectEmp(String id) {
		Emp emp = empDao.selectEmp(id);
		
		return emp;
	}
	
	@Override
	public int newEmp(Member member, String dept) {
		int result = empDao.insertEmp(member, dept);
		return result;
	}

}
