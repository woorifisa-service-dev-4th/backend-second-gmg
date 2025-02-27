<%--
  Created by IntelliJ IDEA.
  User: sweet
  Date: 2025-02-27
  Time: 오전 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, model.ChatRoom" %>
<%
    List<ChatRoom> chatRooms = (List<ChatRoom>) request.getAttribute("chatRooms");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>채팅방 목록</title>
    <style>
        body { font-family: Arial, sans-serif; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: center; }
        th { background-color: #f4f4f4; }
        .join-btn { padding: 5px 10px; background-color: #007bff; color: white; border: none; cursor: pointer; }
        .join-btn:hover { background-color: #0056b3; }
    </style>
</head>
<body>
<h2>채팅방 목록</h2>
<table>
    <tr>
        <th>ID</th>
        <th>채팅방 이름</th>
        <th>현재 인원</th>
        <th>입장</th>
    </tr>
    <% if (chatRooms != null && !chatRooms.isEmpty()) { %>
    <% for (ChatRoom room : chatRooms) { %>
    <tr>
        <td><%= room.getId() %></td>
        <td><%= room.getName() %></td>
        <td><%= room.getUserCount() %>명</td>
        <td><button class="join-btn" onclick="joinChat(<%= room.getId() %>)">입장</button></td>
    </tr>
    <% } %>
    <% } else { %>
    <tr><td colspan="4">등록된 채팅방이 없습니다.</td></tr>
    <% } %>
</table>

<script>
    function joinChat(roomId) {
        alert("채팅방 " + roomId + "에 입장합니다.");
    }
</script>
</body>
</html>
