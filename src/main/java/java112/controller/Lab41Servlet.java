package java112.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *
 *
 *@author    Elise Strauss
 */
@WebServlet(
    name = "lab41Servlet",
    urlPatterns = { "/lab41" }
)

public class Lab41Servlet extends HttpServlet {

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


        String name = request.getParameter("firstName");

        PrintWriter  out  = response.getWriter();

        out.print("<HTML>");
        out.print("The name you entered is: " + name);
        out.print("</HTML>");
        out.close();

    }

}





