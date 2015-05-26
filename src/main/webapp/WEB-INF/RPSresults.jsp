<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="model" scope="request" type="edu.neumont.projectFiles.controllers.RockPaperScissorsPage.QuickGameModel"/>
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
<p>
  Greetings your play session has finished. ${model.user1.displayName} played ${model.user1Choice}, while ${model.user2.displayName} played ${model.user2Choice}.
</p>
<h5>The winner is ${model.winner}</h5>
</body>
</html>
