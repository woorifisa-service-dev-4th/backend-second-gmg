package controller;


import dao.ChatRoomDAO;
import model.ChatRoom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/chatList")
public class ChatRoomController implements ControllerV1 {
    private ChatRoomDAO chatRoomDAO = new ChatRoomDAO();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // DB에서 채팅방 목록 조회
        List<ChatRoom> chatRooms = chatRoomDAO.getChatRooms();

        // JSP로 데이터 전달
        request.setAttribute("chatRooms", chatRooms);
        request.getRequestDispatcher("/chatList.jsp").forward(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/chatroom/list.jsp");
        dispatcher.forward(request, response);
    }
}
