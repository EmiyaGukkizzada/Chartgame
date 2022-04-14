package com.example.chartgame.model;

import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortFolio {
	private String id;
	private BigInteger cash;
	private String symbol;
	private BigInteger buyprice;
	private BigInteger sellprice;
	private BigInteger quantity;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BigInteger getCash() {
		return cash;
	}
	public void setCash(BigInteger cash) {
		this.cash = cash;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
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
	
}
