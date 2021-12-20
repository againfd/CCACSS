package Servlet;

import Service.Impl.PersonServiceImpl;
import Service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet",urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    private PersonService personService=new PersonServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        boolean flag=personService.deletePersonById(id);
        if(flag){
            resp.sendRedirect("listpage");
        }else resp.sendRedirect("index");
    }
}
