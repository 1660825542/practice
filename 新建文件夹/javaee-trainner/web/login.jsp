<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/20
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<fieldset>
    <legend>欢迎登录</legend>
    <form action="UserAction">
        <input type="hidden" name="method" value="login">
        <div>
            登录ＩＤ：<input type="text" name="userid"/>
            ${error}
        </div>
        <div>
            登录密码：<input type="password" name="password"/>
        </div>
        <div>
            <input type="submit" value="【登录】"/>
            <input type="reset" value="【重置】"/>
            <input type="button" value="【没有账号】" onclick="location.href='register.jsp';">
            <a href="UserAction?method=findQuestion">没有账号</a>
            <a href="findpwd1.jsp">忘记密码</a>
        </div>
    </form>
</fieldset>

</body>
</html>