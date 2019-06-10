<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/21
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>找回密码-步骤3</legend>
    <form action="FindPwdAction">
        <input type="hidden" name="method" value="findpwd3">
        <div>小子哎，别再忘记密码了，请在如下文本框中输入新的密码</div>
        <div>
            <input type="text" name="pwd"/>
        </div>
        <div>
            <input type="submit" value="【确认】"/>
        </div>
    </form>
</fieldset>
</body>
</html>
