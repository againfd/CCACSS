package Servlet;

import Service.Impl.UserServiceImpl;
import Service.UserService;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String role=req.getParameter("role");
        User qtUser=new User(username,password,role);

        boolean flag=userService.register(qtUser);

        if(flag){
            resp.sendRedirect("login.jsp");
        }else{
            resp.sendRedirect("register.jsp");
        }
    }
}
