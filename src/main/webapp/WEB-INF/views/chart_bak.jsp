<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  	<title>Static Chart</title>
  	<link rel="stylesheet" type="text/css" href="https://code.highcharts.com/css/stocktools/gui.css">
	<link rel="stylesheet" type="text/css" href="https://code.highcharts.com/css/annotations/popup.css">
  	<script src="../../code/highstock.js"></script>
	<script src="../../code/modules/data.js"></script>
	
	<script src="../../code/indicators/indicators-all.js"></script>
	<script src="../../code/modules/drag-panes.js"></script>
	
	<script src="../../code/modules/annotations-advanced.js"></script>
	<script src="../../code/modules/price-indicator.js"></script>
	<script src="../../code/modules/full-screen.js"></script>
	<script src="../../code/modules/heikinashi.js"></script>
	<script src="../../code/modules/hollowcandlestick.js"></script>	
  </head>
  <body>
  	<h2>Binance BTCUSDT Chart</h2>
  	<!-- 여기서 차트 크기 --> 
	<div id="container" style="margin-top: 100px;" class="chart"></div>
	<!--chat Test  -->
	<div>	
		<input type="text" id="nickname" class="form-inline" value="${sessionId }">
	    
	    <div id = "chatroom" style = "width:400px; height: 600px; border:1px solid; background-color : white;"></div>
	    <input type = "text" id = "message" style = "height : 30px; width : 340px" placeholder="내용을 입력하세요">
	    <button class = "btn btn-primary" id = "send">전송</button>
    </div>
    <div>
			<select id="time">
				<option value="1">1분</option>
				<option value="3">3분</option>
				<option value="5">5분</option>
				<option value="10">10분</option>
				<option value="15">15분</option>
				<option value="30">30분</option>
				<option value="60">60분</option>
				<option value="240">240분</option>
			</select>
		</div>
		<div>
			<select id="period">
				<option value="minutes">분봉</option>
				<option value="days">일봉</option>
			</select>
		</div>
	</body>
	
<script>

	
				// Create the chart
					Highcharts.stockChart('container', {
					    chart: {
					        events: {
					            load: function () {

					                // set up the updating of the chart each second
					                var series = this.series[0];
					                setInterval(function () {
					                    var x = (new Date()).getTime(), // current time
					                        y = Math.round(Math.random() * 100);
					                    series.addPoint([x, y], true, true);
					                }, 1000);
					            }
					        }
					    },

					    time: {
					        useUTC: false
					    },

					    rangeSelector: {
					        buttons: [{
					            count: 1,
					            type: 'minute',
					            text: '1M'
					        }, {
					            count: 5,
					            type: 'minute',
					            text: '5M'
					        }, {
					            type: 'all',
					            text: 'All'
					        }],
					        inputEnabled: false,
					        selected: 0
					    },

					    title: {
					        text: 'Live random data'
					    },

					    exporting: {
					        enabled: false
					    },

					    series: [{
		
					    	name: 'Random data',
					    	type : 'hollowcandlestick',
					        data: (function () {
					        	var time = document.getElementById("time").value;
								var period = document.getElementById("period").value;
								var data = [];
					        	var url = 'https://crix-api-endpoint.upbit.com/v1/crix/candles/'+period+'/'+time+'?code=CRIX.UPBIT.KRW-XEM&count=200';
					        	
					        	Highcharts.getJSON(url, function (json) {
					        		console.log(json);
					        		// generate an array of random data
					           	
							    	var dataLength = json.length;
					           		
					           			
					            	for (var i=dataLength-1 ; i>=0 ; i--) {
		
								    	data.push([
								    		
								    		json[i].timestamp + i * 1000, // the date data[i][]
								    		json[i].openingPrice, // open
								    		json[i].highPrice, // high
								    		json[i].lowPrice, // low
								    		json[i].tradePrice // close  
								            
								        ]);
							
								    }
				        
						            console.log(data);
						        	return data;
						            
					        	});
					        	
					        	return data; 
					        }())
					        
					    }]
					});
			
		</script>

<script>
        var webSocket;
        var nickname;
        
            nickname = document.getElementById("nickname").value;
            
            
            connect();
        
        document.getElementById("send").addEventListener("click",function(){
            send();
        })
        function connect(){
            webSocket = new WebSocket("ws://localhost:8585/chat");
            console.log(webSocket);
            webSocket.onopen = onOpen;
            webSocket.onclose = onClose;
            webSocket.onmessage = onMessage;
        }
        function disconnect(){
            webSocket.send(nickname + "님이 퇴장하셨습니다"); 
            webSocket.close();
        }
        function send(){
            msg = document.getElementById("message").value;
            webSocket.send(nickname + " : " + msg);
            document.getElementById("message").value = "";
        }
        function onOpen(){
            webSocket.send(nickname + "님이 입장하셨습니다.");
        }
        function onMessage(e){
            data = e.data;
            chatroom = document.getElementById("chatroom");
            chatroom.innerHTML = chatroom.innerHTML + "<br>" + data;
        }
        function onClose(){
 
        }
    </script>
</html>

