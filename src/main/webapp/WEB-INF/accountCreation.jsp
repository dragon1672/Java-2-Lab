<%--
  Created by IntelliJ IDEA.
  User: tlousignont
  Date: 5/18/2015
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account Creation</title>
</head>
<body>
<jsp:include page="header.jsp" />
<form class="accountCreationForm" action="${pageContext.request.contextPath}/accountCreation" method="POST">
  <div class="textInputField">
    Account name: <input class="accountInputField" type="text" name="accountName">
  </div>
  <div class="textInputField">
    First name: <input class="accountInputField" type="text" name="firstName">
  </div>
  <div class="textInputField">
    Last name: <input class="accountInputField" type="text" name="lastName">
  </div>
  <div class="textInputField">
    Password: <input class="accountInputField" type="text" name="password">
  </div>
  <div class="textInputField">
    Email: <input class="accountInputField" type="text" name="email">
  </div>
  <input type="submit" value="Create Account">
</form>
</body>
</html>
