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
<form class="accountCreationForm">
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
    Password name: <input class="accountInputField" type="text" name="password">
  </div>
  <div class="textInputField">
    Email: <input class="accountInputField" type="text" name="email">
  </div>
  <input type="submit" value="Submit">
</form>
</body>
</html>
