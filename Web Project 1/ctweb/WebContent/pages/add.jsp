 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="menu2.jsp" %>

<h2>Save Employee:</h2>

<form action="<%=request.getContextPath() %>/saveEmpUrl" method="POST">
First Name: <input type="text" name="firstName" /> <br/> 
Last Name: <input type="text" name="lastName" /> <br/>
Salary: <input type="text" name="salary" /> <br/>
Age: <input type="text" name="age" /> <br/>
Email: <input type="text" name="email" /> <br/>

<input type="submit" name= "submit" value="Save Employee" /> <br/>



</form>

</body>
</html>