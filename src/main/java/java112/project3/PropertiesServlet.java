package java112.project3;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.javabackground.*;

/**
 * This servlet will load a Properties object and forward it to a JSP
 *@author    Elise Strauss
 */
@WebServlet(
    name = "project3PropertiesServlet",
    urlPatterns = { "/project3-properties" }
)

public class PropertiesServlet extends HttpServlet
                               implements PropertiesLoaderInterface {

    private Properties properties3;

    /**
      * This metod will load the properties file
      * @throws ServletException The exception thrown by init()
      */
    public void init() throws ServletException {

        properties3 = loadProperties("/project3.properties");

    }

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general
     *                              servlet exception
     *@exception  IOException       if there is a general
     *                              I/O exception
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("PageTitle","Forward a Properties file to JSP");
        request.setAttribute("PropMap",properties3);

        String url = "/Properties3.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);
    }
}





