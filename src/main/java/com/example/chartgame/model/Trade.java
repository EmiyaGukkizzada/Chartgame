package com.example.chartgame.model;

import java.math.BigInteger;
import java.sql.Date;

import lombok.*;

@Getter
@Setter
public class Trade {
	private BigInteger tnum;
	private String     id;
	private BigInteger buyprice;
	private BigInteger sellprice;
	private BigInteger quantity;
	private String     title;
	private Date	   tdat;
	
	public BigInteger getTnum() {
		return tnum;
	}
	public void setTnum(BigInteger tnum) {
		this.tnum = tnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BigInteger getBuyprice() {
		return buyprice;
	}
	public void setBuyprice(BigInteger buyprice) {
		this.buyprice = buyprice;
	}
	public BigInteger getSellprice() {
		return sellprice;
	}
	public void setSellprice(BigInteger sellprice) {
		this.sellprice = sellprice;
	}
	public BigInteger getQuantity() {
		return quantity;
	}
	public void setQuantity(BigInteger quantity) {
		this.quantity = quantity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getTdat() {
		return tdat;
	}
	public void setTdat(Date tdat) {
		this.tdat = tdat;
	}
	
	
}
