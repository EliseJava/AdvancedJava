<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//IETF//DTD HTML 2.0//EN">
<html>
  <head>
    <meta name="generator" content=
    "HTML Tidy for Java (vers. 2009-12-01), see jtidy.sourceforge.net">
    <title>
    </title>
  </head>
  <body>
     <table>

      <c:forEach var="number" items="${myList}">
      <tr><td> ${number} </td></tr>
      </c:forEach>

     </table>
  </body>
</html>

