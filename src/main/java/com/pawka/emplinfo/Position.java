package main.java.com.pawka.emplinfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Position {
	private int id;

	private String name;

	private Set<Duty> duties;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
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
