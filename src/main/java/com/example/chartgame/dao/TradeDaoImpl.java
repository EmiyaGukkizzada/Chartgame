package com.example.chartgame.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.chartgame.model.Trade;

@Repository
public class TradeDaoImpl implements TradeDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public void insertbuytrade(Trade trade, String id, BigInteger totalhidden, String symbol, BigInteger hiddenpriceinput, BigInteger quantity) {
		System.out.println("dao id-----> "+id);
		/*int로 반환해 값이있는지 판단용*/
		int result = 0;
		System.out.println("TradeDaoImpl insertbuytrade() start...");
		/* trade.setId(member.getId()); */
		
		try {
			Map<String, Object> param = new HashMap<>();
			param.put("id", id);
			param.put("hiddenpriceinput", hiddenpriceinput);
			param.put("quantity", quantity);
			param.put("symbol", symbol);
			
			System.out.println("map --> " + param);
			result = session.insert("buyTrade", param);
		} catch (Exception e) {
			System.out.println("TradeDaoImpl insertbuytrade() Exception -> " + e.getMessage());
		}
		
	}
	
	@Override
	public void insertselltrade(Trade trade, String id, BigInteger totalhidden, String symbol, BigInteger hiddenpriceinput, BigInteger quantity) {
		System.out.println("dao id-----> "+id);
		
		int result = 0;
		/* trade.setId(symbol); */
		System.out.println("TradeDaoImpl insertselltrade() start...");
		
		try {
			Map<String, Object> param = new HashMap<>();
			param.put("id", id);
			param.put("hiddenpriceinput", hiddenpriceinput);
			param.put("quantity", quantity);
			param.put("symbol", symbol);
			
			System.out.println("map --> " + param);
			result = session.insert("sellTrade", param);
		} catch (Exception e) {
			System.out.println("TradeDaoImpl insertselltrade() Exception -> " + e.getMessage());
		}
	}

	@Override
	public void insertsellouttrade(Trade trade, String id, BigInteger totalhidden, String symbol,
			BigInteger hiddenpriceinput, BigInteger quantity) {
		int result = 0;
		System.out.println("TradeDaoImpl insertsellouttrade() start...");
		
		try {
			Map<String, Object> param = new HashMap<>();
			param.put("id", id);
			param.put("hiddenpriceinput", hiddenpriceinput);
			param.put("quantity", quantity);
			param.put("symbol", symbol);
			
			System.out.println("map --> " + param);
			result = session.insert("sellOut", param);
			
		} catch (Exception e) {
			System.out.println("TradeDaoImpl insertsellouttrade() Exception -> " + e.getMessage());
		}
		
	}

	@Override
	public void insertbuyouttrade(Trade trade, String id, BigInteger totalhidden, String symbol,
			BigInteger hiddenpriceinput, BigInteger quantity) {
		int result = 0;
		System.out.println("TradeDaoImpl insertbuyouttrade() start...");
		
		try {
			Map<String, Object> param = new HashMap<>();
			param.put("id", id);
			param.put("hiddenpriceinput", hiddenpriceinput);
			param.put("quantity", quantity);
			param.put("symbol", symbol);
			
			System.out.println("map --> " + param);
			result = session.insert("buyOut", param);
			
		} catch (Exception e) {
			System.out.println("TradeDaoImpl insertbuyouttrade() Exception -> " + e.getMessage());
		}
		
	}
}
