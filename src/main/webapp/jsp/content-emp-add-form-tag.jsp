<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content">
    <h2>Add an Employee<span class="post-span"> by Elise Strauss</span></h2>

    <p><a href="displaySearch">To Search Page</a></li></a></p>

    <h3>${project4AddMessage}</h3>
    <c:remove var = "project4AddMessage"/>

    <form action="/java112/addEmployee" method="POST">

        <br>First Name
        <br><input type="whaptype2" name="addFirstName"><br>
        <br>Last Name
        <br><input type="whaptype2" name="addLastName"><br>
        <br>SSN
        <br><input type="whaptype2" name="addSSN"><br>
        <br>Department
        <br><input type="whaptype2" name="addDept"><br>
        <br>Room Number
        <br><input type="whaptype2" name="addRoom"><br>
        <br>Phone Number
        <br><input type="whaptype2" name="addPhone"><br>

        <br><br>
        <input type="submit" value="Submit">
      </form>

    <p><a href='/java112'>Back to homepage</a></p>
</div>