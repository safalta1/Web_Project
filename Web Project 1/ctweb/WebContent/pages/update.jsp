<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="menu.jsp" %>
 <h2>Update Employee:</h2>
 
 <h2>Save Employee:</h2>

<form action="<%=request.getContextPath() %>/updateEmpUrl" method="POST">
<input type = "text" name="id" value="${emp.getId() }" /> <br/>
First Name: <input type="text" name="firstName" value="${emp.getFirstName()}"/> <br/> 
Last Name: <input type="text" name="lastName" value= "${emp.getLastName() }" /> <br/>
Salary: <input type="text" name="salary" value="${emp.getSalary()}" /> <br/>
Age: <input type="text" name="age" value="${emp.getAge()}" /> <br/>
Email: <input type="text" name="email"  value="${emp.getEmail()}"/> <br/>

<input type="submit" name= "submit" value="Update Employee" /> <br/>



</form>