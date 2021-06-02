<%--
  Created by IntelliJ IDEA.
  User: Timber
  Date: 2020/12/11
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" >
    <title>登录页面</title>
  </head>
  <body>

  <form action="/JAVAWEB/loginServlet" method="post">
    <label>
      <input type="text" placeholder="请输入用户名" name="username">
    </label><br>
    <label>
      <input type="password" placeholder="请输入密码" name="password">
    </label><br>
    <input type="submit" value="登录">
    <br>
  </form>

  </body>
</html>
