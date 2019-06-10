<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/22
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="comm/css/main.css"/>
    <script type="text/javascript" src="comm/jquery-2.1.4.js"></script>
    <script type="text/javascript">
        function deleteById(empno){
            var result=confirm("确定要删除【"+empno+"】的信息吗？");
            if(result){
                location.href="EmployeeAction?method=deleteById&empno="+empno;
            }
        }
        function myEnter(obj) {
            obj.style.backgroundColor="yellow";
            obj.style.color="red";
        }
        

    </script>
    <script type="text/javascript">
       $(document).ready(function () {
           $('button').on('click',function(){
               location.href='ActionEmp?method=getEmployeeById&empno='+$(this).attr('eid');
           });
       });
    </script>
</head>
<body>
<fieldset>
    <legend>您好【${user.userid}】，员工信息如下：</legend>
    <table id="customers">

        <tr>
            <th colspan="9">
               <input type="checkbox">  <a>批量删除</a>
                <select>
                    <option>销售部</option>
                    <option>研发部</option>
                </select>
                <input type="text" name="">
                <button>检索数据</button>
            </th>

        </tr>

        <tr>
            <th>
                员工编号
            </th>
            <th>员工姓名</th>
            <th>工作岗位</th>
            <th>领导姓名</th>
            <th>入职日期</th>
            <th>基本工资</th>
            <th>月度奖金</th>
            <th>所在部门</th>
            <th>单行操作</th>
        </tr>
        <c:forEach items="${emps}" var="emp">
            <tr>
                <td>
                        <input type="checkbox" >
                        ${emp.empno}</td>
                <td>${emp.ename}</td>
                <td>${emp.job}</td>
                <td>${emp.mgr}</td>
                <td>${emp.hiredate}</td>
                <td>${emp.sal}</td>
                <td>${emp.comm}</td>
                <td>${emp.dname}</td>
                <td>
                    <a onmouseenter="myEnter(this);" onclick="deleteById(${emp.empno});" style="cursor:pointer;">【删除】</a>
                   <%-- <button id="">【更新】</button>--%>
                    <%--<a href="EmployeeAction?method=getEmployeeByID4Update&empno=${emp.empno}">【更新】</a>--%>
                    <button eid=" ${emp.empno}">【更新】</button>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="9">
               共有【14】条数据,每页显示5条，但前显示【1/4】页
                <a href="">【首页】</a>
                <a href="">【上一页】</a>
                <a href="">【下一页】</a>
                <a href="">【尾页】</a>
            </td>

        </tr>
    </table>
</fieldset>
</body>
</html>
