package com.example.chartgame.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.chartgame.ChartgameApplication;
import com.example.chartgame.model.PortFolio;
import com.example.chartgame.model.Trade;
import com.example.chartgame.service.PortFolioService;
import com.example.chartgame.service.TradeService;

import net.bytebuddy.dynamic.DynamicType.Builder.InnerTypeDefinition;

@Controller
public class TradeController {
	
	@Autowired
	private TradeService ts;
	
	@Autowired
	private PortFolioService pfs;
	
	/*포트폴리오 남은 금액 불러오기*/
	@RequestMapping(value = "getPortFolioCash", produces ="application/text;charset=UTF-8") 
	@ResponseBody 
	public String getPortFolioCash(Model model, HttpServletRequest request, @RequestParam("id")String id) {
		
		System.out.println("포트폴리오 금액조회 ID ->" + id);
		PortFolio portFolio =  pfs.selectPortFolio(id);
		model.addAttribute("portFolio", portFolio);
		System.out.println(portFolio.getCash());
		 
		BigInteger cashBig = portFolio.getCash();
		String cashString = cashBig.toString();
		
		return cashString;
		
	}
	@RequestMapping(value = "getPortFolioDB", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<PortFolio> getPortFolioDB(Model model, @RequestParam("id")String id, PortFolio portFolio){
		System.out.println("TradeController getPortFolioDB() start...");
		
		//PortFolioDB목록 가져옴
		
		List<PortFolio> portfolioList = pfs.getPortFolioDB(id, portFolio);
		
		model.addAttribute("portfolioList", portfolioList);
		
		System.out.println("portfolioList size -> " + portfolioList.size());
		System.out.println("portfolioList id -> " + portfolioList.get(0).getId());
		System.out.println("portfolioList cash -> " + portfolioList.get(0).getCash());
		System.out.println("portfolioList symbol -> " + portfolioList.get(0).getSymbol());
		System.out.println("portfolioList BuyPrice -> " + portfolioList.get(0).getBuyprice());
		System.out.println("portfolioList SellPrice -> " + portfolioList.get(0).getSellprice());
		System.out.println("portfolioList Quantity -> " + portfolioList.get(0).getQuantity());
		//List 로 return
		return portfolioList;
		
	}

	/*구매 및 판매*/
	@PostMapping(value = "tradeStock")  /*jsp로 변경한 값 넘기기 model*/
	public String tradeStock(Model model, Trade trade, HttpServletRequest request) {
		System.out.println("TraderController tradeStock() Start...");
		System.out.println(request.getAttribute("portfolioList")); 
		/*결과값 정수형 리턴*/
		int result;
		//아이디 별 보유종목 개수
		int dbquantity = Integer.valueOf(request.getParameter("hiddenDBquantity"));
		//아이디 별 종목이름
		String dbsymbol = request.getParameter("hiddenDBsymbol");
		//아이디 별 buy 가격
		int dbbuyprice = Integer.valueOf(request.getParameter("hiddenDBbuyprice"));
		//아이디 별 sell 가격
		int dbsellprice = Integer.valueOf(request.getParameter("hiddenDBsellprice"));
		
		/*id 파라미터값*/
		String id = request.getParameter("id");
		System.out.println("id ---------> " + id);
		
		/*주문가능 cash*/
		int hiddencash = Integer.valueOf(request.getParameter("hiddencash"));
		
		/*주문총액*/
		int totalhiddenint = Integer.valueOf(request.getParameter("totalhidden"));
		BigInteger firsttotalhidden = BigInteger.ONE;
		BigInteger totalhidden = firsttotalhidden.multiply(BigInteger.valueOf(totalhiddenint)); 
		
		/*구매 및 판매탭 선택*/
		int buyorsell = Integer.valueOf(request.getParameter("buyorsellchecked"));
		
		/*종목 이름*/
		String symbol = request.getParameter("symbol");
		System.out.println("종목이름 --> " + symbol);
		
		/*매수 및 매도 가격*/
		int hiddenpriceinputint = Integer.valueOf(request.getParameter("hiddenpriceinput"));
		BigInteger firsthiddenpriceinput = BigInteger.ONE;
		BigInteger hiddenpriceinput = firsthiddenpriceinput.multiply(BigInteger.valueOf(hiddenpriceinputint));
		System.out.println("매수 및 매도가격 --> " + hiddenpriceinput);
		
		
		
		/*주문수량을 입력하지 않고 구매버튼을 눌렀을시 발생하는 NumberFormat예외처리*/
		try {
			/*웹주문 수량*/
			int quantityint = Integer.valueOf(request.getParameter("quantity"));
			BigInteger firstquantity = BigInteger.ONE;
			BigInteger quantity = firstquantity.multiply(BigInteger.valueOf(quantityint));
			System.out.println("주문 수량 --> " + quantity);
			
			BigInteger cash = firstquantity.multiply(BigInteger.valueOf(hiddencash-(quantityint * hiddenpriceinputint)));
			System.out.println(cash);
			
			//매도 청산
			int dbselloutcash = ((dbsellprice * quantityint) - (hiddenpriceinputint * quantityint)) + (dbsellprice * quantityint); 
			//잔액에 반영된 매도청산
			BigInteger dbsellouttotalcash = firstquantity.multiply(BigInteger.valueOf(hiddencash + dbselloutcash));
			
			//매수 청산
			int dbbuyoutcash = ((hiddenpriceinputint * quantityint) - (dbsellprice * quantityint)) + (dbsellprice * quantityint);
			//잔액에 반영된 매수청산
			BigInteger dbbuyouttotalcash = firstquantity.multiply(BigInteger.valueOf(hiddencash + dbbuyoutcash)); 
			
			/*총액이 주문가능금액(내가 보유한 현금)보다 적거나 같을경우 정상거래 */
			if (buyorsell == 0 && quantity != null) {
				if (dbquantity == 0 /*보유종목개수가 0일경우*/) {
					if(totalhiddenint <= hiddencash && hiddenpriceinputint < hiddencash){
						result = 0;
						model.addAttribute("result", result);
						ts.buyTrade(trade, id, totalhidden, symbol, hiddenpriceinput, quantity);
						System.out.println("매수 완료");
						pfs.buyTrade(id, cash, symbol, hiddenpriceinput, quantity);
						System.out.println("포트폴리오 매수 업데이트 완료");
					}else if(hiddencash < totalhiddenint && hiddenpriceinputint < hiddencash){
						result = 11;
						model.addAttribute("result", result);
						System.out.println("잔액이 부족합니다. -> 보유금액 < 주문총액 && 매수가격 < 보유금액");
					}else if(totalhiddenint <= hiddencash && hiddencash < hiddenpriceinputint) {
						result = 11;
						model.addAttribute("result", result);
						System.out.println("잔액이 부족합니다. -> 주문총액 <= 보유금액 && 보유금액 < 매수가격");
					}else {
						result = 11;
						model.addAttribute("result", result);
						System.out.println("매수 오류");
					}
				} else if (1 <= dbquantity && dbbuyprice != 0 /*보유종목개수가 1보다 높을때*/) {
					if(totalhiddenint <= hiddencash && hiddenpriceinputint < hiddencash){
						result = 1;
						model.addAttribute("result", result);
						ts.buyTrade(trade, id, totalhidden, symbol, hiddenpriceinput, quantity);
						System.out.println("추가 매수 완료");
						pfs.buyTrade(id, cash, symbol, hiddenpriceinput, quantity);
						System.out.println("포트폴리오 추가 매수 업데이트 완료");
					}else if(hiddencash < totalhiddenint && hiddenpriceinputint < hiddencash){
						result = 11;
						model.addAttribute("result", result);
						System.out.println("잔액이 부족합니다. -> 보유금액 < 주문총액 && 매수가격 < 보유금액");
					}else if(totalhiddenint <= hiddencash && hiddencash < hiddenpriceinputint) {
						result = 11;
						model.addAttribute("result", result);
						System.out.println("잔액이 부족합니다. -> 주문총액 <= 보유금액 && 보유금액 < 매수가격");
					}else {
						result = 11;
						model.addAttribute("result", result);
						System.out.println("추가매수 오류.");
					}
				} else if(dbsellprice != 0 && dbquantity < 0 /*보유종목개수가 0보다 낮을경우*/){
					if (quantityint > (-1 * dbquantity)) {
						result = 9;
						model.addAttribute("result", result);
						System.out.println("보유한 수량보다 주문한 수량이 많습니다.");
					}else {
						result = 6;
						model.addAttribute("result",result);
						ts.sellout(trade, id, totalhidden, symbol, hiddenpriceinput, quantity);
						System.out.println("매도 청산 완료");
						pfs.sellout(id, dbsellouttotalcash, symbol, hiddenpriceinput, quantity);
						System.out.println("포트폴리오 매도 청산 완료");
					}
				}
			} else if(buyorsell == 1 && quantity != null) {
				if (dbquantity == 0 /* 보유종목개수가 0과같을경우*/ ) {
					if(totalhiddenint <= hiddencash && hiddenpriceinputint < hiddencash){
						result = 2;
						model.addAttribute("result", result);
						ts.sellTrade(trade, id, totalhidden, symbol, hiddenpriceinput, quantity);
						System.out.println("매도완료");
						
						pfs.sellTrade(id, cash, symbol, hiddenpriceinput, quantity);
						System.out.println("포트폴리오 매도 업데이트 완료");
					}else if(hiddencash < totalhiddenint && hiddenpriceinputint < hiddencash) {
						result = 11;
						model.addAttribute("result", result);
						System.out.println("잔액이 부족 합니다. 보유금액 < 주문총액 && 매수가격 < 보유금액");
					}else if(totalhiddenint <= hiddencash && hiddencash < hiddenpriceinputint) {
						result = 11;
						model.addAttribute("result", result);
						System.out.println("잔액이 부족 합니다. 주문총액 <= 보유금액 && 보유금액 < 매수가격");
					}else {
						result = 11;
						model.addAttribute("result", result);
						System.out.println("잔액이 부족합니다.");
					}
				}else if(dbsellprice != 0 && dbquantity <= -1 /*quantity가 0보다 작을경우*/){
					if(totalhiddenint <= hiddencash && hiddenpriceinputint < hiddencash){
						result = 3;
						model.addAttribute("result", result);
						ts.sellTrade(trade, id, totalhidden, symbol, hiddenpriceinput, quantity);
						pfs.sellTrade(id, cash, symbol, hiddenpriceinput, quantity);
						System.out.println("추가매도 완료");
					}else if(hiddencash < totalhiddenint && hiddenpriceinputint < hiddencash) {
						result = 11;
						model.addAttribute("result", result);
						System.out.println("잔액이 부족합니다. 보유금액 < 주문총액 && 매수가격 < 보유금액");
					}else if(totalhiddenint <= hiddencash && hiddencash < hiddenpriceinputint) {
						result = 11;
						model.addAttribute("result", result);
						System.out.println("잔액이 부족 합니다. 주문총액 <= 보유금액 && 보유금액 < 매수가격");
					}else {
						result = 11;
						model.addAttribute("result", result);
						System.out.println("잔액이 부족합니다.");
					}
				}else if(dbbuyprice != 0 && 0 < dbquantity ) {
					if (quantityint > dbquantity) {
						result = 10;
						model.addAttribute("result", result);
						System.out.println("보유한 수량보다 주문한 수량이 많습니다.");
					}else {
						result = 7;
						model.addAttribute("result", result);
						ts.buyout(trade, id, totalhidden, symbol, hiddenpriceinput, quantity);
						System.out.println("매수 청산 완료");
						pfs.buyout(id, dbbuyouttotalcash, symbol, hiddenpriceinput, quantity);
						System.out.println("포트폴리오 매수 청산 완료");
					}
				}
			}else if((buyorsell == 0 || buyorsell == 1) && quantity == null){
				result = 4;
				model.addAttribute("result", result);
				System.out.println("주문수량을 입력해 주세요.");
			}else if(quantity != null && !(buyorsell == 0 || buyorsell == 1)) {
				result = 5;
				model.addAttribute("result", result);
				System.out.println("매수 및 매도를 선택해 주세요.");
			}else {
				result = 8;
				model.addAttribute("result", result);
				System.out.println("오류입니다.");
			}

		} catch (NumberFormatException e) {
			result = 4;
			model.addAttribute("result", result);
			System.out.println("주문수량을 입력하세요.");
		}
		return "tradeStockPro";
	}
}

