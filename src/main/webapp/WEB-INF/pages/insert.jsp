<%--
  Created by IntelliJ IDEA.
  User: Luke
  Date: 2020/3/24
  Time: 8:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<html>
<head>
    <title>新增学生信息</title>
    <style>
        td {
            text-align: center;
        }
    </style>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js">

    </script>
</head>
<body style="text-align: center">
<h2>学生管理系统</h2>
<br>
<h3>新生注册</h3>
<hr>
<div style="text-align: center">
<form action="" name="mainForm" id="mainForm" method="post" enctype="multipart/form-data">
   <input type="hidden" name="_method" value="POST" />
    <table cellspacing="1" border="1" align="center">
        <tr>
            <td>学号</td>
            <td><input type="text" name="s_no" id="s_no" oninput="clears();"/></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="s_name" id="s_name" onblur="verifyMultiName();"
                       oninput="changed();"  style="width: 100px "/><span id="showtxt"></span></td>

        </tr>
        <tr>
            <td>专业</td>
            <td>
                <select name="s_major">
                    <option value="0">--请选择--</option>
                    <option value="计算机">计算机</option>
                    <option value="机械工程">机械工程</option>
                    <option value="机电一体化">机电一体化</option>
                    <option value="数学">数学</option>
                    <option value="金融学">金融学</option>
                </select>
            </td>

        </tr>
        <tr>
            <td>学生状态</td>
            <td>
                <select name="s_status">
                    <option value="0">--请选择--</option>
                    <option value="在读">在读</option>
                    <option value="毕业">毕业</option>
                </select>
            </td>

        </tr>
        <tr>
            <td>注册日期</td>
            <td><input type="text" name="s_regtime" /></td>

        </tr>
        <tr>
            <td colspan="2">

                    File:&nbsp;&nbsp;<input type="file" name="file" />


            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" name="" value="新增" onclick="insert();"/>&nbsp;&nbsp;
                <input type="reset" name="" value="重置">&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/student/1">返回</a>
            </td>
        </tr>

    </table>




</form>
</div>
<p id="show">${tages}</p>

</body>
<script type="text/javascript">
    function insert() {
        var url = "${pageContext.request.contextPath}/student/operate/" + $("#s_no").val();
        // JQuery改变表单action，并提交表单
        $("#mainForm").attr('action',url);
        $("#mainForm").submit();
    }
    
    function verifyMultiName() {
        var url = "${pageContext.request.contextPath}/json/jsondata";
        var contexts = {"u_name": $("#s_name").val()};
        var cons = "";
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(contexts),
            success: function (callback) {
                $("#showtxt").text(callback);
            }
        });
    }

    function changed() {

        $("#showtxt").text("");

    }
</script>

</html>
