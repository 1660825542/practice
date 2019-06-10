<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/20
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>注册</legend>
    <form action="RegisterAction" method="get">
        <div>
            用户ID：<input type="text" name="userid">
        </div>
        <div>
            登陆密码：<input type="password" name="password">
        </div>
        <div>
            e-mail:<input type="text" name="mail">
        </div>
        <div>
            性别：
            <input type="radio" name="sex" value="男" checked="checked">男
            <input type="radio" name="sex" value="女" >女
        </div>
        <div>
            爱好：
            <input type="checkbox" name="hobby" value="体育">体育
            <input type="checkbox" name="hobby" value="影视">影视
            <input type="checkbox" name="hobby" value="科技">科技
            <input type="checkbox" name="hobby" value="饮食">饮食
        </div>

        <div>
            学位：<select name="degree">
                <option>博士</option>
                <option>硕士</option>
                <option selected="selected">学士</option>
            </select>
        </div>


        <div>
            <fieldset>
                <legend>密保信息</legend>
                密保问题：<input type="text" name="question"> <br>
                密保答案：<input type="text" name="answer">
            </fieldset>
        </div>

        <div>
            <input type="submit" value="注册">
            <input type="reset" value="重置">
        </div>
    </form>
</fieldset>
</body>
</html>
