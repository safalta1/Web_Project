package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.EmployeeService;
import Service.EmployeeServiceImpl;
import model.Employee;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EmployeeService es = new EmployeeServiceImpl();
    
    public UpdateServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		double salary= Double.parseDouble(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email= request.getParameter("email");
		
		Employee e = new Employee();
		e.setId(id);
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setSalary(salary);
		e.setAge(age);
		e.setEmail(email);
		
	   es.updateEmployee(e);	 
		
	   RequestDispatcher rd = request.getRequestDispatcher("pages/list.jsp"); 
		rd.forward(request, response);
	}

}
