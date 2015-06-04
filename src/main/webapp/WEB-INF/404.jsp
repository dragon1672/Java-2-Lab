<%@ page import="edu.neumont.projectFiles.services.Singletons" %>
<%@ page import="utils.HtmlStringHelper" %>
<%@ page import="edu.neumont.projectFiles.RandomSwfURL" %>
<%--
  Created by IntelliJ IDEA.
  User: Anthony
  Date: 4/27/2015
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <style type="text/css">

    body {
      background-color: #fff;
      margin: 20px;
      font-family: Lucida Grande, Verdana, Sans-serif, serif;
      font-size: 12px;
      color: #000;
    }
    td {
      text-align: center;
    }
    .centered {
      margin-left: auto;
      margin-right: auto;
    }
    #content  {
      border: #999 1px solid;
      background-color: #fff;
      padding: 15px 15px 12px 15px;
    }

    h1 {
      font-weight: bold;
      font-size: 23px;
      color: #990000;
      margin: 0 0 0 0;
    }
  </style>
</head>
<body>
<%
    //Shhhhhhhhhhhhhh
    String url = Singletons.theDAL.getRandomSWFURL();
    if(url == null)
        url = RandomSwfURL.getRandomSwlUrl();
    if(!url.startsWith("http://")) url = "http://" + url;
    String prettyName = HtmlStringHelper.PrettyUpUrlToFile(url);
%>
<div id="content">
  <div style="text-align: center;">
    <h1>404 Page Not Found</h1>
    The page you requested was not found. So enjoy the randomness of <a href="<%=url%>"><%=prettyName%></a>
    <br/>
  </div>
  <br/>
  <table id="table" align="center">
    <tr>
      <td>
        <object type="application/x-shockwave-flash" data="<%=url%>" width="640" height="480" class="centered" id="object_404">
          <param name="allowScriptAccess" value="sameDomain" />
          <param name="movie" value="/swf/<?php echo $file; ?>" />
          <param name="menu" value="false" />
          <param name="quality" value="high" />
          <embed src="<%=url%>" menu="false" quality="high" width="640" height="480" id="embed_404" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" ></embed>
        </object>
        <br/>

        <h1><a href="#" onClick="window.location.reload();return false;">ANOTHER!</a></h1>

        All audio and video content belongs to the original author(s) and/or copyright holders unless otherwise stated. I take no ownership of these videos.<br/>
        Viewing this website if you're photosensitive/epileptic probably isn't a good idea. You have been warned.

        <form action="${pageContext.request.contextPath}/removeSWF" onsubmit="return confirm('This will delete this file an NO ONE, will ever see it again. Are you sure you want to do this?');">
          <input type="hidden" name="URLtoRemove" value="<%=url%>" />
          <input type="submit" value="Remove SWF From Database" />
        </form>

      </td>
    </tr>
  </table>
</div>
</body>
</html>
