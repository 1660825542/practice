package action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(value = "/ProductInfoAction")
public class ProductInfoAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String f="D:\\rock\\web\\picture";
        File file=new File(f);
        String []s=file.list();
        for (int i=0;i<s.length;i++)
        {
            s[i]="picture"+"\\"+s[i];
        }
        request.setAttribute("jpgs",s);
        request.setAttribute("number",5);
        request.setAttribute("productid",123456);
        String method=request.getParameter("method");
        if ("collect".equals(method))
        {
            System.out.println("收藏成功"+request.getParameter("productid"));
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
