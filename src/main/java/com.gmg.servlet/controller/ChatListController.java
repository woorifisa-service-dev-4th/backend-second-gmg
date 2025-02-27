package controller;

import dao.ChatRoomDAO;
import model.ChatMessage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/chatList")
public class ChatListController implements ControllerV1 {
    private ChatRoomDAO chatRoomDAO = new ChatRoomDAO();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청에서 chatRoomId 가져오기
        String chatRoomIdParam = request.getParameter("chatRoomId");

        if (chatRoomIdParam == null || chatRoomIdParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "채팅방 ID가 필요합니다.");
            return;
        }

        try {
            int chatRoomId = Integer.parseInt(chatRoomIdParam);

            // DB에서 특정 채팅방의 채팅 내역 조회
            List<ChatMessage> messages = chatRoomDAO.getChatMessages(chatRoomId);

            // JSP로 데이터 전달
            request.setAttribute("messages", messages);
            request.setAttribute("chatRoomId", chatRoomId);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/chatroom/detail.jsp");
            dispatcher.forward(request, response);

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "유효한 채팅방 ID를 입력하세요.");
        }
    }
}
