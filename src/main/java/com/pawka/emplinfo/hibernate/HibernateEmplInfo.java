package main.java.com.pawka.emplinfo.hibernate;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.pawka.emplinfo.DivPos;
import main.java.com.pawka.emplinfo.Division;
import main.java.com.pawka.emplinfo.EmplInfo;
import main.java.com.pawka.emplinfo.Employee;
import main.java.com.pawka.emplinfo.JobHistory;
import main.java.com.pawka.emplinfo.Position;

@Repository
@Transactional
public class HibernateEmplInfo implements EmplInfo {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Collection<Division> getDivisions() {
		return sessionFactory.getCurrentSession().createQuery("select * from DIVISION order by  division_name").list();
	}

	@Override
	public Collection<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Employee> getEmployees(Division division) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Employee> getEmployees(Position position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<JobHistory> getHistory(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee loadEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appointment(DivPos divPos, Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Division loadDivision(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeDivision(Division division) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storePosition(Position position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeDivisionPosition(DivPos divPos) {
		// TODO Auto-generated method stub
		
	}
}
