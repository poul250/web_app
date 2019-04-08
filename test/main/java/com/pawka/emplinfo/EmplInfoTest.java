package main.java.com.pawka.emplinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration
public abstract class EmplInfoTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	protected EmplInfo emplInfo;
	
	@Test
	public void getDivisions() {
		Collection<Division> divisions = this.emplInfo.getDivisions();
		Division d = null;
		for (Division div : divisions) {
			if (div.getId() == 3) {
				d = div;
				break;
			}
		}
		assertEquals(d, null);
		
		assertEquals(d.getName(), "The best company");
		assertNotNull(d.getDirector());
		Employee empl = d.getDirector();
		assertEquals(empl.getId(), 3);
	}
	
	@Test
	public void getEmployees() {
		Collection<Employee> empls = this.emplInfo.getEmployees(1);
		assertEquals(empls.size(), 3);
		
		Employee boss = null;
		for (Employee empl : empls) {
			if (empl.getId() == 3) {
				boss = empl;
				break;
			}
		}
		assertNotNull(boss);
		assertEquals(boss.getName(), "Павел");
	}
	
	@Test
	public void getHistory() {
		Collection<JobHistory> hist = this.emplInfo.getHistory(2);
		JobHistory history = null;
		for (JobHistory h : hist) {
			if (h.getId() == 4) {
				history = h;
			}
		}
		assertNotNull(history);
		assertEquals(history.getDateFinish(), null);
		assertNotNull(history.getDateStart());
	}
	
	@Test
	public void loadEmployee() {
		Employee empl = this.emplInfo.loadEmployee(5);
		assertNotNull(empl);
		assertEquals(empl.getName(), "Билл");
		assertEquals(empl.getId(), 5);
		assertEquals(empl.getAddress(), "США");
		empl = this.emplInfo.loadEmployee(10);
		assertEquals(empl.getName(), "Мирослав");
	}
	
	@Test
	public void storeEmployee() {
		int size = this.emplInfo.getEmployees().size();
		Employee empl = new Employee();
		empl.setId(100);
		empl.setName("da");
		Collection<Education> eds = this.emplInfo.getEducations();
		for (Education ed : eds) {
			if (ed.getId() == 3) {
				empl.setEducation(ed);
				break;
			}
		}		
		empl.setSurname("dada");
		empl.setAddress("net");

		this.emplInfo.storeEmployee(empl);
		assertEquals(size + 1, this.emplInfo.getEmployees().size());
	}
	
	@Test
	public void deleteEmployee() {
		Employee empl = new Employee();
		empl.setId(101);
		empl.setName("da");
		empl.setSurname("dada");
		empl.setAddress("net");
		Collection<Education> eds = this.emplInfo.getEducations();
		for (Education ed : eds) {
			if (ed.getId() == 3) {
				empl.setEducation(ed);
				break;
			}
		}
		
		this.emplInfo.storeEmployee(empl);
		int size = this.emplInfo.getEmployees().size();
		this.emplInfo.deleteEmployee(101);
		assertEquals(size - 1, this.emplInfo.getEmployees().size());
	}
	
	@Test
	public void loadDivision() {
		Division div = this.emplInfo.loadDivision(3);
		assertNotNull(div);
		assertEquals(div.getName(), "Huarei");
	}
	
	@Test
	public void storeDivision() {
		Division div = new Division();
		div.setDirector(this.emplInfo.loadEmployee(1));
		div.setName("Company");
		div.setId(10);
		div.setParent(this.emplInfo.loadDivision(3));
		div.setDivPosesInternal(new HashSet<DivPos>());
		
		int size = this.emplInfo.getDivisions().size();
		this.emplInfo.storeDivision(div);
		assertEquals(size + 1, this.emplInfo.getDivisions().size());
		div = this.emplInfo.loadDivision(10);
		assertEquals(div.getName(), "Company");
	}
	
	@Test
	public void loadPosition() {
		Position pos = this.emplInfo.loadPosition(8);
		assertEquals(pos.getName(), "Шпийон");
	}
	
	@Test
	public void storePosition() {
		Position pos = this.emplInfo.loadPosition(8);
		pos.setName("Не шпийон");
		this.emplInfo.storePosition(pos);
		assertEquals(this.emplInfo.loadPosition(8), "Не шпийон");
	}
	
	@Test
	public void loadDivPos() {
		DivPos pos = this.emplInfo.loadDivisionPosition(2);
		assertEquals(pos.getDivision().getId(), this.emplInfo.loadDivision(1).getId());
	}
	
	@Test
	public void storeDivPos() {
		DivPos dpos = this.emplInfo.loadDivisionPosition(2);
		assertEquals(dpos.getPosition().getId(), 6);
		dpos.setPosition(this.emplInfo.loadPosition(1));
		this.emplInfo.storeDivisionPosition(dpos);
		assertEquals(this.emplInfo.loadDivisionPosition(2).getPosition().getId(), 1);
	}
}
