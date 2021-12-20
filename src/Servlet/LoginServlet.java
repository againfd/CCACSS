package Servlet;

import Service.Impl.UserServiceImpl;
import Service.UserService;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String role=request.getParameter("role");
        User qtUser=new User(username,password,role);

        User htUser=userService.login(qtUser);
        response.setContentType("text/jsp");
        PrintWriter out=response.getWriter();

        if(htUser!=null){
            if(htUser.getRole().equals("管理员")){
                HttpSession session=request.getSession();
                session.setAttribute("user",htUser);
                out.println(1);
            }else{
                HttpSession session=request.getSession();
                session.setAttribute("user",htUser);
                out.println(0);
            }
        }else{
            out.println(2);
        }
        out.flush();
        out.close();
    }
}
