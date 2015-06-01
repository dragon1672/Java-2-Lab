<%--
  Created by IntelliJ IDEA.
  User: tlousignont
  Date: 5/21/2015
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="header.jsp" />
<div> Create a game of ${GameInfo.getName()}</div>
<form class="GameCreationForm" action="${pageContext.request.contextPath}/makeGame/${GameInfo.getID()}/Create" method="POST">
  <div class="textInputField">
    room name: <input class="gameInputField" type="text" name="roomName" maxlength="40">
  </div>
  <div class="textInputField">
    Game password: <input class="gameInputField" type="text" name="gamePassword" maxlength="40">
  </div>
  <div>
    Max number of players:   <input type="number" name="numPlayers" min="1" max="5">
  </div>
  <input type="submit" value="Create Game Room">
</form>
</body>
</html>
