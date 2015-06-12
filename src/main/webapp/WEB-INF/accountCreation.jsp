<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/MainStyle.css" rel="stylesheet">
    <title>Account Creation</title>
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
<h1 class="postHeader"/>
<form class="accountCreationForm" action="${pageContext.request.contextPath}/accountCreation" method="POST">
  <div class="textInputField">
    Account name: <input class="accountInputField" type="text" name="accountName" maxlength="40">
  </div>
  <div class="textInputField">
    First name: <input class="accountInputField" type="text" name="firstName" maxlength="40">
  </div>
  <div class="textInputField">
    Last name: <input class="accountInputField" type="text" name="lastName" maxlength="40">
  </div>
  <div class="textInputField">
    Email: <input class="accountInputField" type="text" name="email" maxlength="100">
  </div>
  <div class="textInputField">
    Password: <input class="accountInputField" type="text" name="password" maxlength="100">
  </div>
  <div class="textInputField">
    Avatar URL: <input class="accountInputField" type="text" name="avatar" maxlength="100">
  </div>
  <input type="submit" value="Create Account">
</form>
</body>
</html>
