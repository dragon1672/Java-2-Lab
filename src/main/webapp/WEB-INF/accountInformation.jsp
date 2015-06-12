<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="${pageContext.request.contextPath}/resources/MainStyle.css" rel="stylesheet">
    <title>User Account Information</title>
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
  <div class="accountInfo">
    <div class="textInputField">
      Account name: ${model.displayName}
    </div>
    <div class="textInputField">
      First name: ${model.firstName}
    </div>
    <div class="textInputField">
      Last name: ${model.lastName}
    </div>
    <div class="textInputField">
      Email: ${model.email}
    </div>
    <div class="textInputField">
      User ID: ${model.ID}
    </div>
    <div class="textInputField">
      User Avatar URL: ${model.avatarURL}
    </div>
    <div>
      <img class="userAvatar" src="${model.avatarURL}"/>
    </div>
  </div>
</body>
</html>
