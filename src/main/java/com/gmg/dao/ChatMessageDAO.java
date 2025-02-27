package com.gmg.dao;

import static com.gmg.utils.DBUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import com.gmg.model.ChatMessage;

public class ChatMessageDAO {
	private static final List<ChatMessage> messages = new ArrayList<>();

	public int sendMessage(int roomId, String content) {
		int result = 0;
		String query = "INSERT INTO messages (room_id, content) VALUES (?, ?)";

		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(query)) {

			pstmt.setInt(1, roomId);
			pstmt.setString(2, content);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<ChatMessage> getMessagesByRoomId(int roomId) {
		List<ChatMessage> messages = new ArrayList<>();
		String query = "SELECT message_id,room_id, content, created_at FROM messages WHERE room_id = ? ORDER BY created_at ASC";

		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setInt(1, roomId);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					int messageId = rs.getInt("message_id");
					String content = rs.getString("content");
					// LocalDateTime으로 변환
					messages.add(new ChatMessage(messageId, roomId, content));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return messages;
	}
}
