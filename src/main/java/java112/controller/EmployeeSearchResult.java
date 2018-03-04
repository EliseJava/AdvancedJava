package java112.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.entity.*;

/**
 * This servlet receives the term and type from an HTML form and send them
 * the the EmloyeeDirectory class to seach the database
 *
 *@author    Elise Strauss
 */
@WebServlet(
    name = "employeeresults",
    urlPatterns = { "/searchResult" }
)

public class EmployeeSearchResult extends HttpServlet {

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

        String searchTerm = request.getParameter("searchTerm");
        String searchType = request.getParameter("searchType");

        ServletContext context = getServletContext();

        EmployeeDirectory results =
                (EmployeeDirectory) context.getAttribute("employDirect");

        Search searchEmployee = results.searchEmployeeDB(searchTerm, searchType);

        HttpSession session = request.getSession();
        session.setAttribute("theResults", searchEmployee);

        String url = "/emp-display-search-results.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);
    }
}