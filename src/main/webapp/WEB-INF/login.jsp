<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1>Log In </h1>
<form action="${pageContext.request.contextPath}/user/login/" method="POST">
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
