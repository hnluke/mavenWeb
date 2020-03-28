<%--
  Created by IntelliJ IDEA.
  User: Luke
  Date: 2020/3/24
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>学生信息查询</title>
</head>
<body>
<h2 align="center">学生管理系统</h2>
<br>
<h3 align="center">学生信息查询</h3>
<br>
<form action="${pageContext.request.contextPath}/student/operate" method="GET">
查询条件:
<select name="conditions">
    <option value="">--请选择--</option>
    <option value="s_no">学号</option>
    <option value="s_name">学生姓名</option>
    <option value="s_major">专业</option>
    <option value="s_status">在读状态</option>
    <option value="s_regtime">注册日期</option>
    </select>&nbsp;&nbsp;
    内容：<input type="text" name="contexts" />&nbsp;
    <input type="submit" name="" value="查询">&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/student/1">返回</a>
</form>
<hr>
<table border="1" width="80%" style="text-align: center">
<c:if test="${!empty(query_list)}">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>专业</th>
        <th>在读状态</th>
        <th>注册时间</th>

    </tr>
    <c:forEach var="stu" items="${query_list}">
        <tr>
            <td>${stu.s_no}</td>
            <td>${stu.s_name}</td>
            <td>${stu.s_major}</td>
            <td>${stu.s_status}</td>
            <td>${stu.s_regtime}</td>
        </tr>
    </c:forEach>
</c:if>
</table>
</body>
</html>
