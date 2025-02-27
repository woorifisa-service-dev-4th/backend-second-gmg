package dao;

import model.ChatMessage;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChatRoomDAO {
    public List<ChatMessage> getChatMessages(int chatRoomId) {
        List<ChatMessage> messages = new ArrayList<>();
        String sql = "SELECT * FROM chat_messages WHERE chat_room_id = ? ORDER BY created_at ASC";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, chatRoomId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ChatMessage message = new ChatMessage(
                            rs.getInt("id"),
                            rs.getInt("chat_room_id"),
                            rs.getString("sender"),
                            rs.getString("message"),
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
}
