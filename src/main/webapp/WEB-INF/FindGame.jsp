<%--
  Created by IntelliJ IDEA.
  User: awayman
  Date: 5/21/2015
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title></title>
  </head>
  <body>
    <jsp:include page="header.jsp" />
    <h1>Matchmaking</h1>
    <form class="findGameMatchmadeForm" action="" method="POST">
      <input type="submit"  value="Search for Opponent">
    </form>
    <h1>Find a room</h1>
    <form class="findGameSpecificRoomForm" action="" method="POST">
      <div class="textInputField">
        Room ID: <input type="text" class="findGameField" value=""/>
      </div>
      <input type="submit" value="Enter Room"/>
    </form>
  </body>
</html>
