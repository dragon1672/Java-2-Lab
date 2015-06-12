<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/MainStyle.css" rel="stylesheet">
    <title>Login</title>
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
<h1 class="postHeader">Log In </h1>
<form class="accountCreationForm" action="${pageContext.request.contextPath}/login" method="POST">
    <div class="textInputField">
        Username: <input class="accountInputField" type="text" name="username" placeholder="username"/>
    </div>
    <div class="textInputField">
        Password: <input class="accountInputField" type="password" name="password" placeholder="password"/></div>
  <input type="submit" value="Login"/>
</form>
</body>
</html>
