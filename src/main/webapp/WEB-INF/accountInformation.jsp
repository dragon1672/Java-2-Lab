<%--
  Created by IntelliJ IDEA.
  User: awayman
  Date: 5/20/2015
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
  This page just takes a UserModel, nothing else
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Account Information</title>
</head>
<body>
<jsp:include page="header.jsp" />
  <div>
    Account name: ${model.displayName}
  </div>
  <div>
    First name: ${model.firstName}
  </div>
  <div>
    Last name: ${model.lastName}
  </div>
  <div>
    Email: ${model.email}
  </div>
  <div>
    User ID: ${model.ID}
  </div>
  <div>
    User Avatar URL: ${model.avatarURL}
  </div>
  <div>
    <img src="${model.avatarURL}"/>
  </div>
</body>
</html>
