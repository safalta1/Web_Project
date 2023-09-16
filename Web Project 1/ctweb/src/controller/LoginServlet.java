package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		out.print("post method ");
		System.out.println("This is post block");
		
		String userName = request.getParameter("userName"); //input field/ parameter to read  input.getParameter
		String password = request.getParameter("password");
		
		if(userName.equals("Minakshi") && password.equals("Thapa")) {
			HttpSession session = request.getSession(); //session object create
			session.setAttribute("sun",userName); //some data we need throught the application so we put it on session
			RequestDispatcher rd = request.getRequestDispatcher("pages/menu.jsp");
			rd.forward(request, response);
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request,response);	
		}
		System.out.println(userName + password);
		
	}
}
