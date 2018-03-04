package java112.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.entity.*;

/**
 *  This servlet will pass a new emploee to be added to the database
 *
 *@author    Elise Strauss
 */
@WebServlet(
    name = "employeeAdd2",
    urlPatterns = { "/addEmployee" }
)

public class EmployeeAddNew extends HttpServlet {

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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String addFirstName = request.getParameter("addFirstName");
        String addLastName  = request.getParameter("addLastName");
        String addSSN       = request.getParameter("addSSN");
        String addDept      = request.getParameter("addDept");
        String addRoom      = request.getParameter("addRoom");
        String addPhone     = request.getParameter("addPhone");

        ServletContext context = getServletContext();

        EmployeeDirectory results =
                (EmployeeDirectory) context.getAttribute("employDirect");

        String message = results.addEmployee(addFirstName, addLastName, addSSN, addDept,
                            addRoom,addPhone);

        HttpSession session = request.getSession();
        session.setAttribute("project4AddMessage", message);

        String url = "/java112/displayAdd";

        response.sendRedirect(url);
    }
}