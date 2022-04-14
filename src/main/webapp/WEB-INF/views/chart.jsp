<%@page import="com.example.chartgame.model.PortFolio"%>
<%@page import="javax.swing.text.Document"%>
<%@page import="java.time.Period"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Chart</title>

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@500&display=swap');
       
    </style>
</head>

<body>
	<form action="tradeStock" method="post">	
	    <article style="display: inline-grid; margin-top: 10px; margin-bottom: 0px;">
	        <span style="display: inline-block; position: relative; border-bottom: 1px solid #d4d6dc; background-color: white;  max-height: 50px;   width: 1000px;">
	            <a class="select" style="height: 42px;">
	                <img id='symbol_icon' style="height: 30px; width: 30px; margin-bottom: 10px; margin-top: 10px; margin-left: 10px;" onclick="timevalue()">
	                <!-- <b style="font-size: 20px; position: absolute; top: 8px; left: 45px; font-weight: 700;">비트코인</b> -->
	                <select id='symbol' data-max-option="2" name="symbol" onchange="timevalue()">
		                <optgroup label="USDT" data-max-options="2">		
		                	<option value="BTCUSDT">BTCUSDT</option>
		                	<option value="ETHUSDT">ETHUSDT</option>
		                	<option value="BNBUSDT">BNBUSDT</option>
		                	<option value="BCCUSDT">BCCUSDT</option>
		                	<option value="NEOUSDT">NEOUSDT</option>
		                	<option value="LTCUSDT">LTCUSDT</option>
	                </select>
	                <input type="hidden" id="id" name="id" value="${sessionId}">
	            </a>
	        </span>
	        <span style="display: inline-block; position: relative; border-bottom: 1px solid #d4d6dc; background-color: #f9fafc; width: 1000px; max-height: 80px;">
	            <tr>
	                <td>
	                    <div style="float: left;">
	                        <span>
	                            <input style="border-left: 0;border-bottom-width: 1px; border-top-width: 0px; font-size: 30px; font-weight: 500; border-bottom-width: 0px; border-right-width: 0px; background-color: #f9fafc; padding-left: 10px;  max-width: 147px; font-weight: 500; text-align: center;" type="text" id="price" onchange="getPriceCal()">
	                            <input style="border-left: 0;border-bottom-width: 1px; border-top-width: 0px; font-size: 30px; margin-left: 0px; border-bottom-width: 0px; border-right-width: 0px; background-color: #f9fafc; font-size: 16px; width: 46px; font-weight: 400;" value="USDT">
	                        </span>
	                        
	                        <!-- Chart 시간 변경 -->
	                        
	                        <span style="display: block;">
	                            <select id="period" onchange="timevalue()">
	                                <option value="m">분봉</option>
	                                <option value="d">일봉</option>
	                                <option value="M">월봉</option>
	                            </select>
	                            <select id="time" onchange="timevalue()">
	                                <option value="1">1분</option>
	                                <option value="3">3분</option>
	                                <option value="5">5분</option>
	                                <option value="15">15분</option>
	                                <option value="30">30분</option>
	                            </select>
	                            <select id="timeday" onchange="timevalue()" style="display: none;">
	                                <option value="1">1일</option>
	                                <option value="3">3일</option>
	                            </select>
	                            <select id="timemonth" onchange="timevalue()" style="display: none;">
	                                <option value="1">1개월</option>
	                            </select>
	                        </span>
	                    </div>
	                </td>
	            </tr> 
	        </span>
	 
	        <!-- Chart 생성 -->
	        
	        <span>
	            <div id="tvchart"></div>
	        </span>
	    </article>
	    
	    <!--채팅 (WebSocket)  -->
		<div class="halfB" style="display: flex; background-color: white; width: 1000px;">	
			<div class="leftB" style="float: left;">
				<article>
						<span>
							<tr>
								<td>    
								    <div>
								        <input type="hidden" id="nickname" class="form-inline" value="${sessionId }">
								
								        <div id="chatroom" style="width:400px; height: 600px; border:1px solid; background-color : white;"></div>
								        <input type="text" id="message" style="height : 30px; width : 340px" placeholder="내용을 입력하세요">
								        <button class="btn btn-primary" type="button" id="send">전송</button>
							   		 </div>
							   	</td>
							</tr>   		 
					   	</span>
				 </article> 		
		   	 </div>
		   	 <!-- 주문기능 -->
			 		   	 
			   	 <div class="rightB" style="float: left; padding-left: 5px; width: 50%; box-sizing: border-box; width: 595px;">
			   	 	<article style="float: left; width: 100%; margin-bottom: 10px; background-color: white; box-shadow: 2px 2px 4px #dee1e7;">
			   	 		<span style="display: block; width: 100%; margin-bottom: 20px;">
			   	 			<ul style="display: table; table-layout: fixed; width: 100%;">
			   	 				<li style="width: 44.44%; display: table-cell; text-align: center;"><a id="buy" title="매수" onclick="buyorsellclick(0)" style="padding-left: 55px; padding-right: 55px; font-size: 16px; height: 40px; font-weight: 700; width: 100%;">매수</a></li>
			   	 				<input id="buyorsellchecked" name="buyorsellchecked" type="hidden" value="2">
			   	 				<script>
			   	 					/*매수 매도 클릭 여부*/
			   	 					function buyorsellclick(checked) {
										document.getElementById('buyorsellchecked').value = checked;
			   	 						/* console.log("buyorsellchecked ->", document.getElementById('buyorsellchecked').value); */
			   	 						var buystyle = document.getElementById("buy").style;
			   	 						var sellstyle = document.getElementById("sell").style;
		   	 							var submit_button_style = document.getElementById('submit_button').style;
		   	 							var submit_button = document.getElementById('submit_button');
		   	 							console.log(submit_button);
		   	 							
		   	 							/*매수 클릭*/
			   	 						if(document.getElementById('buyorsellchecked').value == 0){
				   	 						buystyle.color = '#d80e35';	
			   	 							buystyle.borderBottom = '3px solid #d80e35';
				   	 						sellstyle.color = '#000000';
			   	 							sellstyle.borderBottom = 'none';
			   	 							submit_button_style.backgroundColor = '#d80e35';
			   	 							submit_button.innerHTML = '구매';
			   	 							buyorselltext.innerHTML = '매수가격';
			   	 					
			   	 						/*매도 클릭*/
			   	 						}else if(document.getElementById('buyorsellchecked').value == 1){
				   	 						buystyle.color = '#000000';	
			   	 							buystyle.borderBottom = 'none';
			   	 							sellstyle.color = '#115dcb';
			   	 							sellstyle.borderBottom = '3px solid #115dcb';
			   	 							submit_button_style.backgroundColor = '#0c3887';
			   	 							submit_button.innerHTML = '판매';
			   	 							buyorselltext.innerHTML = '매도가격';
			   	 						}
			   	 						selectormarketclick(document.getElementById('selectormarketchecked').value);
			   	 						var price = document.getElementById("price").value;
										console.log(price);
										var priceinput = document.getElementById("buypriceinput").value;
										console.log(priceinput);
										priceinput = price;
										console.log(priceinput);
			   	 						
									}
			   	 				</script>
			   	 				
			   	 				<li style="width: 44.44%; display: table-cell; text-align: center;"><a id="sell" title="매도" onclick="buyorsellclick(1)" style="padding-left: 55px; padding-right: 55px; font-size: 16px; height: 40px; font-weight: 700; width: 100%;">매도</a></li>
			   	 				<li style="width: 44.44%; display: table-cell; text-align: center;"><a title="거래내역">거래내역</a></li>	
			   	 			</ul>	
			   	 		</span>
			   	 		<span class="orderB">
			   	 		
			   	 			<div style="height: 592px; position: relative;">
			   	 				<span style="width: 592px; height: 38px; display: block;">	
			   	 					<span style="float: left; display: block; width: 134px; line-height: 30px; height: 30px; margin-left: 20px;">
			   	 						<strong>주문구분</strong>
			   	 					</span>
			   	 					<span>
			   	 						<span style="float: left; display: block; margin-left: 140px;">
			   	 							<a onclick="selectormarketclick(0)" id="select_price_id" style="display: block; float: left; margin-top: 5px; margin-left: 60px;">지정가</a>
			   	 							<a onclick="selectormarketclick(1)" id="market_price_id" style="display: block; float: left; margin-left: 55px; margin-top: 5px;">시장가</a>
			   	 							<input id="selectormarketchecked" name="selectormarketchecked" type="hidden" value="2">
			   	 							<script>
			   	 								/*지정가 시장가 판별*/
			   	 								function selectormarketclick(checked) {
			   	 								
			   	 								var selectormarketchecked = document.getElementById('selectormarketchecked').value;
			   	 								var buyorsellchecked = document.getElementById('buyorsellchecked').value;
			   	 								
			   	 								var select_price_style = document.getElementById('select_price_id').style;
				   	 							var market_price_style = document.getElementById('market_price_id').style;
			   	 								
				   	 							document.getElementById('selectormarketchecked').value = checked;
				   	 							
				   	 							/* console.log('buyorsellchecked -> ',buyorsellchecked);
				   	 							console.log('selectormarketchecked -> ',selectormarketchecked); */
				   	 							
			   	 								if (buyorsellchecked == 0 && document.getElementById('selectormarketchecked').value == 0) {
						   	 							select_price_style.color = '#d80e35';
														select_price_style.borderBottom = '3px solid #d80e35';
														market_price_style.color = '#000000';
														market_price_style.borderBottom = 'none';
														
													}else if(buyorsellchecked == 0 && document.getElementById('selectormarketchecked').value == 1){
														select_price_style.color = '#000000';
														select_price_style.borderBottom = 'none';
														market_price_style.color = '#d80e35';
														market_price_style.borderBottom = '3px solid #d80e35';
														
													}else if(buyorsellchecked == 1 && document.getElementById('selectormarketchecked').value == 0){
														select_price_style.color = '#115dcb';
														select_price_style.borderBottom = '3px solid #115dcb';
														market_price_style.color = '#000000';
														market_price_style.borderBottom = 'none';
													}else if(buyorsellchecked == 1 && document.getElementById('selectormarketchecked').value == 1){
														select_price_style.color = '#000000';
														select_price_style.borderBottom = 'none';
														market_price_style.color = '#115dcb';
														market_price_style.borderBottom = '3px solid #115dcb';
													}
						   	 					
												}
			   	 							
			   	 							</script>
			   	 						</span>
			   	 						<script>
			   	 							function select_price() {
			   	 								
			   	 								var url = 'https://api.binance.com/api/v3/ticker/price';
			   	 								
			   	 								fetch(url)
			   	 									.then(res => res.json())
			   	 									.then((json) => {
			   	 										
			   	 									
			   	 								console.log(json);
			   	 								for(var key in json){
			   	 								var sdata	= json[key].symbol;
			   	 								console.log(sdata);
			   	 								}
			   	 								})
			   	 							}	  
			   	 						</script>
			   	 					</span>
			   	 				</span>	
								<span style="width: 592px; height: 60px; display: block;">	
									<span style="float: left; display: inline-block; width: 100px; line-height: 30px; height: 30px; margin-left: 20px; margin-top: 25px;">
				   	 						<strong style="width: auto;">주문가능</strong>
				   	 				</span>
				   	 				<span style="float: left; display: inline-block; margin-left: 170px; width:170px; align-items: flex-end; ">
						   	 				<p id="mycash" style="width: 165px; text-align:right; float: left; margin-top: 25px;line-height:30px; height: 30px; margin-right: 3px; font-size: 18px; font-weight: 700; color: #2b2b2b; "></p>
						   	 				<b style=" float: right; display: block; position:absolute; font-size: 11px; font-weight: 400; color: #666; right:106px; margin-left: 5px; margin-top: 33px;">KRW</b>
						   	 				<input id="hiddencash" name="hiddencash" type="hidden" onchange="getPortFolioCash()">
						   	 				<script> 
						   	 					var id = '${sessionId}';
						   	 					$.ajax({
						   	 						url:"getPortFolioCash",
						   	 						data:{id},
						   	 						dataType:'text',
						   	 						success:function(cash){
						   	 							/* console.log(cash); */
						   	 							$('#hiddencash').val(cash);
						   	 							/* console.log(hiddencash.value); */
						   	 						}
						   	 					});
						   	 				</script>
						   	 		</span>
						   	 	</span>
						   	 	<span style="width: 592px; height: 80px; display: block;">		
				   	 				<span style="float: left; display: block; width: auto; line-height: 30px; height: 30px; margin-left: 20px; margin-top: 25px; margin-right: 55px;">
				   	 					<strong id="buyorselltext">매수가격</strong>
				   	 					<i style=" font-style: normal; color: #666; font-size: 11px; margin-right: 50px;">(KRW)</i>	
				   	 				</span>
				   	 				<span style="float: left; width: 328px; height: 65px; ">
				   	 					<div style="display: flex; position: relative;">
				   	 						<input type="text" class="txt" id="buypriceinput" style="font-weight: 700; flex: 1; float: none; width: auto; height: 36px; padding: 0 14px; border: 1px solid #dfe0e5; border-radius: 0.1em 0 0 0.1em; line-height: 36px; color: #2b2b2b; font-size: 14px; text-align: right; margin-top: 25px;">
				   	 						<input type="hidden" id="hiddenpriceinput" name="hiddenpriceinput">
				   	 						<a class="minus" title="-" style="width: 38px; height: 36px; background:url(https://cdn.upbit.com/images/bg.e801517.png) -220px 0 no-repeat; border-top: 1px solid #dfe0e5; border-bottom:1px solid #dfe0e5; overflow: hidden; text-indent: -999em; margin-top: 25px;">-</a>
				   	 						<a class="plus" title="+" style="width: 38px; height: 36px; background:url(https://cdn.upbit.com/images/bg.e801517.png) -270px 0 no-repeat; border:1px solid #dfe0e5; border-radius: 0 0.1em 0.1em 0; overflow: hidden; text-indent: -999em; margin-right: 60px; margin-top: 25px;">+</a>
				   	 					</div>
				   	 				</span>
				   	 			</span>	
				   	 			<span style="width: 592px; height: 70px; display: block;">
				   	 				<span style="float: left; display: block; width: 195px; line-height: 30px; height: 30px; margin-top: 25px; margin-left: 19px;">
				   	 					<strong style="width: auto; float: left; display: inline-block;">주문수량</strong>
				   	 					<i style="float:left; font-style: normal; color: #666; font-size: 11px; margin-left: 3px;">(BTC)</i>
				   	 					<input id="hiddenDBsymbol" name="hiddenDBsymbol" type="hidden" onchange="getPortFolioDB()">
				   	 					<input id="hiddenDBquantity" name="hiddenDBquantity" type="hidden" onchange="getPortFolioDB()">
				   	 					<input id="hiddenDBbuyprice" name="hiddenDBbuyprice" type="hidden" onchange="getPortFolioDB()">
				   	 					<input id="hiddenDBsellprice" name="hiddenDBsellprice" type="hidden" onchange="getPortFolioDB()">
				   	 					<script>
												var id = '${sessionId}';
												
													$.ajax({
							   	 						url:"getPortFolioDB",
							   	 						data:{id},
							   	 						dataType : 'json',
							   	 						success:function(data){
							   	 							$(data).each(function(){
							   	 								console.log(this.buyprice + " " + this.id + " " + this.sellprice + " " + this.quantity + " " + this.symbol);
							   	 								var id = this.id;
							   	 								var symbol = this.symbol;
							   	 								var buyprice = this.buyprice;
							   	 								var sellprice = this.sellprice;
							   	 								var quantity = this.quantity;
							   	 													   	 								
							   	 								document.getElementById('hiddenDBsymbol').value = symbol;
							   	 								document.getElementById('getDBsymbol').innerHTML = symbol;
							   	 								document.getElementById('hiddenDBquantity').value = quantity;
							   	 								document.getElementById('getDBquantity').innerHTML = quantity;
							   	 								document.getElementById('hiddenDBbuyprice').value = buyprice;
							   	 								document.getElementById('hiddenDBsellprice').value = sellprice;
							   	 								
							   	 								if (buyprice > 0 && quantity > 0) {
							   	 									document.getElementById('getDBsymbol').style.color = "#d80e35";
							   	 									document.getElementById('getDBquantity').style.color = "#d80e35";
							   	 									document.getElementById('getDBprice').style.color = "#d80e35";
							   	 									document.getElementById('getDBprice').innerHTML = buyprice;
							   	 									
																}else if(buyprice == 0 && quantity < 0){
																	document.getElementById('getDBsymbol').style.color = "#115dcb";
																	document.getElementById('getDBquantity').style.color = "#115dcb";
																	document.getElementById('getDBprice').style.color = "#115dcb";
																	document.getElementById('getDBprice').innerHTML = sellprice;
																	
																}else {
																	document.getElementById('getDBsymbol').innerHTML = '없음';
																	document.getElementById('getDBquantity').innerHTML = '없음';
																	document.getElementById('getDBprice').innerHTML = '없음';
																}
							   	 							});
							   	 						}
							   	 					});	

						   	 			</script>
				   	 				</span>	
				   	 				<span style="float: left; display: inline-block;">
				   	 					<input type="text" id="quantity" name="quantity" class="quantity" style="font-weight: 700; flex: 1; float: none; width: 268px; height: 36px; padding: 0 14px; border: 1px solid #dfe0e5; border-radius: 0.1em 0 0 0.1em; line-height: 36px; color: #2b2b2b; font-size: 14px; text-align: right; margin-top: 25px;">
				   	 				</span>
				   	 			</span>	
			   	 				<span style="width: 400px; height: 50px; display: block; margin-left: 148px; margin-right: 20px;">
			   	 					<a id="10%" onclick="percent(10)" style="width: 15%; margin-right:5px; display: inline-block; font-weight: 100; flex: 1; float: none; height: 36px; border: 1px solid #dfe0e5; border-radius: 0.1em 0 0 0.1em; line-height: 36px; color: #2b2b2b; font-size: 15px; padding-left: 17px;">10%</a>
			   	 					<a id="25%" onclick="percent(25)" style="width: 15%; margin-right:5px; display: inline-block; font-weight: 100; flex: 1; float: none; height: 36px; border: 1px solid #dfe0e5; border-radius: 0.1em 0 0 0.1em; line-height: 36px; color: #2b2b2b; font-size: 15px; padding-left: 17px;">25%</a>
			   	 					<a id="50%" onclick="percent(50)" style="width: 15%; margin-right:5px; display: inline-block; font-weight: 100; flex: 1; float: none; height: 36px; border: 1px solid #dfe0e5; border-radius: 0.1em 0 0 0.1em; line-height: 36px; color: #2b2b2b; font-size: 15px; padding-left: 17px;">50%</a>
			   	 					<a id="100%"onclick="percent(100)" style="width: 15%; margin-right:5px; display: inline-block; font-weight: 100; flex: 1; float: none; height: 36px; border: 1px solid #dfe0e5; border-radius: 0.1em 0 0 0.1em; line-height: 36px; color: #2b2b2b; font-size: 15px; padding-left: 12px;">100%</a>
			   	 					<a id="0%" onclick="percent(0)" style="width: 15%; margin-right:5px; display: inline-block; font-weight: 100; flex: 1; float: none; height: 36px; border: 1px solid #dfe0e5; border-radius: 0.1em 0 0 0.1em; line-height: 36px; color: #2b2b2b; font-size: 12px; padding-left: 5px;">직접입력</a>
			   	 					<input id="percent" name="percent" type="hidden">
			   	 					<script>
			   	 						/*퍼센트 계산 후 주문수량에 반영*/
			   	 						function percent(percent) {
											var hiddencash = Number(document.getElementById('hiddencash').value);
											var quantity = document.getElementById('quantity').value;
											var buyprice = Math.floor(Number(document.getElementById('hiddenpriceinput').value)); 
											
			   	 							var total = ((hiddencash) * (percent / 100)) / buyprice;
			   	 							
			   	 							$('#quantity').val(Math.floor(total));
			   	 							
										}
			   	 					</script>
			   	 				</span>
			   	 				<span>
			   	 					<span style="float: left; display: block; width: 195px; line-height: 30px; height: 30px; margin-top: 25px; margin-left: 19px;">
			   	 						<strong style="width: auto; float: left; display: inline-block;">주문총액</strong>
				   	 					<i style="float:left; font-style: normal; color: #666; font-size: 11px; margin-left: 3px;">(KRW)</i>
			   	 					</span>
			   	 					<span style="float: left; display: inline-block;">
				   	 					<input type="text" id="total" class="total" style="font-weight: 700; flex: 1; float: none; width: 268px; height: 36px; padding: 0 14px; border: 1px solid #dfe0e5; border-radius: 0.1em 0 0 0.1em; line-height: 36px; color: #2b2b2b; font-size: 14px; text-align: right; margin-top: 25px;">
				   	 					<input type="hidden" id="totalhidden" name="totalhidden">
				   	 				</span>
			   	 				</span>
			   	 				<span style="width: 592px; display:inline-flex; margin-top: 140px;"> 
				   	 				<Strong style="margin-right: 10px; margin-left: 120px;">보유종목 :</Strong><p id="getDBsymbol" style=" font-style: normal; color: #666; font-size: 13px; margin-right: 10px;"></p>
				   	 				<Strong style="margin-right: 10px;">보유수량 :</Strong><p id="getDBquantity" style=" font-style: normal; color: #666; font-size: 13px; margin-right: 10px;"></p>
				   	 				<Strong style="margin-right: 10px;">보유가격 :</Strong><p id="getDBprice" style=" font-style: normal; color: #666; font-size: 13px; margin-right: 10px;"></p>
				   	 				<!-- <Strong style="margin-right: 10px;">손익총액 :</Strong><p id="getDBtotalprice" style=" font-style: normal; color: #666; font-size: 13px; margin-right: 10px;"></p> -->
			   	 				</span>
			   	 				<span style="width: 592px; display:block; margin-top: 10px;">
			   	 					<button id="submit_button" type="submit" style="background-color: #606060; display: inline-block; width: 100%; height:44px; color: #fff; font-size: 14px; font-weight: 700; text-align: center; overflow: hidden; border: 0;">구매</button>
			   	 				</span>
			   	 			</div>
			   	 		</span>	
			   	 	</article>
			   	 </div>   	 
			</div>
		</form>
	</body>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/socket.io/2.3.0/socket.io.js"></script>
<script src="https://unpkg.com/lightweight-charts/dist/lightweight-charts.standalone.production.js"></script>
<script type="text/javascript" src="../../js/index2.js"></script>
<!-- Chat script -->
<script>
    var webSocket;
    var nickname;
    nickname = document.getElementById("nickname").value;
    connect();

    document.getElementById("send").addEventListener("click", function() {
        send();
    })

    function connect() {
        webSocket = new WebSocket("ws://localhost:8585/chat");
        console.log(webSocket);
        webSocket.onopen = onOpen;
        webSocket.onclose = onClose;
        webSocket.onmessage = onMessage;
    }

    function disconnect() {
        webSocket.send(nickname + "님이 퇴장하셨습니다");
        webSocket.close();
    }

    function send() {
        msg = document.getElementById("message").value;
        webSocket.send(nickname + " : " + msg);
        document.getElementById("message").value = "";
    }

    function onOpen() {
        webSocket.send(nickname + "님이 입장하셨습니다.");
    }

    function onMessage(e) {
        var msg = e.data;
        chatroom = document.getElementById("chatroom");
        chatroom.innerHTML = chatroom.innerHTML + "<br>" + msg;
    }

    function onClose() {

    }
</script>
</html>