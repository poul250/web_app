package main.java.com.pawka.emplinfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Position {
	private int position_id;
	
	private String position_name;
	
	private Set<Duty> duties;
	
	public void setId(int position_id) {
		this.position_id = position_id;
	}
	
	public int getId() {
		return position_id;
	}
	
	public void setName(String position_name) {
		this.position_name = position_name;
	}
	
	public String getName() {
		return position_name;
	}
	
	protected void setDutiesInternal(Set<Duty> duties) {
		this.duties = duties;
	}
	
	protected Set<Duty> getDutiesInternal() {
		if (this.duties == null) {
			this.duties = new HashSet<Duty>();
		}
		return this.duties;
	}
	
	public List<Duty> getDuties() {
		List<Duty> sortedDuties = new ArrayList<Duty>(getDutiesInternal());
		PropertyComparator.sort(sortedDuties, new MutableSortDefinition("name", true, true));
		return Collections.unmodifiableList(sortedDuties);
	}
	
	public void addDuty(Duty duty) {
		getDutiesInternal().add(duty);	
	}
}
