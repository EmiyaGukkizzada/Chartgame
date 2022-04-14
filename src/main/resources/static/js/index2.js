//Pseudo code
//Step 1: Define chart properties.
//Step 2: Create the chart with defined properties and bind it to the DOM element.
//Step 3: Add the CandleStick Series.
//Step 4: Set the data and render.
//Step5 : Plug the socket to the chart


//Code
const log = console.log;

const chartProperties = {
  width:1000,
  height:400,
  timeScale:{
    timeVisible:true,
    secondsVisible:false,
  }
}
const domElement = document.getElementById('tvchart');
const chart = LightweightCharts.createChart(domElement,chartProperties);
const candleSeries = chart.addCandlestickSeries();
const socket = io.connect('http://127.0.0.1:4000/');
let nowCallParam; 

timevalue();
/*차트 시간, 기간, 종목변경 함수*/
	function timevalue(){
		var time = document.getElementById("time").value;
		var period = document.getElementById("period").value;
		var timestyle = document.getElementById("time").style;
		var timedaystyle = document.getElementById("timeday").style;
		var timeday = document.getElementById("timeday").value;
		var timemonthstyle = document.getElementById("timemonth").style;
		var timemonth = document.getElementById("timemonth").value;
		var symbol = document.getElementById("symbol").value;
		var symbol_icon_src = document.getElementById("symbol_icon");
		var symbol_icon_change;
		console.log("symbol_icon_src -> " + symbol_icon_src);
		
		/*다른코인을 선택하면 이미지가 바뀌는 기능*/
		symbol_replace = symbol.replace('USDT','');
		console.log(symbol_replace); 
		symbol_icon_change = "https://static.upbit.com/logos/"+symbol_replace+".png";
		console.log("symbol_icon_src -> " + symbol_icon_src);
		symbol_icon_src.setAttribute("src",symbol_icon_change);
		
		if(period == "d" ){ 
			timestyle.display = 'none';
			timedaystyle.display = 'inline-block';
			timemonthstyle.display = 'none';
			time = timeday;
			console.log(period);
			
			dynamic();
			
			
		}else if(period == "m" ){
			timestyle.display = 'inline-block';
			timemonthstyle.display = 'none';
			timedaystyle.display = 'none';
			
			
			dynamic();
			
		}else if(period == "M"){
			timestyle.display = 'none';
			timedaystyle.display = 'none';
			timemonthstyle.display = 'inline-block';
			time = timemonth;
			
			socket.close();
			dynamic();
			
		}
		var url = 'http://127.0.0.1:9665/fetchAPI?endpoint=https://api.binance.com/api/v3/klines?symbol='+symbol+'&interval='+time+''+period+'&limit=1000';
		console.log(url);
		
		fetch(url)
		  .then(res => res.json())
		  .then(data => {
		    const cdata = data.map(d => {
		      return {time:d[0]/1000,open:parseFloat(d[1]),high:parseFloat(d[2]),low:parseFloat(d[3]),close:parseFloat(d[4])}
		    });
		    candleSeries.setData(cdata);
		    
		  })
		  .catch(err => log(err))
		}
		
//Dynamic Chart
function dynamic(){
	if(nowCallParam!=null && String(nowCallParam).length!=0){
		socket.off(nowCallParam);
	}
	
	var time = document.getElementById("time").value;
	var period = document.getElementById("period").value;
	var timeday = document.getElementById("timeday").value;
	var timemonth = document.getElementById("timemonth").value;
	var symbol = document.getElementById("symbol").value;
	
	if(period == "d" ){ 
			
			time = timeday;
		
		}else if(period == "M"){
			
			time = timemonth;		
		}
	
	console.log(symbol+time+period);
	nowCallParam = String(symbol+time+period);
	
	socket.on(symbol+time+period,(pl)=>{
	  
	  /*close된 값 price변수에 넣기 및 매수가격 정수화 */
	  const price = pl.close;
	  const price1 = price.toString().replace(/(\.\d+)+/,'');
	 
	  $('#hiddenpriceinput').val(price1);
	  /*sesison에 저장된 cash값 불러오기*/
	  var cash = document.getElementById("hiddencash").value;
	  
	  /*colse된 값 차트에 업데이트 */
	  candleSeries.update(pl);
	
	  	
	  	$.ajax({
				url:"getPriceCal",
				data:{price,cash},
				dataType:'json',
				success:function(data){		
					
					/*3자리수 마다 콤마찍기*/
					const data1 = data.toString()
					  .replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
					
					$('#buypriceinput').val(data1);
					
					/*주문수량 불러오기 */
	 				 var quantity = document.getElementById("quantity").value;
					
					/*매수가격과 주문수량 곱 -> 총합 */
					
					$('#price').val(data1);
					var quantity = $('#quantity').val();
					data2 = Math.floor(data); 
					
					var mul = data2 * quantity; 
					$('#totalhidden').val(mul);
					
					const mul1 = mul.toString()
					.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",")+(' 원');
					$('#total').val(mul1);
					
					/*session에서 가져온 자산 세자리수 콤마 찍고 innerHTML로 화면 표기하기 */
					var mycash = cash.toString()
					.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
					document.getElementById('mycash').innerHTML = mycash;
				
			}
		});
	});

}
