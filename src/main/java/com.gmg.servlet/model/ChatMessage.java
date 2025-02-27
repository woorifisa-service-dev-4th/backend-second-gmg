package model;


import java.time.LocalDateTime;

public class ChatMessage {
    private int id;
    private int chatRoomId;
    private String sender;
    private String message;
    private LocalDateTime createdAt;

    public ChatMessage(int id, int chatRoomId, String sender, String message, LocalDateTime createdAt) {
        this.id = id;
        this.chatRoomId = chatRoomId;
        this.sender = sender;
        this.message = message;
        this.createdAt = createdAt;
    }

    // Getter 및 Setter
    public int getId() { return id; }
    public int getChatRoomId() { return chatRoomId; }
    public String getSender() { return sender; }
    public String getMessage() { return message; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}

