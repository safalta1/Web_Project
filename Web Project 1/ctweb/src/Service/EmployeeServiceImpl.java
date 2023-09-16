package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.DbConnection;

//implemeting class
public class EmployeeServiceImpl implements EmployeeService {

	Connection con = null; // database connection
	PreparedStatement ps = null; // sql quiry statement

	@Override
	public void saveEmployee(Employee e) {

		try {
			con = DbConnection.getDbConnection();
			String sql = "insert into employee (firstName, lastName,salary,age,email) values (?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, e.getFirstName()); 
			ps.setString(2, e.getLastName());
			ps.setDouble(3, e.getSalary());
			ps.setInt(4, e.getAge());
			ps.setString(5, e.getEmail());
			ps.executeUpdate();
			System.out.println("Data saved succesfully");

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

	}

	@Override
	public List<Employee> getEmployee() {
		List<Employee> list = new ArrayList<>(); 
		Employee e = null; // refrence variable just declared for object : one by one data line

		try {
			con = DbConnection.getDbConnection();
			String sql = "select * from employee";//  *- all column 
			ps = con.prepareStatement(sql);
			ResultSet rs = (ResultSet) ps.executeQuery(); // databse  result execute
			while (rs.next()) {
				e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirstName(rs.getString("firstName"));// dtabase column : whatever the name is same should be												// here
				e.setLastName(rs.getString("lastName"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
				e.setEmail(rs.getString("email"));
				list.add(e);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Total data " + list.size());
		return list;
	}

	public static void main(String[] args) { // testing if the code works
		EmployeeServiceImpl emp = new EmployeeServiceImpl();
		emp.getEmployee();
		
		
	}

	@Override
	public void deleteEmployeeByID(Integer id) {
	  
		try {
			con = DbConnection.getDbConnection();
			String sql = "delete from employee where id=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("deleted sucessfully");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Employee getEmployeeDetailById(Integer id) {
		//single Employee object 
		Employee e = null;
		try {
			con = DbConnection.getDbConnection();
			String sql = "select * from employee where id=?"; //*= tyo id ko sabei coloumn
			ps = con.prepareStatement(sql);
			ps.setInt(1,id); //same row aru column
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {	
				e = new Employee();	
				e.setId(rs.getInt("id")); //database get -> local-php
				e.setFirstName(rs.getString("firstname"));
				e.setLastName(rs.getString("lastname"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
				e.setEmail(rs.getString("email"));	
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return e; //return to Servlet
	}

	@Override
	public void updateEmployee(Employee e) {
		
		try {
			con = DbConnection.getDbConnection();
			String sql = "update employee set firstName=?, lastName=?, salary=?, age=?, email=? where id=?";
			ps = con.prepareStatement(sql); //set
			ps.setString(1, e.getFirstName());
			ps.setString(2,e.getLastName());
			ps.setDouble(3,e.getSalary());
			ps.setInt(4,e.getAge());
			ps.setString(5,e.getEmail());
			ps.setInt(6,e.getId());
			ps.executeUpdate(); //update
			System.out.println("data updated sucessfully");
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
		
		
	}

}
