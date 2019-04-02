package main.java.com.pawka.emplinfo;

import java.util.Collection;

public interface EmplInfo {
	Collection<Division> getDivisions();
	
	Collection<Employee> getEmployees();
	
	Collection<Employee> getEmployees(int division_id);
	
	Collection<JobHistory> getHistory(int employee_id);
	
	Employee loadEmployee(int id);
	
	// store new employee or update existing
	void storeEmployee(Employee employee);
	
	// appoint employee on a new position in division
	void appointment(int divPos_id, int employee_id);

	// delete employee from database
	void deleteEmployee(int employee_id);
	
	// load division by id
	Division loadDivision(int id);
	
	// store new division or update existing
	void storeDivision(Division division);
	
	// create new position or update existing
	void storePosition(Position position);
	
	// store new DivPos or update existing
	void storeDivisionPosition(DivPos divPos);
}
