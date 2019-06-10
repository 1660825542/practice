package com.rock.action;

import com.rock.entities.Employee;
import com.rock.service.IEmployeeService;
import com.rock.service.serviceimpl.IEmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/EmployeeAction")
public class EmployeeAction extends HttpServlet {
    IEmployeeService iEmployeeService=null;
    public EmployeeAction(){
        iEmployeeService=new IEmployeeServiceImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mehtod=request.getParameter("method");
        if("deleteById".equals(mehtod)){
            this.deleteById(request,response);
        }
        else if("getEmployeeByID4Update".equals(mehtod))
            this.getEmployeeByID4Update(request,response);
        else if("doUpdate".equals(mehtod))
            this.doUpdate(request,response);

        else if("emps".equals(mehtod)){
            List<Employee> all=iEmployeeService.allEmployees();
            //向请求域中添加了一个属性emps，而值确是一个List集合
            request.setAttribute("emps",all);
            request.setAttribute("userid","rock");
            Employee em=new Employee();
            em.setEname("刘德华");
            request.setAttribute("e",em);

            request.getRequestDispatcher("/main.jsp").forward(request,response);
        }
    }
    protected void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empno=request.getParameter("empno");
        iEmployeeService.deleteById(empno);

        request.getRequestDispatcher("/EmployeeAction?method=emps").forward(request,response);
    }
    protected void getEmployeeByID4Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取了被更新的数据的no号
        //要根据这个编号获取员工的详细信息,为了数据在页面上的回显
        String empno=request.getParameter("empno");
        Employee e=iEmployeeService.queryById(empno);

        List<Employee> mgrs=iEmployeeService.queryAllManagers();
        request.setAttribute("e",e);
        request.setAttribute("mgrs",mgrs);


        request.getRequestDispatcher("/update1.jsp").forward(request,response);

    }
    protected void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empno=request.getParameter("empno");
        String ename=request.getParameter("ename");
        String sal=request.getParameter("sal");
        String comm=request.getParameter("comm");
        String mgr=request.getParameter("mgr");
        System.out.println(mgr+"=======");
        Employee emp=new Employee(empno,ename,sal,comm,mgr);
        int a=iEmployeeService.doUpdate(emp);
        if(a>0)
            request.getRequestDispatcher("/EmployeeAction?method=emps").forward(request,response);
    }
}
