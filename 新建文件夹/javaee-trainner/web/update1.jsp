<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/25
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <fieldset>
        <legend>更新【${e.ename}】数据</legend>
        <form action="EmployeeAction">
            <input type="hidden" name="method" value="doUpdate">
            <table>

                <tr>
                    <td>员工编号：</td>
                    <td><input type="text" name="empno" value="${e.empno}"> </td>
                </tr>

                <tr>
                    <td>员工姓名：</td>
                    <td><input type="text" name="ename" value="${e.ename}"> </td>
                </tr>

                <tr>
                    <td>员工工资：</td>
                    <td><input type="text" name="sal" value="${e.sal}"> </td>
                </tr>

                <tr>
                    <td>月度奖金：</td>
                    <td><input type="text" name="comm" value="${e.comm}"> </td>
                </tr>
                <tr>
                    <td>直接领导：</td>
                    <td>
                        <select name="mgr">
                            <c:forEach items="${mgrs}" var="m">
                                <c:if test="${m.mgr eq e.mgr}">
                                    <option value="${m.mgr}" selected="selected">${m.ename}</option>
                                </c:if>
                                <c:if test="${m.mgr ne e.mgr}">
                                    <option value="${m.mgr}">${m.ename}</option>
                                </c:if>

                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>所在部门：</td>
                    <td>
                        <%--<select>--%>
                            <%--<option>开发部</option>--%>
                            <%--<option>财务部</option>--%>
                            <%--<option>营销部</option>--%>
                            <%--<option>销售部</option>--%>
                        <%--</select>--%>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="【更新】">
                        ${e.deptno}-${e.mgr}
                    </td>
                </tr>
            </table>
        </form>

    </fieldset>
</body>
</html>
