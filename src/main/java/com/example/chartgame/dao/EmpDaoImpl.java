package com.example.chartgame.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.chartgame.model.Emp;
import com.example.chartgame.model.Member;
@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	SqlSession session;
	
	@Override
	public Emp selectEmp(String id) {
		Emp emp = session.selectOne("empSelect", id);
		
		return emp;
	}
	
	@Override
	public int insertEmp(Member member, String dept) {
		Emp emp = new Emp();
		emp.setDept(dept);
		emp.setId(member.getId());
		int result = session.insert("empInsert",emp);
		
		return result;
	}

}
