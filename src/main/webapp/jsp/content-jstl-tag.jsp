<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content">
<h2>JSTL forEach<span class="post-span"> by Elise Strauss</span></h2>
<table>
      <c:forEach var="number" items="${myList}">
      <tr><td> ${number} </td></tr>
      </c:forEach>
</table>
<p><a href='/java112'>Back to homepage</a></p>
</div>