package com.gmg.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/chat/*")
public class FrontController extends HttpServlet {
	private final Map<String, Controller> controllerMap = new HashMap<>();

	@Override
	public void init() {
		controllerMap.put("/chatrooms", new ChatRoomController());
		controllerMap.put("/chatroom", new ChatMessageController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		Controller controller = controllerMap.get(path);

		if (controller != null) {
			String view = controller.handleRequest(req, resp);
			req.getRequestDispatcher("/WEB-INF/views/" + view + ".jsp").forward(req, resp);
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
