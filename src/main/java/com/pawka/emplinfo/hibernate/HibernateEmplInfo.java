package main.java.com.pawka.emplinfo.hibernate;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import main.java.com.pawka.emplinfo.Education;

@Repository
@Transactional
public class HibernateEmplInfo implements EmplInfo {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Division> getDivisions() {
		return sessionFactory.getCurrentSession().createQuery("from Division division order by division.name").list();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Employee> getEmployees() {
		return sessionFactory.getCurrentSession().createQuery("from Employee employee order by employee.surname, employee.name").list();
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Education> getEducations() {
		return sessionFactory.getCurrentSession().createQuery("from Education education order by education.name").list();
	}

	@Override
	public Collection<Employee> getEmployees(int division_id) {
		Division div = (Division) sessionFactory.getCurrentSession().load(Division.class, division_id);
		List<DivPos> divPoses = div.getDivPoses();
		Set<Employee> employees = new HashSet<Employee>();
		for (DivPos dp : divPoses) {
			List<JobHistory> histories = dp.getHistories();
			for (JobHistory jh : histories) {
				employees.add(jh.getEmployee());
			}
		}
		return employees;
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Collection<JobHistory> getHistory(int employee_id) {
		return sessionFactory.getCurrentSession().createQuery("from JobHistory history where history.employee.id = :employee_id")
				.setString("employee_id", employee_id + "%").list();
	}

	@Transactional(readOnly = true)
	@Override
	public Employee loadEmployee(int id) {
		return (Employee) sessionFactory.getCurrentSession().load(Employee.class, id);
	}

	@Override
	public void storeEmployee(Employee employee) {
		sessionFactory.getCurrentSession().merge(employee);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteEmployee(int employee_id) {
		sessionFactory.getCurrentSession().createQuery("delete from JobHistory history where history.employee.id = :employee_id")
			.setString(":employee_id", employee_id + "%");
		
	}

	@Override
	public Division loadDivision(int id) {
		return (Division) sessionFactory.getCurrentSession().load(Division.class, id);
	}

	@Override
	public void storeDivision(Division division) {
		sessionFactory.getCurrentSession().merge(division);
	}
	
	@Override
	public void storePosition(Position position) {
		sessionFactory.getCurrentSession().merge(position);
	}

	@Override
	public void storeDivisionPosition(DivPos divPos) {
		sessionFactory.getCurrentSession().merge(divPos);
	}

	@Override
	public Position loadPosition(int id) {
		return (Position) sessionFactory.getCurrentSession().load(Position.class, id);
	}

	@Override
	public DivPos loadDivisionPosition(int id) {
		return (DivPos) sessionFactory.getCurrentSession().load(DivPos.class, id);
	}
}
