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

@WebServlet(value = "/ActionEmp")
public class ActionEmp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method=request.getParameter("method");
        if("getEmployeeById".equals(method))
            this.getEmployeeById(request,response);
    }

    protected void getEmployeeById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empno=request.getParameter("empno");
        IEmployeeService iEmployeeService=new IEmployeeServiceImpl();
        Employee e=iEmployeeService.queryById(empno);


        request.setAttribute("emp",e);

        List<Employee> mgrs=iEmployeeService.queryAllManagers();
        System.out.println(mgrs.size()+"==========");
        request.setAttribute("mgrs",mgrs);

        request.getRequestDispatcher("/u1.jsp").forward(request,response);

    }
}
