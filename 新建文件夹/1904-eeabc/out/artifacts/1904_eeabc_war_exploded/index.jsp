<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/20
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
      <script type="text/javascript">

      </script>
  </head>
  <body>
  <fieldset>
    <legend>欢迎登陆</legend>
    <form action="UserAction" method="get">
        <div>
            登陆ID：<input type="text" name="userid">  ${info}
        </div>
      <div>
        登陆密码<input type="password" name="password"><a href="findpwd1.jsp">找回密码</a>
      </div>
      <div>
         <input type="submit" value="登陆">
          <a href="register.jsp"><input id="reg" type="button" value="注册"></a>
      </div>
    </form>
  </fieldset>
  </body>
</html>
