package com.rock.action;

import com.rock.entities.Question;
import com.rock.service.IQuestionService;
import com.rock.service.serviceimpl.IQuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/ActionUser")
public class ActionUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method=request.getParameter("method");
        if("getAllQuestion4Register".equals(method))
            this.getAllQuestion4Register(request,response);
    }

    private void getAllQuestion4Register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IQuestionService q=new IQuestionServiceImpl();
        List<Question> all=q.allQuestions();
        request.setAttribute("qs",all);
        request.getRequestDispatcher("/r1.jsp").forward(request,response);
    }

}
