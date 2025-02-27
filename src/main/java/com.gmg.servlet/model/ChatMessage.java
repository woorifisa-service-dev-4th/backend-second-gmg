package model;

import java.time.LocalDateTime;

public class ChatMessage {
    private long messageId;  // message_id
    private long roomId;     // room_id
    private String content;  // content
    private LocalDateTime createdAt; // created_at

    public ChatMessage(long messageId, long roomId, String content, LocalDateTime createdAt) {
        this.messageId = messageId;
        this.roomId = roomId;
        this.content = content;
        this.createdAt = createdAt;
    }

    // Getter 및 Setter
    public long getMessageId() { return messageId; }
    public long getRoomId() { return roomId; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
