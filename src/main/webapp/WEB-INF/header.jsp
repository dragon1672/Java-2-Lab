<span class="header"><a href="${pageContext.request.contextPath}/">Home Page</a></span>
<span class="header"> --- </span>
<span class="header"><a href="${pageContext.request.contextPath}/">Game Select</a></span>
<span class="header"> --- </span>
<span class="header"><a href="${pageContext.request.contextPath}/login">Log In</a></span>
<span class="header"> --- </span>
<span class="header"><a href="${pageContext.request.contextPath}/logout">Log Out</a></span>
<span class="header"> --- </span>
<span class="header"><a href="${pageContext.request.contextPath}/accountCreation">Create Account</a></span>
<span class="header"> --- </span>
<span class="header"><a href="${pageContext.request.contextPath}/games">Games</a></span>
<span class="header"> --- </span>
<span class="header"><a href="${pageContext.request.contextPath}/accountInformation/<%= session.getAttribute("userID") %>">Hello <%= session.getAttribute("username") %></a></span>

