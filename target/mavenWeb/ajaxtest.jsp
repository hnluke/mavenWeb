<%--
  Created by IntelliJ IDEA.
  User: Luke
  Date: 2020/3/25
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json</title>
    <script src = "js/jquery-3.4.1.js">

    </script>

    <script type="text/javascript">
        $(function () {
            $("#jsonid").click(function () {
                var url="jsondata";
                var contexts = {"user":"Luke", "userId":"100"};
                var cons = "";
                $.ajax({
                    type:"post",
                    url:url,
                    dataType:"json",
                    contentType:"application/json;charset=utf-8",
                    data:JSON.stringify(contexts),
                    success:function (callback) {

                        for(var i=0; i<callback.length; i++) {
                            cons = cons + callback[i].u_id + "     ";
                            cons = cons + callback[i].u_name + "    ";
                            cons = cons + "<br/>";
                        }
                        $("#area").html(cons);

                    }
                });
            })
        })
    </script>
</head>
<body>
    <button name="" id="jsonid"   onclick="">提交</button>
    <div id="area"></div>

</body>
</html>
