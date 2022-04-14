package com.example.chartgame.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.chartgame.model.Emp;
import com.example.chartgame.model.Member;
import com.example.chartgame.service.EmpService;
import com.example.chartgame.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService ls;
	
	@Autowired
	private EmpService empService;
	
	//로그인페이지에서 id, pw 값이 날라옴, id pw 값이 맞는지 확인용
	@PostMapping(value = "loginDo")
	@ResponseBody
	public List<Member> loginDo(String id){
		System.out.println("LoginController loginDo() start...");
		
		List<Member> data = ls.getIdPw(id);
		System.out.println("이름 확인 -> " + data.get(0).getName());
		System.out.println("아이디 확인 -> " + data.get(0).getId());
		System.out.println("확인중인 state -> " + data.get(0).getState());
		System.out.println("현금확인 cash -> " + data.get(0).getCash());
		if (data.get(0).getState()==2 || data.get(0).getState()==4) {
			Emp emp = empService.selectEmp(id);
			System.out.println("emp.getEmpno()-> " + emp.getEmpno());
			System.out.println("emp.getDept()-> " + emp.getDept());
			data.get(0).setEmpno(emp.getEmpno());
			data.get(0).setDept(emp.getDept());
		}
		
		return data;
	}
	
	//로그아웃
	@GetMapping(value = "logout")
	public String logout(HttpServletRequest request) {
		System.out.println("LoginController logout() start...");
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:index2";
	}
}
