package com.gmg.model;


public class ChatMessage {
	private int id;
	private int roomId;
	private String content;

	public ChatMessage(int id, int roomId, String content) {
		this.id = id;
		this.roomId = roomId;
		this.content = content;
	}

	public int getId() {
		return id;
	}


	public int getRoomId() {
		return roomId;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
