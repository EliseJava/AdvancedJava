<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<title>Sessions counting</title>
<c:import url="jsp/head-tag.jsp" />


<body>
<div id="wrap">
  <c:import url="jsp/template-head-tag.jsp" />
  <c:import url="jsp/menu-tag.jsp" />
  <div id="content">
  <p>Session counter: ${sessionCounter}</p>
  <p>Page Counter: ${pageCounter}</p>
  </div>

  <c:import url="jsp/footer.jsp" />

</div>
</body>
</html>
