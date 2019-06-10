package com.rock.action;

import com.rock.service.IUserService;
import com.rock.service.impl.IUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/FindPwdAction")
public class FindPwdAction extends HttpServlet {
    IUserService ius=new IUserServiceImpl();
    protected void find1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         boolean flag=ius.finduserid(request.getParameter("userid"));
         if (flag)
         {
             HttpSession session=request.getSession(true);
             session.setAttribute("userid",request.getParameter("userid"));
             String userid=request.getParameter("userid");
             String []findqa=ius.findqa(userid);
             session.setAttribute("question",findqa[0]);
             session.setAttribute("answer1",findqa[1]);
            // System.out.println(findqa[1]);
             request.getRequestDispatcher("findpwd2.jsp").forward(request,response);
         }
         else
         {
             request.setAttribute("error","用户不存在");
             request.getRequestDispatcher("findpwd1.jsp").forward(request,response);
         }
    }
    protected void find2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session=request.getSession(true);
            String answer1=session.getAttribute("answer1").toString();
             String answer=request.getParameter("answer");
             if (answer.equals(answer1))
             {
                 request.getRequestDispatcher("findpwd3.jsp").forward(request,response);
             }
             else
             {
                 request.setAttribute("error","密保答案错误");
                 request.setAttribute("question",session.getAttribute("question").toString());
                 request.getRequestDispatcher("findpwd2.jsp").forward(request,response);
             }

    }
    protected void find3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(true);
        String userid=session.getAttribute("userid").toString();
        String psssword=request.getParameter("password");
        System.out.println(userid+"=="+psssword);
        boolean flag=ius.revisionpwd(userid,psssword);
        if (flag)
        {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else {
            request.setAttribute("error","修改失败");
            request.getRequestDispatcher("findpwd3.jsp").forward(request,response);
        }
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String find=request.getParameter("method");
        if (find.equals("fp1"))
        {
            this.find1(request,response);
        }
        else if (find.equals("fp2"))
        {
            this.find2(request,response);

        }
        else if (find.equals("fp3"))
        {
            this.find3(request,response);
        }
        else {
            System.out.println("出现错误");
        }
    }

}
