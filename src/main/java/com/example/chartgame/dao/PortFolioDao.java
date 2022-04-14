package com.example.chartgame.dao;

import java.math.BigInteger;
import java.util.List;

import com.example.chartgame.model.Member;
import com.example.chartgame.model.PortFolio;

public interface PortFolioDao {

	PortFolio selectPortFolio(String id);
	
	void insertPortFolio(Member member, BigInteger cash);

	void BuyTradePortFolio(String id, BigInteger cash, String symbol, BigInteger hiddenpriceinput,
			BigInteger quantity);

	void SellTradePortFolio(String id, BigInteger cash, String symbol, BigInteger hiddenpriceinput,
			BigInteger quantity);

	List<PortFolio> portfolioList(PortFolio portFolio);

	void SelloutPortFolio(String id, BigInteger dbsellouttotalcash, String symbol, BigInteger hiddenpriceinput,
			BigInteger quantity);

	void BuyoutPortFolio(String id, BigInteger dbbuyouttotalcash, String symbol, BigInteger hiddenpriceinput,
			BigInteger quantity);

	List<PortFolio> portfolioRankList(PortFolio portFolio);

	
}
