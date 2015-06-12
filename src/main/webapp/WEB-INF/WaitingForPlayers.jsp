<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/MainStyle.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <title>Waiting For Players</title>
    <script>
        function ajax() {
            return $.ajax({
                url: '/checkGame/${model}',
                async: true,
                contentType: "html",
                success:function(data) {
                    console.log("got response: "+data);
                    if(data == 'success') {
                        console.log("yay we are ready to go");
                        location.reload(true);
                    }
                },
                complete:function() {
                    console.log("finished");
                    ajax();
                }
            });
        }
        document.onload = ajax();
    </script>
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
<h1 class="postHeader">Waiting For Players</h1>
<p>
  Heard you liked playing games, but we need other people so hold your horses.
  This page will autorefresh in a few seconds...
</p>
</body>
</html>
