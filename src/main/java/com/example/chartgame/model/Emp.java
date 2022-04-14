package com.example.chartgame.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Emp {
	private int empno;
	private String id;
	private String dept;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	
}
