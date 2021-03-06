<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <link href="${pageContext.request.contextPath}/resources/MainStyle.css" rel="stylesheet">
      <title></title>
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
    <h1 class="postHeader">Matchmaking</h1>
    <c:if test="${sessionScope.username != null}">
        <form class="findGameMatchmadeForm" action="" method="POST">
            <input type="submit"  value="Search for Opponent">
        </form>
    </c:if>
    <h1>Find a room</h1>
    <div class="allRooms">
        <c:forEach items="${rooms}" var="room">
            <div class="roomDisplay">
                <div class="roomDisplayFeild">Room name: ${room.getRoomName()}</div>
                <div class="roomDisplayFeild">Number of players: ${room.getCurrentNumberOfPlayers()} / ${room.getMaxPlayers()}</div>
                <c:if test="${sessionScope.username != null}">
                <form class="findGameSpecificRoomForm" action="/join" method="POST">
                    <input name="roomID" type="hidden" class="findGameField" value="<c:out value="${room.getID()}"/>"/>
                    <input type="submit" value="Enter Room"/>
                </form>
                </c:if>
            </div>
        </c:forEach>
  </div>
  </body>
</html>
