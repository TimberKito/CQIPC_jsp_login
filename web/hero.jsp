<%--
  Created by IntelliJ IDEA.
  User: Timber
  Date: 2020/12/11
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择结果页面</title>
</head>
<body>

欢迎您：<br>
<font color="red" size="22">
    <%
        out.print((String)request.getAttribute("loginname"));
    %>
</font>

发现了混入革命队伍的败类：<br>

<%
    for (String s : (String [])request.getAttribute("s")) {
        out.print(s + "<br>");
    }
%>

</body>
</html>
