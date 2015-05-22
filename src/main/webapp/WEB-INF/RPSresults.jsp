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
<p>Hello <%= session.getAttribute("username") %> You played: ${model}</p>
</body>
</html>
