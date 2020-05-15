
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Cookies</title>

</head>
<body>

<h1>Cookies</h1>

<p>Here's a table with all of the cookies that this 
browser is sending to the current server.</p>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
  <tr>
    <th>Name</th>
    <th>Value</th>
  </tr>
  <c:forEach var="c" items="${cookie}">      
  <tr>
    <td>${c.value.name}</td>
    <td>${c.value.value}</td>
  </tr>
  </c:forEach>  
</table>
<p><a href="home.jsp?action=home">Return Home</a></p>
<p><a href="register?action=deleteCookies">Delete all persistent cookies</a></p>

</body>
</html>