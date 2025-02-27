<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>채팅방 목록</title></head>
<body>
<h2>채팅방 목록</h2>
<ul>
  <c:forEach var="room" items="${chatRooms}">
    <li>
      <a href="/chat/chatroom?roomId=${room.id}">${room.name}</a>
    </li>
  </c:forEach>
</ul>
<form action="/chat/chatrooms?action=create" method="post">
  <input type="hidden" name="action" value="create">
  <input type="text" name="roomName" placeholder="채팅방 이름">
  <button type="submit">채팅방 만들기</button>
</form>
</body>
</html>
