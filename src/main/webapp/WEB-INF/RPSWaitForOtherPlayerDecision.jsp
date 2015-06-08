
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Waiting ... Waiting ... Waiting</title>
    <script>
        function refreshPage()
        {
            $this = $(this);
            $.ajax({
                url: 'RPS_ajaxReloader',
                datatype: 'html',
                async:true,
                success: function(data){
                    if(data=='true') {
                        location.reload(true);
                    }
                    else {
                        refreshPage();
                    }
                }
            });
        }
        body.onload = refreshPage();
    </script>
</head>
<body>
<jsp:include page="header.jsp" />

<p> Waiting for other player</p>
</body>
</html>
