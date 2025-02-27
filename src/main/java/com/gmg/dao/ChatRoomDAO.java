package com.gmg.dao;

import static com.gmg.utils.DBUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;

import com.gmg.model.ChatRoom;

public class ChatRoomDAO {

	public List<ChatRoom> findAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset;
		ChatRoom chatRoom;
		List<ChatRoom> chatList = new ArrayList<>();

		String query = "SELECT * FROM rooms";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				int roomId = rset.getInt("room_id");
				String roomName = rset.getString("room_name");
				Timestamp createdAtTimestamp = rset.getTimestamp("created_at");

				// LocalDateTime으로 변환
				LocalDateTime createdAt = createdAtTimestamp.toInstant()
					.atZone(ZoneId.systemDefault())
					.toLocalDateTime();

				chatRoom = new ChatRoom(roomId,roomName,createdAt);
				chatList.add(chatRoom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

		return chatList;
	}

	public int createChatRoom(String roomName) {
		int result = 0;
		String query = "INSERT INTO rooms (room_name) VALUES (?)";
		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setString(1,roomName);
			// DB QEURY 수행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

}
