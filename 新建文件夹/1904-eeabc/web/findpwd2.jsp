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
<body>

<fieldset>
    <legend>找回密码-步骤2</legend>
    <form action="FindPwdAction">
        <input type="hidden" name="method" value="fp2">
        <div>
            密保问题：${question}
        </div>
        <div>
            密保答案：<input type="text" name="answer" >${error}
        </div>
        <div>
            <input type="submit" value="下一步">
        </div>
    </form>
</fieldset>
</body>
</html>
