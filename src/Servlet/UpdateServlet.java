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

@WebServlet(name = "UpdateServlet",urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    private PersonService personService=new PersonServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Integer id=Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String sex=req.getParameter("sex");
        int age=Integer.parseInt(req.getParameter("age"));
        String address=req.getParameter("address");
        String tele=req.getParameter("tele");
        String picture=req.getParameter("picture");
        Person person=new Person(id,name,sex,age,address,tele,picture);
//        System.out.println(person);

        boolean flag=personService.updatePerson(person);
        if(flag){
            resp.sendRedirect("listpage");
        }else{
            resp.sendRedirect("update.jsp");
        }
    }
}

