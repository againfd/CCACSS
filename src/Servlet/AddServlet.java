package Servlet;

import Service.Impl.PersonServiceImpl;
import Service.PersonService;
import pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@MultipartConfig
@WebServlet(name = "AddServlet",urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    private PersonService personService=new PersonServiceImpl();


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        Part part=req.getPart("picture");
        String filename=part.getSubmittedFileName();
        String serverpath="D:\\CACSS\\web\\img\\";
        InputStream in=part.getInputStream();
        FileOutputStream fos=new FileOutputStream(serverpath+filename);
        byte[] bytes=new byte[1024];
        int length=0;
        while ((length=in.read(bytes))!=-1){
            fos.write(bytes,0,length);
        }
        fos.close();
        in.close();

        String name=req.getParameter("name");
        String sex=req.getParameter("sex");
        System.out.println(sex);
        if(sex.charAt(0)=='1'){
            sex="男";
        }else{
            sex="女";
        }
        int age=Integer.parseInt(req.getParameter("age"));
        String address=req.getParameter("address");
        String tele=req.getParameter("tele");
        String picture="img/"+filename;
        Person person=new Person(name,sex,age,address,tele,picture);

        boolean flag=personService.addPerson(person);

        if(flag){
            resp.sendRedirect("listpage");
        }else{
            resp.sendRedirect("add.jsp");
        }
    }
}

