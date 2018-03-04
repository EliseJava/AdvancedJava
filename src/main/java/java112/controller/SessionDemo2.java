package java112.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This servlet demonstrate sessions
 *
 *@author    Eric Knapp
 */
@WebServlet(
    name = "sessiondemo2",
    urlPatterns = { "/session2" }
)

public class SessionDemo2 extends HttpServlet {

    //is this threadsafe?  yes atomic variable
    //2thread going java will lock one out
    //readonly is thread safe.
    private int pageCounter;

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

         pageCounter +=1;

         HttpSession session = request.getSession();

         Integer sessionCounter = (Integer) session.getAttribute("sessionCounter");

         if (sessionCounter == null) {
             session.setAttribute("sessionCounter", new Integer(1));
         } else {
             int counter = sessionCounter.intValue();
             session.setAttribute("sessionCounter", new Integer(counter += 1));
         }

         request.setAttribute("pageCounter", pageCounter);

         String url = "/sessions-demo2.jsp";

         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
         dispatcher.forward(request, response);

    }
}





