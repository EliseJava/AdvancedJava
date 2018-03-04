<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content">
    <h2>Employee Search Results<span class="post-span"> by Elise Strauss</span></h2>

<!--      <td style='border:1px solid black;'> ${employee.employeeSSN} </td>  -->
      <br>
      <p><a href="displaySearch">Back to Search Page</a></li></a></p>

      <c:choose>
          <c:when test="${theResults.employeeFound == true}" >
              <table>
              <tr>
                  <th>ID        </th>
                  <th>Name      </th>
                  <th>Last Name </th>
                  <th>SSN       </th>
                  <th>Department</th>
                  <th>Room      </th>
                  <th>Phone     </th>
              </tr>
              <c:forEach var="employee" items="${theResults.queryResults}">
              <tr><td style="border:1px solid black;"> ${employee.employeeId}  </td>
                  <td style="border:1px solid black;"> ${employee.firstName}   </td>
                  <td style="border:1px solid black;"> ${employee.lastName}    </td>
                  <td style="border:1px solid black;"> ${employee.employeeSsn} </td>
                  <td style="border:1px solid black;"> ${employee.department}  </td>
                  <td style="border:1px solid black;"> ${employee.roomNumber}  </td>
                  <td style="border:1px solid black;"> ${employee.phoneNumber} </td>
              </tr>
              </c:forEach>
              </table>
          </c:when>
          <c:otherwise>
             <h3>NO Employees found, please enter a valid employee.</h3>
          </c:otherwise>
      </c:choose>

    <p><a href='/java112'     >Back to homepage</a></p>
</div>