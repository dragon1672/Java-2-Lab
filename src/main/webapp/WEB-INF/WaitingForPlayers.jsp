<%--
  Created by IntelliJ IDEA.
  User: awayman
  Date: 5/21/2015
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <title>Waiting For Players</title>
    <script>
        function ajax() {
            return $.ajax({
                url: '/checkGame/${model}',
                async: false,
                type: 'GET',
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
                },
            });
        }
    </script>
</head>
<body>
  <h1>Waiting For Players</h1>
  Heard you liked playing games, but we need other people so hold your horses.
  This page will autorefresh in a few seconds... Sorry Anthony :P
  <% response.setIntHeader("Refresh", 8);%>
</body>
</html>
