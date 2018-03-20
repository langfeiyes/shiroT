<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span>${errorMsg}</span>
<form action="/login" method="POST">
    用户名:<input type="text" name="username"><br>
    密&nbsp;&nbsp;&nbsp;码:<input type="text" name="password"><br>
    <input type="radio" name="userType" value="admin"> 管理员
    <input type="radio" name="userType" value="operator"> 操作员
    <input type="radio" name="userType" value="user"> 用户 <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
