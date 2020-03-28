<%--
  Created by IntelliJ IDEA.
  User: Luke
  Date: 2020/3/24
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" isErrorPage="true"%>
<html>
<head>
    <title>修改密码</title>
</head>
<body style="text-align: center">
<h2>学生管理系统</h2>
<h3>修改密码<h3>
<hr>
    <form action="${pageContext.request.contextPath}/student/operate/update" method="post">
        <input type="hidden"  name="_method" value="put">
        <table align="center">
            <tr>
                <td>用户名</td>
                <td>${user}</td>

            </tr>
            <tr>
                <td>原始密码</td>
                <td><input type="password" name="ori_pwd"></td>
            </tr>
            <tr>
                <td>新密码</td>
                <td><input type="password" name="new_pwd"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <input type="submit" value="修改">
                    <input type="reset" value="重置">&nbsp;
                    <a href="${pageContext.request.contextPath}/student/1">返回</a>
                </td>
            </tr>
        </table>


    </form>

${tages}

</body>
</html>
