package main.java.com.pawka.emplinfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

public class Division {
	private int division_id;
	
	private Division parent;
	
	private Set<Division> subDivisions;
	
	private String division_name;
	
	private Employee director;
	
	private Set<DivPos> divPoses;

	public int getId() {
		return division_id;
	}

	public void seId(int division_id) {
		this.division_id = division_id;
	}

	public Division getParent() {
		return parent;
	}

	public void setParent(Division parent) {
		this.parent = parent;
	}

	public String getName() {
		return division_name;
	}

	public void setName(String division_name) {
		this.division_name = division_name;
	}

	public Employee getDirector() {
		return director;
	}

	public void setDirector(Employee director) {
		this.director = director;
	}
	
	protected void setDivPosInternal(Set<DivPos> divPoses) {
		this.divPoses = divPoses;
	}
	
	protected Set<DivPos> getDivPosInternal() {
		if (this.divPoses == null) {
			this.divPoses = new HashSet<DivPos>();
		}
		return this.divPoses;
	}
	
	public List<DivPos> getDivPos() {
		List<DivPos> sortedDivPoses = new ArrayList<DivPos>(getDivPosInternal());
		PropertyComparator.sort(sortedDivPoses, new MutableSortDefinition("name", true, true));
		return Collections.unmodifiableList(sortedDivPoses);
	}
	
	public void addDivPos(DivPos divPos) {
		getDivPosInternal().add(divPos);
		divPos.setDivision(this);
	}
	
	protected Set<Division> getSubDivisionsInternal() {
		if (this.subDivisions == null) {
			this.subDivisions = new HashSet<Division>();
		}
		return this.subDivisions;
	}
	
	protected void setSubDivisions(Set<Division> subDivisions) {
		this.subDivisions = subDivisions;
	}
	
	public List<Division> getSubDivisions() {
		List<Division> sortedSubDivisions = new ArrayList<Division>(getSubDivisionsInternal());
		PropertyComparator.sort(sortedSubDivisions, new MutableSortDefinition("name", true, true));
		return Collections.unmodifiableList(sortedSubDivisions);
		
	}
	
	public void addSubDivision(Division subDivision) {
		getSubDivisionsInternal().add(subDivision);
		subDivision.setParent(this);
	}
}
