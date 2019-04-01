package main.java.com.pawka.emplinfo;

import java.sql.Date;

public class JobHistory {
	private int id;
	
	private Employee employee;
	
	private Division division;
	
	private Position position;
	
	private Date date_start;
	
	private Date date_finish;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Date getDateStart() {
		return date_start;
	}

	public void setDateStart(Date date_start) {
		this.date_start = date_start;
	}

	public Date getDateFinish() {
		return date_finish;
	}

	public void setDateFinish(Date date_finish) {
		this.date_finish = date_finish;
	}
	
	
}
