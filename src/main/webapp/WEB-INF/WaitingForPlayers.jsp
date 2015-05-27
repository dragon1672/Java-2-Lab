<%--
  Created by IntelliJ IDEA.
  User: awayman
  Date: 5/21/2015
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Waiting For Players</title>
</head>
<body>
  <h1>Waiting For Players</h1>
  Heard you liked playing games, but we need other people so hold your horses.
  This page will autorefresh in a few seconds... Sorry Anthony :P
  <% response.setIntHeader("Refresh", 8);%>
</body>
</html>
