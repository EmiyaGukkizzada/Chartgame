package com.example.chartgame.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeBoard {
	private int nbnum;
	private String id;
	private String nbtitle;
	private Date   nbdate;
	private int    nbcount;
	private String nbcontent;
	private String nbimg;
	
	public int getNbnum() {
		return nbnum;
	}
	public void setNbnum(int nbnum) {
		this.nbnum = nbnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNbtitle() {
		return nbtitle;
	}
	public void setNbtitle(String nbtitle) {
		this.nbtitle = nbtitle;
	}
	public Date getNbdate() {
		return nbdate;
	}
	public void setNbdate(Date nbdate) {
		this.nbdate = nbdate;
	}
	public int getNbcount() {
		return nbcount;
	}
	public void setNbcount(int nbcount) {
		this.nbcount = nbcount;
	}
	public String getNbcontent() {
		return nbcontent;
	}
	public void setNbcontent(String nbcontent) {
		this.nbcontent = nbcontent;
	}
	public String getNbimg() {
		return nbimg;
	}
	public void setNbimg(String nbimg) {
		this.nbimg = nbimg;
	}
	
	
}
