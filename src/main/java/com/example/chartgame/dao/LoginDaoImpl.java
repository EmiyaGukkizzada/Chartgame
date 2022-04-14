package com.example.chartgame.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.chartgame.model.Member;

@Repository
public class LoginDaoImpl implements LoginDao {
	// JDBC = DataSource, JPA = EntityManager, MyBatis = SqlSession
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Member> getIdPw(String id) {
		System.out.println("LoginDaoImpl getIdPw() start...");
		
		List<Member> data = null;
		try {
			data = session.selectList("GetIdPw", id);
			System.out.println("state -> " + data.get(0).getState());
			System.out.println("name -> " + data.get(0).getName());
			System.out.println("Img -> " + data.get(0).getImg());
			System.out.println("cash-> " + data.get(0).getCash());
			System.out.println("cash 자료형-> " + data.get(0).getCash().getClass().getName());
		} catch (Exception e) {
			System.out.println("LoginDaoImpl getIdPw() Error -> " + e.getMessage());
		}
		
		return data;
	}

}
