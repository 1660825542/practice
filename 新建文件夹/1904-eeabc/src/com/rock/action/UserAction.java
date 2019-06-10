package com.rock.action;

import com.rock.entities.User;
import com.rock.service.IUserService;
import com.rock.service.impl.IUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UserAction")
public class UserAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid=request.getParameter("userid");
        String password=request.getParameter("password");
        User user=new User();
        user.setUserid(userid);
        user.setPassword(password);
        IUserService ius=new IUserServiceImpl();
        boolean f=ius.reuser(user);
        if (f)
        {
            HttpSession session=request.getSession(true);
            session .setAttribute("userid",user.getUserid());
            // request.setAttribute("user",user.getUserid());
            request.getRequestDispatcher("main.jsp").forward(request,response);
        }

        else
        {
            request.setAttribute("info","用户名密码错误");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
