<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<c:if test="${empty sessionScope.username}">
    <jsp:include page="HeaderNoUser.jsp" />
</c:if>
<c:if test="${not empty sessionScope.username}">
    <jsp:include page="HeaderHasUser.jsp" />
</c:if>
<h1>Log Out </h1>
<h3>Are you sure you want to logout?</h3>
<form action="${pageContext.request.contextPath}/logout" method="POST">
  <input type="submit" value="Confirm"/>
</form>
</body>
</html>
