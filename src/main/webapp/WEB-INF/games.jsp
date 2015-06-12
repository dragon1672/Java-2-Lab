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
<div class="content">
  <div class="innerImage"></div>
<div class="innerContent">
<h1 class="postHeader">Bellow is a list of all game types on the site:</h1>
<c:forEach items="${games}" var="game">
  <div class="gameDisplay">
    <div class="gameName">
      <p>${game.getName()}</p>
    </div>
    <div class="gameDescription">
      <p>${game.getDescription()}</p>
    </div>

    <form method="GET" action="${pageContext.request.contextPath}/makeGame/${game.getID()}">
      <input type="submit" value="Create Room">
    </form>
    <form method="GET" action="${pageContext.request.contextPath}/findGame/${game.getID()}">
      <input type="submit" value="Find Room">
    </form>
  </div>
  <br>
</c:forEach>
</div>
</div>
</body>
</html>
