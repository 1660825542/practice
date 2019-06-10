package com.rock.action;

import com.rock.service.IUpPwdService;
import com.rock.service.impl.IUpPwdServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UpPwdAction")
public class UpPwdAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String password=request.getParameter("password");
        String newpwd=request.getParameter("newpwd");
        IUpPwdService iups=new IUpPwdServiceimpl();
        HttpSession session=request.getSession(true);
        String userid= session.getAttribute("userid").toString();
        boolean flag=iups.uppwd(userid,password,newpwd);
        if (flag)
        {

            request.getRequestDispatcher("index.jsp").forward(request,response);

        }
        else {
            request.setAttribute("error","原密码错误");
            request.getRequestDispatcher("up_pwd.jsp").forward(request, response);
        }
    }
}
