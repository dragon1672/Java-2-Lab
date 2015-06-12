<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>RPS Results</title>
    <link href="${pageContext.request.contextPath}/resources/MainStyle.css" rel="stylesheet">
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

<div class="content"/>
<div class="innerImage"></div>
<div class="innerContent"/>
<h2 class="postHeader, rpsHeader">Rock Paper Scissors</h2>
<div class="postContent">
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
    <h3 class="rpsResult">You ${model.wonOrLost}</h3>
</p>

<form method="GET">
  <input class="otherButton" type="submit" value="Click to Play Another Game"/>
</form>
<br>
<form method="GET">
  <input type="text" name="DoneWithGame" style="display: none" value ="true"/>
  <input class="otherButton" type="submit" value="Click to Finish This Game Session"/>
</form>
</div>
</body>
</html>
