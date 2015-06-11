<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start RPS</title>
  <style type="text/css">
    span { cursor: hand; }
    .button { cursor: hand; }
    form { margin-bottom: 0; margin-top: 0; display: inline;}
  </style>
</head>
<body>
<c:if test="${empty sessionScope.username}">
  <jsp:include page="HeaderNoUser.jsp" />
</c:if>
<c:if test="${not empty sessionScope.username}">
  <jsp:include page="HeaderHasUser.jsp" />
</c:if>

<h2>Rock Paper Scissors</h2>
<p>Hello ${model.currentPlayer} please pick Rock, Paper, or Scissors. Your opponent is ${model.otherPlayer}</p>
<form method="GET">
  <input type="text" name="RPSMove" style="display: none" value ="rock"/>
  <input class="button" type="submit" value="Rock"/>
</form>
<form method="GET">
  <input type="text" name="RPSMove" style="display: none" value ="paper"/>
  <input class="button" type="submit" value="Paper"/>
</form>
<form method="GET">
  <input type="text" name="RPSMove" style="display: none" value ="scissors"/>
  <input class="button" type="submit" value="Scissors"/>
</form>
</body>
</html>
