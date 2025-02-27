package com.gmg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.gmg.dao.ChatRoomDAO;
import com.gmg.model.ChatRoom;

public class ChatRoomController implements Controller {
	private final ChatRoomDAO chatRoomDAO = new ChatRoomDAO();

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws
		UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if ("create".equals(action)) {
			String roomName = request.getParameter("roomName");
			chatRoomDAO.createChatRoom(roomName);
		}
		List<ChatRoom> chatRooms = chatRoomDAO.getAllChatRooms();
		request.setAttribute("chatRooms", chatRooms);
		return "chatlist";
	}
}
