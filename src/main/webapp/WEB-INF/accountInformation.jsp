<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <style>
    .userAvatar {
      max-width: 500px;
      max-height: 500px;
      width: auto;
    }
  </style>
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
    <img class="userAvatar" src="${model.avatarURL}"/>
  </div>
</body>
</html>
