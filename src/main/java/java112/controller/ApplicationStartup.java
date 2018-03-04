package java112.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.javabackground.*;
import java112.entity.EmployeeDirectory;

/**
 * This servlet will load a properties files and assign it as an attribute to
 * the ServletContext object.  Will also instantiate an EmployeeDirectory object
 * and also assign it as an attribute to the ServletContext.
 *
 *@author   Elise Strauss
 */
@WebServlet(
    name = "applicationStartup",
    urlPatterns = { "/project4-startup" },
    loadOnStartup = 1
)

public class ApplicationStartup extends HttpServlet
                                implements PropertiesLoaderInterface {

    /**
      * This metod will load the properties file
      * @throws ServletException The exception thrown by init()
      */
    public void init() throws ServletException {

        Properties properties4;
        Properties analyzerProperties;

        properties4         = loadProperties("/project4.properties");

        ServletContext context = getServletContext();

        context.setAttribute("project4Properties", properties4);

        EmployeeDirectory employeeDirectory = new EmployeeDirectory(properties4);

        context.setAttribute("employDirect", employeeDirectory);

    }
}





