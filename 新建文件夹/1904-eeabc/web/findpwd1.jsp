<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/21
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>找回密码-步骤1</legend>
    <form action="FindPwdAction">
        <input type="hidden" name="method" value="fp1">
        <div>
            找回的用户ID：<input type="text" name="userid" >${error}
        </div>
        <div>
            <input type="submit" value="下一步">
        </div>
    </form>
</fieldset>
</body>
</html>
