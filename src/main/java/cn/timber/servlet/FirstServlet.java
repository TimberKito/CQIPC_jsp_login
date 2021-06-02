package cn.timber.servlet;

import cn.timber.mysql.Mysql;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        //后端控制台输出
        System.out.println(username+" "+password);

        //密码匹配接口
        String myPwd = "123456";

        HttpSession session=request.getSession();
        session.setAttribute("username", username);

        //信息加入数据库


        //密码判断
        if(password.equals(myPwd)) {
            //重定向到登录成功页面
            response.sendRedirect(request.getContextPath()+"/loginSuccess.jsp?username="+ username);
        }else {
            //重定向到登录失败页面
            response.sendRedirect(request.getContextPath()+"/loginFail.jsp?username="+ username);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doPost(request , response);

    }
}
