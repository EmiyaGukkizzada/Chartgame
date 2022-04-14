package com.example.chartgame.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chartgame.dao.PortFolioDao;
import com.example.chartgame.model.Member;
import com.example.chartgame.model.PortFolio;

@Service
public class PortFolioServiceImpl implements PortFolioService {
	@Autowired
	PortFolioDao portfolioDao;
	
	
	@Override
	public PortFolio selectPortFolio(String id) {
		PortFolio portFolio = portfolioDao.selectPortFolio(id);
		
		return portFolio;
	}

	@Override
	public void newPortFolio(Member member, BigInteger cash) {
		portfolioDao.insertPortFolio(member, cash);

	}
	
	@Override
	public void buyTrade(String id, BigInteger cash, String symbol, BigInteger hiddenpriceinput, BigInteger quantity) {
		portfolioDao.BuyTradePortFolio(id, cash, symbol, hiddenpriceinput, quantity);
	}

	@Override
	public void sellTrade(String id, BigInteger cash, String symbol, BigInteger hiddenpriceinput, BigInteger quantity) {
		portfolioDao.SellTradePortFolio(id, cash, symbol, hiddenpriceinput, quantity);
		
	}

	@Override
	public List<PortFolio> getPortFolioDB(String id, PortFolio portFolio) {
		System.out.println("PortFolioDBServiceImpl portfolioList start");
		// PortFolio 목록
		List<PortFolio> portfolioList = null;
		portfolioList = portfolioDao.portfolioList(portFolio);
		
		return portfolioList;
		
	}

	@Override
	public void sellout(String id, BigInteger dbsellouttotalcash, String symbol, BigInteger hiddenpriceinput,
			BigInteger quantity) {
		portfolioDao.SelloutPortFolio(id, dbsellouttotalcash, symbol, hiddenpriceinput, quantity);
		
	}

	@Override
	public void buyout(String id, BigInteger dbbuyouttotalcash, String symbol, BigInteger hiddenpriceinput,
			BigInteger quantity) {
		portfolioDao.BuyoutPortFolio(id, dbbuyouttotalcash, symbol, hiddenpriceinput, quantity);
		
	}

	@Override
	public List<PortFolio> listRank(PortFolio portFolio) {
		System.out.println("PortFolioServiceimpl ListRankservice start...");
		//ranklist 목록
		List<PortFolio> listRankPortFolio = null;
		listRankPortFolio = portfolioDao.portfolioRankList(portFolio);
		
		return listRankPortFolio;
	}
	
	
}
