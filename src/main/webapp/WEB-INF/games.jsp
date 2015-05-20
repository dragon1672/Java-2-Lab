<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tlousignont
  Date: 5/19/2015
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="header.jsp" />

<c:forEach items="${games}" var="game">
  <div class="gameDisplay">
    <div class="gameName">
      <p>${game.getName()}</p>
    </div>
    <div class="gameDescription">
      <p>${game.getDescription()}</p>
    </div>
  </div>
  <br>
</c:forEach>
</body>
</html>
