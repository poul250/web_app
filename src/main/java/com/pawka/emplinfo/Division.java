package main.java.com.pawka.emplinfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

public class Division {
	private int id;

	private Division parent;

	private String name;

	private Employee director;

	private Set<DivPos> divPoses;

	public int getId() {
		return id;
	}

	public void seId(int id) {
		this.id = id;
	}

	public Division getParent() {
		return parent;
	}

	public void setParent(Division parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getDirector() {
		return director;
	}

	public void setDirector(Employee director) {
		this.director = director;
	}
	
	protected Set<DivPos> getDivPosesInternal() {
		if (this.divPoses == null) {
			this.divPoses = new HashSet<DivPos>();
		}
		return this.divPoses;
	}
	
	protected void setDivPosesInternal(Set<DivPos> divPoses) {
		this.divPoses = divPoses;
	}
	
	public List<DivPos> getDivPoses() {
		List<DivPos> sortedDivPoses = new ArrayList<DivPos>(getDivPosesInternal());
		PropertyComparator.sort(sortedDivPoses, new MutableSortDefinition("name", true, true));
		return Collections.unmodifiableList(sortedDivPoses);
	}
	
	public void addDivPos(DivPos divPos) {
		getDivPosesInternal().add(divPos);
	}
}
