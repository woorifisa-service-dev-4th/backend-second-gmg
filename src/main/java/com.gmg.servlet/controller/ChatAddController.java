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
        String chatRoomIdParam = request.getParameter("chatRoomId");
        String message = request.getParameter("message");

        // chatRoomId와 message가 올바르게 전달되었는지 확인
        if (chatRoomIdParam == null || chatRoomIdParam.isEmpty() || message == null || message.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "채팅방 ID와 메시지를 입력하세요.");
            return;
        }

        try {
            int chatRoomId = Integer.parseInt(chatRoomIdParam);

            // 채팅 메시지 저장
            chatRoomDAO.insertChatMessage(chatRoomId, message);

            // 메시지 추가 후 해당 채팅방으로 리디렉션
            response.sendRedirect("chatList?chatRoomId=" + chatRoomId);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "유효한 채팅방 ID를 입력하세요.");
        }
    }
}
