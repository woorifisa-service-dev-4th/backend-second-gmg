<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>채팅방</title>
</head>
<body>

<h2>채팅방 - ${roomId}</h2>

<!-- 채팅 메시지 출력 -->
<c:forEach var="message" items="${messages}">
    <p> ${message.content}</p>
</c:forEach>

<!-- 메시지 입력 폼 -->
<form action="/chat/chatroom" method="post">
    <input type="hidden" name="roomId" value="${roomId}">
    <input type="hidden" name="action" value="send">
    <input type="text" name="content" placeholder="메시지 입력" required>
    <button type="submit">전송</button>
</form>

<a href="/chat/chatrooms">채팅방 목록으로 돌아가기</a>

</body>
</html>
