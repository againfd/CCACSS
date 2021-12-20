package Servlet;

import Service.Impl.UserServiceImpl;
import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckSnameServlet",urlPatterns = "/checkName")
public class CheckSnameServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.取参数值
        req.setCharacterEncoding("utf-8");
        String username=req.getParameter("username");
        //2.连数据库查询 true存在 false不存在
        boolean flag=userService.queryUserByUsername(username);
        //3.响应 必须输出到浏览器页面上
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        if(flag){
            //用户名存在
            out.println(1);
        }else{
            //用户名不存在
            out.println(0);
        }
        out.flush();
        out.close();
    }

}
