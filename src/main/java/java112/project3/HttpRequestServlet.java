package java112.project3;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * This servlet will instantiate an object containing request data that will
 * be forwarded to a jsp to display the information in a web application.
 *
 * @author    Elise Strauss
 */
@WebServlet(
name = "requestServlet",
urlPatterns = {"/request-data"}
) public class HttpRequestServlet extends HttpServlet {

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

        HttpRequestData requestInformation = new HttpRequestData();

        requestInformation.setRemoteComputer(request.getLocalName());
        requestInformation.setAddressRemoteComputer(request.getLocalAddr());
        requestInformation.setHttpMethod(request.getMethod());
        requestInformation.setUriRequest(request.getRequestURI());
        requestInformation.setUrlRequest(request.getRequestURL());
        requestInformation.setProtocol(request.getProtocol());
        requestInformation.setServerName(request.getServerName());
        requestInformation.setServerPort(request.getServerPort());
        requestInformation.setServerLocale(request.getLocale());
        requestInformation.setQueryString(request.getQueryString());
        requestInformation.setQueryParameter(request.getParameter("queryParameter"));
        requestInformation.setUserAgent(request.getHeader("User-Agent"));


        request.setAttribute("PageTitle","HTTP Request data");
        request.setAttribute("data",requestInformation);


        String url = "/RequestData.jsp";

        RequestDispatcher dispatcher =
        getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
