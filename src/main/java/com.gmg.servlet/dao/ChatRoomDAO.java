package dao;

import model.ChatMessage;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChatRoomDAO {

    // 특정 room_id의 메시지 목록 조회
    public List<ChatMessage> getChatMessages(long roomId) {
        List<ChatMessage> messages = new ArrayList<>();
        String sql = "SELECT message_id, room_id, content, created_at " +
                "FROM messages WHERE room_id = ? ORDER BY created_at ASC";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, roomId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ChatMessage message = new ChatMessage(
                            rs.getLong("message_id"),
                            rs.getLong("room_id"),
                            rs.getString("content"),
                            rs.getTimestamp("created_at").toLocalDateTime()
                    );
                    messages.add(message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return messages;
    }

    // 특정 room_id에 메시지 저장
    public boolean insertChatMessage(long roomId, String content) {
        String sql = "INSERT INTO messages (room_id, content, created_at) VALUES (?, ?, NOW())";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, roomId);
            pstmt.setString(2, content);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
