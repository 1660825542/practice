<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/21
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="comm/jquery-2.1.4.js"></script>
    <script>
        $(document).ready(function () {
            $("#b1").click(function () {
                var password=$("#password").val()
                var newpwd=$("#newpwd").val()

                location.href='UpPwdAction?password='+password+"&newpwd="+newpwd;

            })
        })
    </script>
</head>
<body>
<fieldset>
    <legend>修改密码</legend>
    <div>
        请输入原密码：<input type="password" name="password" id="password"> ${error}
    </div>
    <div>
        请输入新密码：<input type="password" name="newpwd" id="newpwd">
    </div>
    <div>
        <button id="b1" >确认修改</button>
    </div>
</fieldset>
</body>
</html>
