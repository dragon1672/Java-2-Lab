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
    ${model.p1} played ${model.p1Choice}
<br/>
    ${model.p2} played ${model.p2Choice}
<br/>
        <img width=100 height=100 src="${model.winChoicePicPath} ">
      V.S.
        <img width=100 height=100 src="${model.loseChoicePicPath} ">
<br/>
${model.winChoice} ${model.beatStatement} ${model.loseChoice}
<br/>
    <h3>You ${model.wonOrLost}</h3>
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