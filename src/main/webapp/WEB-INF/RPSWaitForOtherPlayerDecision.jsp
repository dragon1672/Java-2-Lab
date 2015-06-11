<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> Waiting ... Waiting ... Waiting</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script>
        function refreshPage() {
            $this = $(this);
            $.ajax({
                url: window.location.pathname+'/RPS_ajaxReloader',
                datatype: 'html',
                async:true,
                success: function(data){
                    if(data=='true') {
                        window.location.href = window.location.pathname;
                    }
                    else {
                        refreshPage();
                    }
                }
            });
        }
        document.onload = refreshPage();
    </script>
</head>
<body>
<c:if test="${empty sessionScope.username}">
    <jsp:include page="HeaderNoUser.jsp" />
</c:if>
<c:if test="${not empty sessionScope.username}">
    <jsp:include page="HeaderHasUser.jsp" />
</c:if>

<p> Waiting for other player</p>
</body>
</html>
