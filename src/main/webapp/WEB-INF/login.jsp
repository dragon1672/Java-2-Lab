<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<c:if test="${empty sessionScope.username}">
    <jsp:include page="HeaderNoUser.jsp" />
</c:if>
<c:if test="${not empty sessionScope.username}">
    <jsp:include page="HeaderHasUser.jsp" />
</c:if>
<h1>Log In </h1>
<form action="${pageContext.request.contextPath}/login" method="POST">
    <h5>Username:</h5>
  <input type="text" name="username" placeholder="username"/>
  <br/><br/>
    <h5>Password:</h5>
  <input type="password" name="password" placeholder="password"/>
  <br/><br/>
  <input type="submit" value="Login"/>
</form>
</body>
</html>
