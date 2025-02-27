package controller;

import dao.ChatRoomDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/chatAdd")
public class ChatAddController extends HttpServlet {
    private ChatRoomDAO chatRoomDAO = new ChatRoomDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomIdParam = request.getParameter("roomId");
        String content = request.getParameter("content");

        if (roomIdParam == null || roomIdParam.isEmpty() || content == null || content.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "채팅방 ID와 메시지를 입력하세요.");
            return;
        }

        try {
            long roomId = Long.parseLong(roomIdParam);

            // 채팅 메시지 저장
            chatRoomDAO.insertChatMessage(roomId, content);

            // 메시지 추가 후 채팅방으로 리디렉션
            response.sendRedirect("chatList?roomId=" + roomId);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "유효한 채팅방 ID를 입력하세요.");
        }
    }
}
