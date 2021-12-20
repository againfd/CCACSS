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

@WebServlet(name = "LoadServlet",urlPatterns = "/load")
public class LoadServlet extends HttpServlet {
    private PersonService personService=new PersonServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=Integer.parseInt(req.getParameter("id"));
        Person person=personService.queryOnePersonById(id);
//        System.out.println(person);
        req.setAttribute("s",person);
        req.getRequestDispatcher("update.jsp").forward(req,resp);
    }
}
