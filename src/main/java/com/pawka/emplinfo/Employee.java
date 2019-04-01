package main.java.com.pawka.emplinfo;

public class Employee {
	private int employee_id;
	
	private String employee_name;
	private String employee_surname;
	private String patronymic;
	
	private String address;
	
	private Education education;
	
	public int getId() {
		return employee_id;
	}

	public void setId(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getName() {
		return employee_name;
	}

	public void setName(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getSurname() {
		return employee_surname;
	}

	public void setSurname(String employee_surname) {
		this.employee_surname = employee_surname;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}	
	
	
}
