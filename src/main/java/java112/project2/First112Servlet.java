package java112.project2;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This class is a java servlet that will output
 * in HTML my name and the course I am taking
 * with an image
 *
 * @author   Elise Strauss
 */
@WebServlet(
    name = "first112Servlet",
    urlPatterns = { "/first112" }
)

public class First112Servlet extends HttpServlet {

   /**
     *  Handles HTTP GET requests.
     *
     * @param  request               the HttpRequest
     * @param  response              the HttpResponse
     * @exception  ServletException  if there is a general
     *                               servlet exception
     * @exception  IOException       if there is a general
     *                               I/O exception
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        // the response type will be set before sending the data
        PrintWriter output = response.getWriter();

        output.print("<HTML>");
        output.print("<HEAD><TITLE>My first servlet</TITLE></HEAD>");
        output.print("<BODY>");
        output.print("<H3>My Name :  Elise Strauss</H3>");
        output.print("<H3>My Class:  Advanced Java</H3>");
        output.print("<p><a href='/java112'>Back to home page</a></p>");
        output.print("<img src='images/index.jpeg' alt='no image' />");
        output.print("</BODY>");
        output.print("</HTML>");
        output.close();
    }

}





