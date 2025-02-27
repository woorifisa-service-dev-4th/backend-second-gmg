package dao;

import model.ChatRoom;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChatRoomDAO {

    public List<ChatRoom> getChatRooms() {
        List<ChatRoom> chatRooms = new ArrayList<>();
        String query = "SELECT id, name, user_count FROM chat_rooms ORDER BY id DESC";

        try (Connection conn = DBUtil.getConnection(); // DBUtil 활용
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int userCount = rs.getInt("user_count");

                chatRooms.add(new ChatRoom(id, name, userCount));
            }
        } catch (SQLException e) {
            System.err.println("DB 조회 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
        return chatRooms;
    }
}
