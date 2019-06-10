package com.rock.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/TestAction")
public class TestAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String m=request.getParameter("method");
        if("delete".equals(m))
            this.delete(request,response);
        else if("update".equals(m))
            this.update(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("delete");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("update");

    }
}
