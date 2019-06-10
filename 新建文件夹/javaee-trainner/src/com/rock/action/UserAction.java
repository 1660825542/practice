package com.rock.action;

import com.rock.entities.Question;
import com.rock.entities.Userinfo;
import com.rock.service.IQuestionService;
import com.rock.service.IUserService;
import com.rock.service.serviceimpl.IQuestionServiceImpl;
import com.rock.service.serviceimpl.IUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value= "/UserAction")
public class UserAction extends HttpServlet {
    private IUserService iUserService=null;
    public UserAction(){
        iUserService= new IUserServiceImpl();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method=request.getParameter("method");
        if("login".equals(method))
            this.login(request,response);
        if("findQuestion".equals(method))
            this.findQuestion(request,response);
        if("register".equals(method))
            this.register(request,response);
    }
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid=request.getParameter("userid");
        String password=request.getParameter("password");
        Userinfo user=iUserService.login(userid,password);
        if(user!=null){
            //合法用户
            //将用户的实体类存于回话域中
            request.getSession(true).setAttribute("user",user);
            //request.getRequestDispatcher("/main.jsp").forward(request,response);
            request.getRequestDispatcher("/EmployeeAction?method=emps").forward(request,response);
        }
        else{
            //非法用户
            request.setAttribute("error","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
    protected void findQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有的密保问题
        IQuestionService iQuestionService=new IQuestionServiceImpl();
        //获取了所有的密保问题
        List<Question> all=iQuestionService.allQuestions();
        request.setAttribute("questions",all);
        request.getRequestDispatcher("/register.jsp").forward(request,response);
    }
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid=request.getParameter("userid");
        String password=request.getParameter("password");
        String sex=request.getParameter("sex");
        //注意：复选框的值得获取不能使用.getPrameter();
        //String hobby=request.getParameter("hobby");
        String [] hobbys=request.getParameterValues("hobby");
        String hobby="";
        for(String s:hobbys){
            hobby=hobby+s+"||";
        }
        hobby.substring(hobby.length()-2);
        String qid=request.getParameter("qid");
        String answer=request.getParameter("answer");
        String degree=request.getParameter("degree");
        String remark=request.getParameter("remark");

        Userinfo userinfo=new Userinfo();
        userinfo.setAnswer(answer);
        userinfo.setDegree(degree);
        userinfo.setHobby(hobby);
        userinfo.setPassword(password);
        userinfo.setQid(qid);
        userinfo.setRemark(remark);
        userinfo.setSex(sex);
        userinfo.setUserid(userid);
        iUserService.register(userinfo);
        request.getRequestDispatcher("/login.jsp").forward(request,response);

    }
    //protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
    //protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
