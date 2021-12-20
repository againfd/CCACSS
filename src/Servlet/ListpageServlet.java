package Servlet;

import Service.Impl.PersonServiceImpl;
import Service.PersonService;
import pojo.PageBean;
import pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListpageServlet",urlPatterns = "/listpage")
public class ListpageServlet extends HttpServlet {
    private PersonService personService=new PersonServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取当前页
        String currentPage=req.getParameter("currentPage");
        if(currentPage==null){
            currentPage="1";
        }
        Integer currentPageNum=Integer.parseInt(currentPage);
        PageBean<Person> pageBean=personService.queryPersonsByPage(currentPageNum,20);
//        System.out.println(pageBean);
        req.setAttribute("page",pageBean);
        req.getRequestDispatcher("listpage.jsp").forward(req,resp);
    }
}
