package java112.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * This servlet will display a jsp that will allow the client to upload a file
 * that they want to run thru the analyzer application
 *
 * @author    EliseStrauss
 */
@WebServlet(
name = "analyzerdisplay",
urlPatterns = {"/displayUpload"}
)

public class AnalyzerUploadDisplay extends HttpServlet {

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

        String url = "/AnalyzerFileUpload.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
