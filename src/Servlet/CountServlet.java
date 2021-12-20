package Servlet;

import Service.Impl.PersonServiceImpl;
import Service.PersonService;
import pojo.EchartsBean;
import com.alibaba.fastjson.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CountServlet",urlPatterns = "/count")
public class CountServlet extends HttpServlet {
    private PersonService personService=new PersonServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<EchartsBean> list=personService.findCountByAddress();
        //将List集合转换成json数据
        String json= JSONObject.toJSONString(list);
        req.setAttribute("list",json);
        req.getRequestDispatcher("tb.jsp").forward(req,resp);
    }
}
