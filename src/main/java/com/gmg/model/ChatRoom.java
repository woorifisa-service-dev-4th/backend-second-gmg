package com.gmg.model;

import java.time.LocalDateTime;

public class ChatRoom {
	int id;

	private String roomName;
	private LocalDateTime createdAt;

	public ChatRoom(int id, String name) {
		this.id = id;
		this.roomName = name;
		this.createdAt = LocalDateTime.now();
	}
	public ChatRoom(int id, String name,LocalDateTime createdAt) {
		this.id = id;
		this.roomName = name;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public String getRoomName() {
		return roomName;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

}
