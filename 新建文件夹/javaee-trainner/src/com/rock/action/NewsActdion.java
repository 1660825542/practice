package com.rock.action;

import com.rock.entities.News;
import com.rock.service.INewsService;
import com.rock.service.serviceimpl.INewsServiceImpl;
import com.sun.deploy.nativesandbox.comm.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/showNews")
public class NewsActdion extends HttpServlet {
    private INewsService iNewsService=null;
    public NewsActdion(){
        iNewsService=new INewsServiceImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> all=iNewsService.all();
        request.setAttribute("news",all);
        //request.getRequestDispatcher("/all.jsp").forward(request,response);
        request.getRequestDispatcher("/EmployeeAction?method=emps").forward(request,response);
    }
}
