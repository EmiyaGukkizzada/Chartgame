package com.example.chartgame.service;

import com.example.chartgame.model.PortFolio;

import java.math.BigInteger;
import java.util.List;

import com.example.chartgame.model.Member;

public interface PortFolioService {

	PortFolio selectPortFolio(String id);
	
	void newPortFolio(Member member, BigInteger cash);

	void buyTrade(String id, BigInteger cash, String symbol, BigInteger hiddenpriceinput, BigInteger quantity);

	void sellTrade(String id, BigInteger cash, String symbol, BigInteger hiddenpriceinput, BigInteger quantity);

	List<PortFolio> getPortFolioDB(String id, PortFolio portFolio);

	void sellout(String id, BigInteger dbsellouttotalcash, String symbol, BigInteger hiddenpriceinput,
			BigInteger quantity);

	void buyout(String id, BigInteger dbbuyouttotalcash, String symbol, BigInteger hiddenpriceinput,
			BigInteger quantity);

	List<PortFolio> listRank(PortFolio portFolio);
	
	
}
