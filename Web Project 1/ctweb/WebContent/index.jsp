<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <h1> User Login Portal </h1>
 <%
 //scrriplet tag
 int a =1;
 int b=20;
 int c=a+b;
 
 out.print("You are now logging into your portal. ");
 
 %>
 
 <!-- Expression Tag:  -->
 <%=request.getContextPath() %> <!--project folder name  -->
 
 
 <!-- Decleration Tag  -->
 
 <%! int x=40;
 %>
 <!--Expression Tag  -->
 <%= x %>
 
 <br/><br/>
 
 <form action="<%=request.getContextPath() %>/LoginUrl" method="POST">
 Username : <input type = "text" name = "userName" value="Minakshi" /> <br> 
 Password : <input type = "password" name = "password" value="Thapa" /> <br> <!-- break -->
 <input type = "submit" name = "submit" value = "Login" />
 </form>
</body>
</html>