package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.EmployeeService;
import Service.EmployeeServiceImpl;
import model.Employee;


@WebServlet("/EmployeServlet")
public class EmployeServlet extends HttpServlet { 
	
	private static final long serialVersionUID = 1L;
   EmployeeService es = new EmployeeServiceImpl();
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("get method. ");
		
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(action.equals("delete")) {
			out.print("delete");
			es.deleteEmployeeByID(id);
			RequestDispatcher rd = request.getRequestDispatcher("pages/list.jsp"); 
			rd.forward(request, response);
		}else if (action.equals("update")) {
			out.print("update");
			Employee e =es.getEmployeeDetailById(id); 
			request.setAttribute("emp", e); //sending to jsp
			RequestDispatcher rd = request.getRequestDispatcher("pages/update.jsp");
			rd.forward(request,response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		double salary= Double.parseDouble(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email= request.getParameter("email");
		
		Employee e = new Employee();
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setSalary(salary);
		e.setAge(age);
		e.setEmail(email);
		
		es.saveEmployee(e); 
		
		
		System.out.println(e.getFirstName() + e.getSalary());
	    RequestDispatcher rd = request.getRequestDispatcher("pages/add.jsp"); 
		rd.forward(request, response);
		
	}
}
