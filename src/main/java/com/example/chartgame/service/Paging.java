package com.example.chartgame.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {
	//1번페이지									//9번


	private int currentPage = 1;	private int rowPage = 9;


	//페이지 블럭 최대 10까지 [1][2]~[10]
	private int pageBlock = 10;		private int end;
	private int start;				private int endPage;
	private int startPage;			private int totalPage;
	private int total;
				//     12			    
	public Paging(int total, String currentPage1) {
		this.total = total; // 12
		System.out.println("total -> " + total);
		
		if(currentPage1 == null) {
			this.currentPage = 1;
		}else {
			this.currentPage = Integer.parseInt(currentPage1);
		}
		// currentPage: 시작block 번호 : 1이면
		// pagerow1
		start = (currentPage - 1) * rowPage + 1; // 시작 1
		//5                           10    + 1;
		end = start + rowPage - 1; // 10 즉 start~end : 1~10
		
		//	1.2 ->올림해서 2					12		5
		//3
		totalPage = (int)Math.ceil((double)total / rowPage);
		System.out.println("totalPage->" + totalPage);
	//		pageblock1 =			1								10		
		startPage = currentPage - (currentPage - 1) % pageBlock;
	//		10 = 	1		+	10		-1
		endPage = startPage + pageBlock - 1;
	//		10	>		1
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getRowPage() {
		return rowPage;
	}
	public void setRowPage(int rowPage) {
		this.rowPage = rowPage;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

}
