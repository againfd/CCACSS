package utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class CountListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    private int count=0;

    public void attributeAdded(HttpSessionBindingEvent sbe) {
        HttpSession session=sbe.getSession();
        ServletContext servletContext=session.getServletContext();
        servletContext.setAttribute("count",++count);
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        HttpSession session=sbe.getSession();
        ServletContext servletContext=session.getServletContext();
        servletContext.setAttribute("count",--count);
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attribute
         is replaced in a session.
      */
    }
}

