<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/25
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #customers
        {
            font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
            width:100%;
            border-collapse:collapse;
        }

        #customers td, #customers th
        {
            font-size:1em;
            border:1px solid #98bf21;
            padding:3px 7px 2px 7px;
        }

        #customers th
        {
            font-size:1.1em;
            text-align:left;
            padding-top:5px;
            padding-bottom:4px;
            background-color:#A7C942;
            color:#ffffff;
        }

        #customers tr.alt td
        {
            color:#000000;
            background-color:#EAF2D3;
        }
    </style>

</head>
<body>
    <fieldset>


        <legend>所有新闻信息如下</legend>

        <a href="TestAction?method=delete">删除新闻请求</a>
        <a href="TestAction?method=update">更新新闻请求</a>
        <hr/>

        <table id="customers">
            <tr>
                <th>newsid</th>
                <th>title</th>
                <th>newsdate</th>
                <th>good</th>
                <th>typeid</th>
                <th>typename</th>
            </tr>
            <c:forEach items="${news}" var="n">
                <tr>
                    <td>${n.newsid}</td>
                    <td>${n.title}</td>
                    <td>${n.newsdate}</td>
                    <td>${n.good}</td>
                    <td>${n.typeid}</td>
                    <td>${n.typename}</td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</body>
</html>
