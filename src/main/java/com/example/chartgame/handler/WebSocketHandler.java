package com.example.chartgame.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@Component
public class WebSocketHandler extends TextWebSocketHandler {
	private List<WebSocketSession> sessions = new ArrayList<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception{
		sessions.add(session);
		System.out.println("접속: {"+session+"}");
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
		System.out.println("메세지 전송 = {"+session+"}" + ": {"+message.getPayload()+"}");
		for(WebSocketSession sess : sessions ) {
			TextMessage msg = new TextMessage(message.getPayload());
			sess.sendMessage(msg);
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
		sessions.remove(session);
		System.out.println("퇴장 : {"+session+"}");
	}
}
