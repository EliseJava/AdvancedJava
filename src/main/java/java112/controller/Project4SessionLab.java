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
    name = "project4SessionLab",
    urlPatterns = { "/sessionLab" }
)

public class Project4SessionLab extends HttpServlet {

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

        HttpSession session = request.getSession();

        Integer sessionCounter = (Integer) session.getAttribute("project4SessionCounter");

         if (sessionCounter == null) {
             session.setAttribute("sessionCounter", new Integer(1));
         } else {
             int counter = sessionCounter.intValue();
             session.setAttribute("sessionCounter", new Integer(counter += 1));
         }

         String url = "/project4Session.jsp";

         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
         dispatcher.forward(request, response);


    }

}





