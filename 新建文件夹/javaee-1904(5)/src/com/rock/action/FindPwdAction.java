package com.rock.action;

import com.rock.serivce.IUserService;
import com.rock.serivce.serviceimpl.IUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/FindPwdAction")
public class FindPwdAction extends HttpServlet {
    private IUserService iUserService=null;
    public FindPwdAction(){
        iUserService=new IUserServiceImpl();
    }
    protected void findpwd1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid=request.getParameter("userid");
        String q=iUserService.queryQuestionById(userid);

        request.setAttribute("qtxt",q);
        request.getSession(true).setAttribute("userid",userid);
        request.getRequestDispatcher("/findpwd2.jsp").forward(request,response);
    }
    protected void findpwd2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answer=request.getParameter("answer");
        String userid=request.getSession(true).getAttribute("userid").toString();

        boolean result=iUserService.judgeUser(answer,userid);
        if(result){
            request.getRequestDispatcher("/findpwd3.jsp").forward(request,response);
        }
        else{
            request.setAttribute("error","密保答案输入有误");
            request.getRequestDispatcher("/findpwd2.jsp").forward(request,response);
        }

    }
    protected void findpwd3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //修改密码  新密码和userid
        String password=request.getParameter("pwd");
        String userid=request.getSession(true).getAttribute("userid").toString();
        int a=iUserService.doPwd(userid,password);
        if(a>0){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        else{

        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method=request.getParameter("method");

        if("findpwd1".equals(method))
            this.findpwd1(request,response);

        else if("findpwd2".equals(method))
            this.findpwd2(request,response);

        else if("findpwd3".equals(method))
            this.findpwd3(request,response);
        else{
            System.out.println("出错了");
        }

    }
}
