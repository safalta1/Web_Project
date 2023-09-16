<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List" %> 
<%@ page import="java.util.ArrayList" %>
<%@ page import="Service.EmployeeService" %>
<%@ page import="Service.EmployeeServiceImpl" %>
<%@ page import="model.Employee" %>
<%
  EmployeeService es = new EmployeeServiceImpl();
  List<Employee> list = es.getEmployee();





%>

<%@ include file="menu2.jsp" %>

<h2>List Employee:</h2>

<table width = "100%" border="1"> 
   <tr> 
   
   <td>First Name </td> <td>Last Name </td> <td>Salary</td> <td>Age </td> <td>Email</td><td>Action </td>
   
   </tr>
   <% for(Employee e : list){ %>
   <tr> 
    <td><%=e.getFirstName()%></td> <td><%=e.getLastName()%> </td> <td><%=e.getSalary()%> </td> <td><%=e.getAge()%>  </td> <td><%=e.getEmail()%>   </td>
   
   <td> 
   <a href="<%=request.getContextPath()%>/actUrl?action=delete&id=<%=e.getId()%>">Delete</a>
      <a href="<%=request.getContextPath()%>/actUrl?action=update&id=<%=e.getId()%>">Update</a>
      
      
      
   </td>
   </tr>
<% }  %>

</table>
</body>
</html>