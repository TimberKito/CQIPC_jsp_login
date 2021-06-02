package cn.timber.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/heroServlet")
public class SecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //获取选择败类的String数组
        String[] bailei = request.getParameterValues("bailei");

        HttpSession session=request.getSession();
        String username = (String)session.getAttribute("username");
        System.out.println(username);



        //封装转发到前端jsp
//        request.getAttribute("name", username);
        request.setAttribute("loginname" , username);
        request.setAttribute("s" , bailei);
        request.getRequestDispatcher("hero.jsp").forward(request , response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doPost(request , response);


    }
}
