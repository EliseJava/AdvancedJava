<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta name="generator" content="HTML Tidy, see www.w3.org" />
   
    <title>Session Attributes</title>
  </head>
  
  <body>
  
  <h3>getting an attribute from a session</h3>
  
    <c:if test="${session_name != null}" >
       <h3>session_name found: ${session_name}</h3>
    </c:if>
  
    <c:if test="${session_name == null}" >
       <h3>session_name not found</h3>
    </c:if>
  
     <c:set var="session_name" value="Hi mom!" scope="session" />
  
     <p>After: ${session_name}</p>
  
  </body>
</html>
