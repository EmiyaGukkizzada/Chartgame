package com.example.chartgame.controller;

/*import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.concurrent.Executors;*/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class maincontroller {
	
	@RequestMapping(value = "index2", method = {RequestMethod.POST, RequestMethod.GET})
	
	/* 로그인 상태 및 자산 session저장 */
	
	public String gomain(HttpServletRequest request, Model model) {
		System.out.println("MainController start...");

		
		HttpSession session = null;
		
		session = request.getSession();
		System.out.println("request.getParameter(id) -> " + request.getParameter("id"));
		System.out.println("request.getParameter(state) -> " + request.getParameter("state"));
		System.out.println("request.getParameter(Img) -> " + request.getParameter("Img"));
		System.out.println("request.getParameter(name) -> " + request.getParameter("name"));
		System.out.println("request.getParameter(cash) -> " + request.getParameter("cash"));
		
		if (request.getParameter("id") != null) {
			session.setAttribute("sessionId", request.getParameter("id"));
			session.setAttribute("sessionState", request.getParameter("state"));
			session.setAttribute("sessionImg", request.getParameter("Img"));
			session.setAttribute("sessionName", request.getParameter("name"));
			session.setAttribute("sessionEmpno", request.getParameter("empno"));
			session.setAttribute("sessionDept", request.getParameter("dept"));
			session.setAttribute("sessionCash", request.getParameter("cash"));
		}
		  System.out.println("request.getParameter(state)->"+request.getParameter("state"));
		  
	      System.out.println("sessionId->"+session.getAttribute("sessionId"));
	      System.out.println("sessionState->"+session.getAttribute("sessionState"));
	      System.out.println("sessionImg -> " + session.getAttribute("sessionImg"));
	      System.out.println("sessionName->"+session.getAttribute("sessionName"));
	      System.out.println("sessionEmpno->"+session.getAttribute("sessionEmpno"));
	      System.out.println("sessionDept->"+session.getAttribute("sessionDept"));
	      System.out.println("sessionCash->"+session.getAttribute("sessionCash"));
	      
	      model.addAttribute("sessionId", session.getAttribute("sessionId"));
	      model.addAttribute("sessionState",session.getAttribute("sessionState"));
	      model.addAttribute("sessionImg", session.getAttribute("sessionImg"));
	      model.addAttribute("sessionName",session.getAttribute("sessionName"));
	      model.addAttribute("sessionEmpno",session.getAttribute("sessionEmpno"));
	      model.addAttribute("sesssionDept",session.getAttribute("sessionDept"));
	      model.addAttribute("sesssionCash",session.getAttribute("sessionCash"));
	      
			/* cmd명령어 자동실행(node kline, node restproxy) */
	      
	     /* try {
			Process process = Runtime.getRuntime().exec("cmd");
			//Process의 각 stream을 받는다.
			//process의 입력 stream
			OutputStream stdin = process.getOutputStream();
			//process의 에러 stream
			InputStream stderr = process.getErrorStream();
			//process의 출력 stream
			InputStream stdout = process.getInputStream();
			
			//쓰레드 풀을 이용해서 3개의 stream을 대기시킨다.
			
			//출력 stream을 BufferedReader로 받아서 라인 변경이 있을 경우 console 화면에 출력시킨다.
			Executors.newCachedThreadPool().execute(() -> {
				//문자 깨짐이 발생할 경우 InputStreamReader(stdout)에 인코딩 타입을 넣는다. ex) InputStreamReader(stdout, "euc-kr")
				//try (BufferedReader reader = new BufferedReader(new InputStreamReader(stdout, "euc-kr"))) {
				try (BufferedReader reader = new BufferedReader(new InputStreamReader(stdout))) {
					String line;
					while ((line = reader.readLine()) != null) {
						System.out.println(line);
					}
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			});
			
			//에러 stream을 BufferedReader로 받아서 에러가 발생할 경우 console 화면에 출력시킨다.
			Executors.newCachedThreadPool().execute(() -> {
			// 문자 깨짐이 발생할 경우 InputStreamReader(stdout)에 인코딩 타입을 넣는다. ex) InputStreamReader(stdout, "euc-kr")
			// try (BufferedReader reader = new BufferedReader(new InputStreamReader(stderr, "euc-kr"))) {
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(stderr))) {
			  String line;
			while ((line = reader.readLine()) != null) {
				System.out.println("err " + line);
			  }
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		});
		
			//입력 stream을 BufferedWriter로 받아서 콘솔로부터 받은 입력을 Process 클래스로 실행시킨다.
		Executors.newCachedThreadPool().execute(() -> {
			// Scanner 클래스는 콘솔로 부터 입력을 받기 위한 클래스 입니다.
		 try (Scanner scan = new Scanner(System.in)) {
			try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin))) {
			  while (true) {
			    // 콘솔로 부터 엔터가 포함되면 input String 변수로 값이 입력됩니다.
				String input = scan.nextLine();
				// 콘솔에서 \n가 포함되어야 실행된다.(엔터)
				input += "\n";
				writer.write(input);
				// Process로 명령어 입력
				writer.flush();
				// exit 명령어가 들어올 경우에는 프로그램을 종료합니다.
				if ("exit\n".equals(input)) {
					 System.exit(0);
				}
			  }
			} catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			  }
			}
		  });

		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}	*/
	      
	      
		return "main";  
	}
	
	
}
