<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div>Rooms:</div>
    <c:forEach items="${rooms}" var="room">
        <div class="roomDisplay">
            <div class="roomDisplayFeild">Room name: ${room.getRoomName()}</div>
            <div class="roomDisplayFeild">ID: ${room.getID()}</div>
            <div class="roomDisplayFeild">Number of players: ${room.getCurrentNumberOfPlayers()} / ${room.getMaxPlayers()}</div>
        </div>
    </c:forEach>
  </body>
</html>
