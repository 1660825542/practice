package com.rock.action;

import com.rock.entities.User;
import com.rock.service.IRegisterService;
import com.rock.service.impl.IRegisterServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterAction")
public class RegisterAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");
        String sex = request.getParameter("sex");
        String []hobby1 = request.getParameterValues("hobby");
        String hobby="";
        for (String s:hobby1)
        {
            hobby=hobby+s+"&";
        }
        System.out.println(hobby);
        String degree = request.getParameter("degree");
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");
        User user=new User(userid,password,mail,sex,hobby,degree,question,answer);
        IRegisterService irs=new IRegisterServiceimpl();
        if (irs.register(user))
        {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else
            request.getRequestDispatcher("regist.jsp").forward(request,response);
    }
}