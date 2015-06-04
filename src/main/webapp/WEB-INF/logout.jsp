<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1>Log Out </h1>
<h3>Are you sure you want to logout?</h3>
<form action="${pageContext.request.contextPath}/logout" method="POST">
  <input type="submit" value="Confirm"/>
</form>
</body>
</html>
