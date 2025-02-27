package model;


import java.time.LocalDateTime;

public class ChatMessage {
    private int id;
    private int chatRoomId;
    private String message;
    private LocalDateTime createdAt;

    public ChatMessage(int id, int chatRoomId,  String message, LocalDateTime createdAt) {
        this.id = id;
        this.chatRoomId = chatRoomId;
        this.message = message;
        this.createdAt = createdAt;
    }

    // Getter 및 Setter
    public int getId() { return id; }
    public int getChatRoomId() { return chatRoomId; }
    public String getMessage() { return message; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}

