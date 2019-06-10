<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/21
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>                                   9

<fieldset>
    <legend>找回密码-步骤3</legend>
    <form action="FindPwdAction">
        <input type="hidden" name="method" value="fp3">
        <div>
            新密码：<input type="password" name="password" >${error}
        </div>
        <div>
            <input type="submit" value="完成">
        </div>
    </form>
</fieldset>
</body>
</html>
