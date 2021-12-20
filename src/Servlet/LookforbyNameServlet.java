package Servlet;

import Service.Impl.PersonServiceImpl;
import Service.PersonService;
import pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LookforbyNameServlet",urlPatterns = "/lookfor")
public class LookforbyNameServlet extends HttpServlet {

    private PersonService personService=new PersonServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name=req.getParameter("name");

        List<Person> list=personService.getListByName(name);
        req.setAttribute("list",list);
        req.getRequestDispatcher("lookfor.jsp").forward(req,resp);
    }

}
