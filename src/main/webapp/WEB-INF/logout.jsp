<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/MainStyle.css" rel="stylesheet">
    <title>Logout</title>
</head>
<body>
<<<<<<< HEAD
<c:if test="${empty sessionScope.username}">
    <jsp:include page="HeaderNoUser.jsp" />
</c:if>
<c:if test="${not empty sessionScope.username}">
    <jsp:include page="HeaderHasUser.jsp" />
</c:if>
<div class="content"/>
<div class="innerImage"></div>
<div class="innerContent"/>
<h1 class="postHeader">Log Out </h1>
<h3>Are you sure you want to logout?</h3>
<form action="${pageContext.request.contextPath}/logout" method="POST">
  <input type="submit" value="Confirm"/>
</form>
</body>
</html>
