package Service;


import java.util.List;

import model.Employee;

public interface EmployeeService {
	
	void saveEmployee(Employee e);
	
	List<Employee> getEmployee();
	
	void deleteEmployeeByID(Integer id); //id basis data delete
	
    Employee getEmployeeDetailById(Integer id);
    
    void updateEmployee(Employee e);
}
