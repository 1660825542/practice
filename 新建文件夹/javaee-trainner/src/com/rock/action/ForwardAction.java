package com.rock.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/ForwardAction")
public class ForwardAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user","老张");
        //转发方式的响应
        //request.getRequestDispatcher("/b.jsp").forward(request,response);
        //以重定向方式响应的
        //response.sendRedirect("b.jsp");
        response.getWriter().write("<div style='color:red';>Hello World</div>");
    }
}
