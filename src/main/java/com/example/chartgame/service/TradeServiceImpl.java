package com.example.chartgame.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.chartgame.dao.TradeDao;
import com.example.chartgame.model.Trade;

@Service
public class TradeServiceImpl implements TradeService {
	
	@Autowired
	private TradeDao tradeDao;
	
	@Override
	public void buyTrade(Trade trade, String id, BigInteger totalhidden, String symbol, BigInteger hiddenpriceinput, BigInteger quantity) {
		System.out.println("매수 주문총액 --> "+ totalhidden);
		System.out.println("매수 가격 --> "+ hiddenpriceinput);
		tradeDao.insertbuytrade(trade, id,totalhidden, symbol, hiddenpriceinput, quantity);
	}
	
	@Override
	public void sellTrade(Trade trade, String id, BigInteger totalhidden, String symbol, BigInteger hiddenpriceinput, BigInteger quantity) {
		System.out.println("매도 주문총액 --> "+ totalhidden);
		System.out.println("매도 가격 --> "+ hiddenpriceinput);
		tradeDao.insertselltrade(trade, id, totalhidden, symbol, hiddenpriceinput, quantity);
	}

	@Override
	public void sellout(Trade trade, String id, BigInteger totalhidden, String symbol, BigInteger hiddenpriceinput,
			BigInteger quantity) {
		System.out.println("매도 청산 총액 --> " + totalhidden);
		System.out.println("매도 청산 가격 --> " + hiddenpriceinput);
		tradeDao.insertsellouttrade(trade, id, totalhidden, symbol, hiddenpriceinput, quantity);
		
	}

	@Override
	public void buyout(Trade trade, String id, BigInteger totalhidden, String symbol, BigInteger hiddenpriceinput,
			BigInteger quantity) {
		System.out.println("매수 청산 총액 --> " + totalhidden);
		System.out.println("매수 청산 가격 --> " + hiddenpriceinput);
		tradeDao.insertbuyouttrade(trade, id, totalhidden, symbol, hiddenpriceinput, quantity);
		
	}
}
