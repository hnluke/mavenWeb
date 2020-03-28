<%--
  Created by IntelliJ IDEA.
  User: Luke
  Date: 2020/3/23
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body style="text-align: center">
<h2>学生管理系统</h2>
<h3>用户登录</h3>
<form action="${pageContext.request.contextPath}/student" method="post">
    用户名:<input type="text" name="u_name" /><br/>
    密&nbsp;&nbsp;码:<input type="password" name="u_pwd" /><br>
    <input type="submit" name="" id="sub" value="登录">
    <input type="reset" name="" value="重置">
</form>

</body>
</html>
