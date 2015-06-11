<span class="header"><a href="${pageContext.request.contextPath}/">Home Page</a></span>
<span class="header"> --- </span>
<span class="header"><a href="${pageContext.request.contextPath}/games">Games</a></span>
<span class="header"> --- </span>
<span class="header"><a href="${pageContext.request.contextPath}/accountInformation/<%= session.getAttribute("userID") %>">Hello <%= session.getAttribute("username") %></a></span>
<span class="header"> --- </span>
<span class="header"><a href="${pageContext.request.contextPath}/bob">Log Out</a></span>
