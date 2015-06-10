<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Waiting ... Waiting ... Waiting</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script>
        var savedData;
        function refreshPage() {
            var pathArray = window.location.pathname.split( '/' );
            $this = $(this);
            $.ajax({
                url: pathArray[2]+'/RPS_ajaxReloader',
                datatype: 'html',
                async:true,
                success: function(data){
                    savedData = data;
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
<jsp:include page="header.jsp" />

<p> Waiting for other player</p>
</body>
</html>
