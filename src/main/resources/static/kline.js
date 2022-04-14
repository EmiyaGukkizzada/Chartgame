const log = console.log;
const api = require('binance');
const express = require('express');
const app = express();
const server = app.listen('4000',() => log(`Kline Data Server started on port 4000`));
const socket = require('socket.io');
const io = socket(server);


const bRest = new api.BinanceRest({
        key: "", // Get this from your account on binance.com
        secret: "", // Same for this
        timeout: 15000, // Optional, defaults to 15000, is the request time out in milliseconds
        recvWindow: 20000, // Optional, defaults to 5000, increase if you're getting timestamp errors
        disableBeautification: false,
        handleDrift: true
});
const binanceWS = new api.BinanceWS(true);


/*BTCUSDT*/
binanceWS.onKline('BTCUSDT', '1m', (data) => {
    io.emit('BTCUSDT1m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BTCUSDT', '3m', (data) => {
	io.emit('BTCUSDT3m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BTCUSDT', '5m', (data) => {
	io.emit('BTCUSDT5m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BTCUSDT', '15m', (data) => {
	io.emit('BTCUSDT15m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BTCUSDT', '30m', (data) => {
	io.emit('BTCUSDT30m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BTCUSDT', '1d', (data) => {
	io.emit('BTCUSDT1d',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BTCUSDT', '3d', (data) => {
	io.emit('BTCUSDT3d',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BTCUSDT', '1M', (data) => {
	io.emit('BTCUSDT1M',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});


/*ETHUSDT*/

binanceWS.onKline('ETHUSDT', '1m', (data) => {
    io.emit('ETHUSDT1m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('ETHUSDT', '3m', (data) => {
	io.emit('ETHUSDT3m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('ETHUSDT', '5m', (data) => {
	io.emit('ETHUSDT5m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('ETHUSDT', '15m', (data) => {
	io.emit('ETHUSDT15m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('ETHUSDT', '30m', (data) => {
	io.emit('ETHUSDT30m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('ETHUSDT', '1d', (data) => {
	io.emit('ETHUSDT1d',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('ETHUSDT', '3d', (data) => {
	io.emit('ETHUSDT3d',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('ETHUSDT', '1M', (data) => {
	io.emit('ETHUSDT1M',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});

/*BNBUSDT*/

binanceWS.onKline('BNBUSDT', '1m', (data) => {
    io.emit('BNBUSDT1m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BNBUSDT', '3m', (data) => {
	io.emit('BNBUSDT3m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BNBUSDT', '5m', (data) => {
	io.emit('BNBUSDT5m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BNBUSDT', '15m', (data) => {
	io.emit('BNBUSDT15m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BNBUSDT', '30m', (data) => {
	io.emit('BNBUSDT30m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BNBUSDT', '1d', (data) => {
	io.emit('BNBUSDT1d',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BNBUSDT', '3d', (data) => {
	io.emit('BNBUSDT3d',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BNBUSDT', '1M', (data) => {
	io.emit('BNBUSDT1M',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});

/*BCCUSDT*/

binanceWS.onKline('BCCUSDT', '1m', (data) => {
    io.emit('BCCUSDT1m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BCCUSDT', '3m', (data) => {
	io.emit('BCCUSDT3m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BCCUSDT', '5m', (data) => {
	io.emit('BCCUSDT5m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BCCUSDT', '15m', (data) => {
	io.emit('BCCUSDT15m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BCCUSDT', '30m', (data) => {
	io.emit('BCCUSDT30m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BCCUSDT', '1d', (data) => {
	io.emit('BCCUSDT1d',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BCCUSDT', '3d', (data) => {
	io.emit('BCCUSDT3d',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('BCCUSDT', '1M', (data) => {
	io.emit('BCCUSDT1M',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});

/*NEOUSDT*/

binanceWS.onKline('NEOUSDT', '1m', (data) => {
    io.emit('NEOUSDT1m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('NEOUSDT', '3m', (data) => {
	io.emit('NEOUSDT3m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('NEOUSDT', '5m', (data) => {
	io.emit('NEOUSDT5m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('NEOUSDT', '15m', (data) => {
	io.emit('NEOUSDT15m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('NEOUSDT', '30m', (data) => {
	io.emit('NEOUSDT30m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('NEOUSDT', '1d', (data) => {
	io.emit('NEOUSDT1d',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('NEOUSDT', '3d', (data) => {
	io.emit('NEOUSDT3d',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('NEOUSDT', '1M', (data) => {
	io.emit('NEOUSDT1M',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});

/*LTCUSDT*/

binanceWS.onKline('LTCUSDT', '1m', (data) => {
    io.emit('LTCUSDT1m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('LTCUSDT', '3m', (data) => {
	io.emit('LTCUSDT3m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('LTCUSDT', '5m', (data) => {
	io.emit('LTCUSDT5m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('LTCUSDT', '15m', (data) => {
	io.emit('LTCUSDT15m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('LTCUSDT', '30m', (data) => {
	io.emit('LTCUSDT30m',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('LTCUSDT', '1d', (data) => {
	io.emit('LTCUSDT1d',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('LTCUSDT', '3d', (data) => {
	io.emit('LTCUSDT3d',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});
binanceWS.onKline('LTCUSDT', '1M', (data) => {
	io.emit('LTCUSDT1M',{time:Math.round(data.kline.startTime/1000),open:parseFloat(data.kline.open),high:parseFloat(data.kline.high),low:parseFloat(data.kline.low),close:parseFloat(data.kline.close)});
});