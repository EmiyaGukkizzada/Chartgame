package com.example.chartgame.dao;

import java.math.BigInteger;

import com.example.chartgame.model.Trade;

public interface TradeDao {
	void insertbuytrade(Trade trade, String id, BigInteger totalhidden, String symbol, BigInteger hiddenpriceinput, BigInteger quantity);
	void insertselltrade(Trade trade, String id, BigInteger totalhidden, String symbol, BigInteger hiddenpriceinput, BigInteger quantity);
	void insertsellouttrade(Trade trade, String id, BigInteger totalhidden, String symbol, BigInteger hiddenpriceinput,
			BigInteger quantity);
	void insertbuyouttrade(Trade trade, String id, BigInteger totalhidden, String symbol, BigInteger hiddenpriceinput,
			BigInteger quantity);
}
