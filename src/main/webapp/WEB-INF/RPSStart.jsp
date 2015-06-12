<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Start RPS</title>
  <link href="${pageContext.request.contextPath}/resources/MainStyle.css" rel="stylesheet">
  <style type="text/css">
    span { cursor: hand; }
    .button { cursor: hand; }
    form { margin-bottom: 0; margin-top: 0; display: inline;}
  </style>
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
<h1 class="postHeader">Rock Paper Scissors</h1>
<p class="info">Hello ${model.currentPlayer} please pick Rock, Paper, or Scissors. Your opponent is ${model.otherPlayer}</p>
<form method="GET">
  <input type="text" name="RPSMove" style="display: none" value ="rock"/>
  <input class="button" type="image" src="${pageContext.request.contextPath}/resources/Rock_RPS.png" value="Rock"/>
</form>
<form method="GET">
  <input type="text" name="RPSMove" style="display: none" value ="paper"/>
  <input class="button" type="image" src="${pageContext.request.contextPath}/resources/Hand_RPS.png"  value="Paper"/>
</form>
<form method="GET">
  <input type="text" name="RPSMove" style="display: none" value ="scissors"/>
  <input class="button" type="image" src="${pageContext.request.contextPath}/resources/Scissors_RPS.png"  value="Scissors"/>
</form>
</body>
</html>
