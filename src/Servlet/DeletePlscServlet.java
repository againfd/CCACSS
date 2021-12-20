package Servlet;

import Service.Impl.PersonServiceImpl;
import Service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeletePlscServlet",urlPatterns = "/deleteplsc")
public class DeletePlscServlet extends HttpServlet {
    private PersonService personService=new PersonServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids=req.getParameter("ids");
        System.out.println("ids:"+ids);

        boolean flag=personService.deletePersonByBatch(ids);
        PrintWriter out=resp.getWriter();
        if(flag){
            out.println(1);
        }else{
            out.println(0);
        }
        out.flush();
        out.close();
    }
}

