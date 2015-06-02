<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RPS Results</title>
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
    ${model.P1} played ${model.P1Choice}
    ${model.P2} played ${model.P2Choice}
    ${model.WinChoice} ${model.BeatStatement} ${model.LoseChoice}
        <img src="${model.WinChoicePicPath} ">
    ${model.BeatStatement}
        <img src="${model.LoseChoicePicPath} ">

    <h3>You ${model.WonOrLost}</h3>
</p>

<form action="${pageContext.request.contextPath}/RPS" method="GET">
  <input class="button" type="submit" value="Click to Play Another Game"/>
</form>
<form action="${pageContext.request.contextPath}/RPS" method="GET">
  <input type="text" name="DoneWithGame" style="display: none" value ="true"/>
  <input class="button" type="submit" value="Click to Finish This Game Session"/>
</form>
</body>
</html>
