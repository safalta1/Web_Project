<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<h2> Menu Page:</h2>

<h2>Logged In User:: <%=session.getAttribute("sun").toString() %></h2>
<a href="pages/add.jsp">Add Employee</a> <br/> 
<a href="pages/list.jsp">List Employee</a> <br/>
<a href="pages/Logout.jsp">LogOut</a> <br/>


</body>
</html>