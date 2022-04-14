package com.example.chartgame.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.chartgame.model.Member;
import com.example.chartgame.model.PortFolio;

@Repository
public class PortFolioDaoImpl implements PortFolioDao {
	@Autowired
	SqlSession session;
	
	@Override
	public PortFolio selectPortFolio(String id) {
		PortFolio portFolio = session.selectOne("portfolioSelect", id);
		System.out.println(portFolio);
		
		return portFolio;
	}

	@Override
	public void insertPortFolio(Member member, BigInteger cash) {
		PortFolio portFolio = new PortFolio();
		portFolio.setId(member.getId());
		portFolio.setCash(cash);
		System.out.println("insertPortFolio setId ->" + member.getId());
		System.out.println("insertPortFolio setCash ->" + cash);
		session.insert("portfolioInsert",portFolio);

	}
	
	@Override
	public void BuyTradePortFolio(String id, BigInteger cash, String symbol, BigInteger hiddenpriceinput, BigInteger quantity) {
		try {
			Map<String, Object> param = new HashMap<>();
			param.put("id", id);
			param.put("cash", cash);
			param.put("symbol", symbol);
			param.put("hiddenpriceinput", hiddenpriceinput);
			param.put("quantity", quantity);
			
			System.out.println("map --> " + param);
			session.update("portfolioBuy", param);
		} catch (Exception e) {
			System.out.println("PortFolioDaoImpl BuyTradePortFolio() Exception -> " + e.getMessage());
		}
	}

	@Override
	public void SellTradePortFolio(String id, BigInteger cash, String symbol, BigInteger hiddenpriceinput,
			BigInteger quantity) {
		try {
			Map<String, Object> param = new HashMap<>();
			param.put("id", id);
			param.put("cash", cash);
			param.put("symbol", symbol);
			param.put("hiddenpriceinput", hiddenpriceinput);
			param.put("quantity", quantity);
			
			System.out.println("map --> " + param);
			session.update("portfolioSell", param);
		} catch (Exception e) {
			System.out.println("PortFolioDaoImpl SellTradePortFolio() Exception -> " + e.getMessage());
		}
		
	}

	@Override
	public List<PortFolio> portfolioList(PortFolio portFolio) {
		
		System.out.println("portfolioDaoImpl portfolioList start");
		List<PortFolio> portfolioList = null;
		// portfolioList 목록 불러오기
		try {
			portfolioList = session.selectList("portfolioList", portFolio);
		} catch (Exception e) {
			System.out.println("portfolioDaoImpl portfolioList Exception-> " + e.getMessage());
		}
		return portfolioList;
	}

	@Override
	public void SelloutPortFolio(String id, BigInteger dbsellouttotalcash, String symbol, BigInteger hiddenpriceinput,
			BigInteger quantity) {
		try {
			Map<String, Object> param = new HashMap<>();
			param.put("id", id);
			param.put("dbsellouttotalcash", dbsellouttotalcash);
			param.put("symbol", symbol);
			param.put("hiddenpriceinput", hiddenpriceinput);
			param.put("quantity", quantity);
			
			System.out.println("map --> " + param);
			session.update("portfolioSellOut", param);
		} catch (Exception e) {
			System.out.println("PortFolioDaoImpl SelloutPortFolio() Exception -> " + e.getMessage());
		}
		
	}

	@Override
	public void BuyoutPortFolio(String id, BigInteger dbbuyouttotalcash, String symbol, BigInteger hiddenpriceinput,
			BigInteger quantity) {
		try {
			Map<String, Object> param = new HashMap<>();
			param.put("id", id);
			param.put("dbbuyouttotalcash", dbbuyouttotalcash);
			param.put("symbol", symbol);
			param.put("hiddenpriceinput", hiddenpriceinput);
			param.put("quantity", quantity);
			
			System.out.println("map --> " + param);
			session.update("portfolioBuyOut", param);
		} catch (Exception e) {
			System.out.println("PortFolioDaoImpl BuyoutPortFolio() Exception -> " + e.getMessage());
		}
		
	}

	@Override
	public List<PortFolio> portfolioRankList(PortFolio portFolio) {
		System.out.println("portfolioDaoImpl portfolioRankList start");
		
		List<PortFolio> portfolioRankList = null;
		
		try {
			portfolioRankList = session.selectList("portfolioRankList");
		} catch (Exception e) {
			System.out.println("portfolioDaoImpl portfolioRankList Exception-> " + e.getMessage());
		}
		System.out.println(portfolioRankList);
		
		return portfolioRankList;
	}



}
