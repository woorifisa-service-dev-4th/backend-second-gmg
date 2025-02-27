package com.gmg.model;


public class ChatMessage {
	private String id;
	private String roomId;
	private String content;

	public ChatMessage(String id, String roomId, String content) {
		this.id = id;
		this.roomId = roomId;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
