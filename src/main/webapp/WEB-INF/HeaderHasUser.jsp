<ul id="navbar">
        <li class="header, home-link"><a href="${pageContext.request.contextPath}/">DABAT</a></li>
        <li class="header"><a href="${pageContext.request.contextPath}/bob">Log Out</a></li>
        <li class="header"><a href="${pageContext.request.contextPath}/games">Games</a></li>
        <li class="header"><a href="${pageContext.request.contextPath}/accountInformation/<%= session.getAttribute("userID") %>">Hello <%= session.getAttribute("username") %></a></li>
</ul>
