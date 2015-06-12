<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="${pageContext.request.contextPath}/resources/MainStyle.css" rel="stylesheet">
    <title></title>
</head>
<body>
<c:if test="${empty sessionScope.username}">
  <jsp:include page="HeaderNoUser.jsp" />
</c:if>
<c:if test="${not empty sessionScope.username}">
  <jsp:include page="HeaderHasUser.jsp" />
</c:if>
<div class="content"/>
<div class="innerImage"></div>
<div class="innerContent"/>
<h1 class="postHeader"></h1>
<h1> Create a game of ${GameInfo.getName()}</h1>
<form class="GameCreationForm" action="${pageContext.request.contextPath}/makeGame/${GameInfo.getID()}/Create" method="POST">
  <div class="textInputField">
    Room name: <input class="gameInputField" type="text" name="roomName" maxlength="40">
  </div>
  <div class="textInputField">
    Game password: <input class="gameInputField" type="text" name="gamePassword" maxlength="40">
  </div>
  <div class="textInputField">
    Max number of players:   <input type="number" name="numPlayers" min="1" max="5">
  </div>
  <input type="submit" value="Create Game Room">
</form>
</body>
</html>
