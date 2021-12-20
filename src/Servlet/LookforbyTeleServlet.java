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

@WebServlet(name = "LookforbyTeleServlet",urlPatterns = "/lookfor1")
public class LookforbyTeleServlet extends HttpServlet {
    private PersonService personService=new PersonServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String tele=req.getParameter("tele");
        List<Person> list=personService.getListByTel(tele);
        req.setAttribute("list",list);
        req.getRequestDispatcher("lookfor.jsp").forward(req,resp);
    }
}

