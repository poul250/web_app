package main.java.com.pawka.emplinfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

public class DivPos {
    private int id;

	private Division division;

	private Position position;

	private Set<JobHistory> histories;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

	protected Set<JobHistory> getHistoriesInternal() {
		if (this.histories == null) {
			this.histories = new HashSet<JobHistory>();
		}
		return this.histories;
	}

	protected void setHistoriesInternal(Set<JobHistory> histories) {
		this.histories = histories;
	}

	public List<JobHistory> getHistories() {
		List<JobHistory> sortedHistories = new ArrayList<JobHistory>(getHistoriesInternal());
		PropertyComparator.sort(sortedHistories, new MutableSortDefinition("name", true, true));
		return Collections.unmodifiableList(sortedHistories);
	}

	public void addHistory(JobHistory histories) {
		getHistoriesInternal().add(histories);
	}
}
