<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RPS</title>
  <style type="text/css">
    span { cursor: hand; }
    .button { cursor: hand; }
    form { margin-bottom: 0; margin-top: 0; display: inline;}
  </style>
</head>
<body>
<jsp:include page="header.jsp" />

<h2>Rock Paper Scissors</h2>
<p>Hello <%= session.getAttribute("username") %> please pick Rock, Paper, or Scissors</p>
<form action="${pageContext.request.contextPath}/RPS" method="GET">
  <input type="text" name="RPSMove" style="display: none" value ="rock"/>
  <input class="button" type="submit" value="Rock"/>
</form>
<form action="${pageContext.request.contextPath}/RPS" method="GET">
  <input type="text" name="RPSMove" style="display: none" value ="paper"/>
  <input class="button" type="submit" value="Paper"/>
</form>
<form action="${pageContext.request.contextPath}/RPS" method="GET">
  <input type="text" name="RPSMove" style="display: none" value ="scissors"/>
  <input class="button" type="submit" value="Scissors"/>
</form>
</body>
</html>
