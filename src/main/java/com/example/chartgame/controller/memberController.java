package com.example.chartgame.controller;


import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.chartgame.model.Member;
import com.example.chartgame.service.EmpService;
import com.example.chartgame.service.MemberService;
import com.example.chartgame.service.PortFolioService;



@Controller
public class memberController {
	
	@Autowired
	private MemberService ms;
	@Autowired
	private EmpService empService;
	@Autowired 
	private PortFolioService pfs;
	
	@RequestMapping(value = "memberJoinForm")
	public String memberJoinForm(Model model) {
		System.out.println("MemberController memberJoin() Start...");
		return "memberJoinForm";
	}
	
	//회원가입
	@RequestMapping(value = "memberJoin")
	public String memberJoin(Model model, Member member, HttpServletRequest request) {
		System.out.println("MemberController memberJoin() Start..." );
		/* System.out.println("request dept -> " + request.getParameter("dpet")); */
		int result = 0;
		
		/*회원가입에서 지급되는 초기자금*/
		int i = 2000000;
		BigInteger firstcash = BigInteger.ONE;
		BigInteger cash;
		cash = firstcash.multiply(BigInteger.valueOf(i));
		System.out.println("afterBigNum ->"+ cash);
		result = ms.memberJoin(member);
		pfs.newPortFolio(member, cash);
		/*직원 회원가입분류*/
		String state = request.getParameter("state");
		String dept= request.getParameter("dept");
		
		if ("2".equals(state))	{
			if (dept != null) {
					System.out.println("request dept -> " + dept);
					result = empService.newEmp(member, dept);
				}
		}
		model.addAttribute("result", result);
		
		return "memberJoinPro";
	}
	
	//회원가입 -> 아이디 중복체크
	@ResponseBody /*ResponseBody어노테이션은 클라이언트와 서버의 비동기 통신 (ajax , fetch API)의 JSON 주고받기*/
	@RequestMapping(value = "memberIdChk", method = RequestMethod.POST)
	public int memberIdChk(Member member) {
		System.out.println("MemberController memberIdChk() Start...");
		int result = ms.memberIdChk(member);
		
		return result;
	}
}
