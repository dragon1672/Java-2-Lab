
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Waiting ... Waiting ... Waiting</title>
</head>
<body>
<jsp:include page="header.jsp" />

<p> Click the button below to check if the other player has made their choice</p>
<form action="${pageContext.request.contextPath}/RPS" method="GET">
  <input type="submit" value="Check For Other Player"/>
</form>
</body>
</html>
