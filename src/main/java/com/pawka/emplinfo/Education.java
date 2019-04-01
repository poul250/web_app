package main.java.com.pawka.emplinfo;

public class Education {
	private int education_id;
	
	private String education_name;
	
	public void setId(int education_id) {
		this.education_id = education_id;
	}
	
	public int getId() {
		return education_id;
	}
	
	public void setName(String education_name) {
		this.education_name = education_name;
	}
	
	public String getName() {
		return education_name;
	}
}
