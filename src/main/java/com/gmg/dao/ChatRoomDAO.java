package com.gmg.dao;

import java.util.List;
import java.util.ArrayList;

import com.gmg.model.ChatRoom;

public class ChatRoomDAO {
	private static final List<ChatRoom> rooms = new ArrayList<>();

	public void createChatRoom(String name) {
		rooms.add(new ChatRoom(String.valueOf(rooms.size() + 1), name));
	}

	public List<ChatRoom> getAllChatRooms() {
		return rooms;
	}
}

