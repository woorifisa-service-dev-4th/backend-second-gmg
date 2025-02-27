package com.gmg.dao;

import java.util.List;
import java.util.ArrayList;

import com.gmg.model.ChatMessage;

public class ChatMessageDAO {
	private static final List<ChatMessage> messages = new ArrayList<>();

	public void sendMessage(String roomId, String content) {
		messages.add(new ChatMessage(String.valueOf(messages.size() + 1), roomId, content));
	}

	public List<ChatMessage> getMessagesByRoomId(String roomId) {
		List<ChatMessage> roomMessages = new ArrayList<>();
		for (ChatMessage msg : messages) {
			if (msg.getRoomId().equals(roomId)) {
				roomMessages.add(msg);
			}
		}
		return roomMessages;
	}
}
