<%--
  Created by IntelliJ IDEA.
  User: Luke
  Date: 2020/3/23
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理系统</title>
</head>
<body style="text-align: center">
<h2>学生管理系统</h2>
<br>
登录用户:${user}<>
<form action="" method="post">
    <a href="${pageContext.request.contextPath}/student/alterpwd">密码修改</a>&nbsp;
    <a href="${pageContext.request.contextPath}/student/2">退出系统</a>
    <hr>
<%--    <a href="${pageContext.request.contextPath}/student/insert">新增学生信息</a>--%>
    <a href="${pageContext.request.contextPath}/student/insert">新增学生信息</a>
    <a href="${pageContext.request.contextPath}/student/query">查询学生信息</a>
    <hr>
</form>
</body>
<script type="text/javascript">
    function insert() {

    }
</script>
</html>
