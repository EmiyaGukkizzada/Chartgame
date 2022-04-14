package com.example.chartgame.service;


import java.math.BigInteger;

import com.example.chartgame.model.Trade;

public interface TradeService {
	
	void buyTrade(Trade trade, String id, BigInteger totalhidden, String symbol, BigInteger hiddenpriceinput, BigInteger quantity);
	
	void sellTrade(Trade trade, String id, BigInteger totalhidden, String symbol, BigInteger hiddenpriceinput, BigInteger quantity);

	void sellout(Trade trade, String id, BigInteger totalhidden, String symbol, BigInteger hiddenpriceinput,
			BigInteger quantity);

	void buyout(Trade trade, String id, BigInteger totalhidden, String symbol, BigInteger hiddenpriceinput,
			BigInteger quantity);
	
}
