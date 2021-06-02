<%--
  Created by IntelliJ IDEA.
  User: Timber
  Date: 2020/12/11
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆失败</title>
</head>
<body>

<h1>用户名<%out.print(request.getParameter("username"));%>与密码不匹配，请重新登录</h1>
<a href="<%=request.getContextPath()%>/index.jsp"><h2>重新登录</h2></a>

</body>
</html>
