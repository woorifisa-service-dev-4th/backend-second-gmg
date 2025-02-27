package com.gmg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.gmg.dao.ChatMessageDAO;
import com.gmg.model.ChatMessage;

public class ChatMessageController implements Controller {
	private final ChatMessageDAO chatMessageDAO = new ChatMessageDAO();

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws
		UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String roomId = request.getParameter("roomId");
		String action = request.getParameter("action");

		if ("send".equals(action)) {
			String content = request.getParameter("content");
			chatMessageDAO.sendMessage(roomId, content);
		}

		List<ChatMessage> messages = chatMessageDAO.getMessagesByRoomId(roomId);
		request.setAttribute("messages", messages);
		request.setAttribute("roomId", roomId);
		return "chatting_room";
	}
}
