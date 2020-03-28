<%--
  Created by IntelliJ IDEA.
  User: Luke
  Date: 2020/3/26
  Time: 7:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传下载</title>
</head>
<body>
    <form action="fileUpload/1" method="post" enctype="multipart/form-data">
        File:<input type="file" name="file" />
        other:<input type="text" name="other" />
        <input type="submit" value="提交" />
    </form>

    <a href="download?fileName=1.txt">下载</a>
</body>
</html>
