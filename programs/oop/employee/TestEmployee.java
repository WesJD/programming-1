import java.util.Objects;

public class TestEmployee {
	
	/*
	 * Susan Meyers		47899			Accounting		Vice  President
Mark Jones		39119			IT			Programmer
Joy Rogers		81774			Manufacturing	Engineer

	 */
	
	private TestEmployee() {
		print(new Employee("Susan Meyers", 47899, "Accounting", "Vice President"));
		
		final Employee mark = new Employee("Mark Jones", 39119);
		mark.setDeparment("IT");
		mark.setPosition("Programmer");
		print(mark);
		
		final Employee joy = new Employee();
		joy.setName("Joy");
		joy.setIdNumber(81774);
		joy.setDeparment("Manufacturing");
		joy.setPosition("Engineer");
		print(joy);
	}
	
	private void print(Employee employee) {
		System.out.println(employee.getName() + " - " + 
	                       "ID: " + employee.getIdNumber() + 
	                       ", Department: " + Objects.toString(employee.getDeparment(), "Undefined") + 
	                       ", Position: " + Objects.toString(employee.getPosition(), "Undefined"));
	}
	
	public static void main(String[] args) {
		new TestEmployee();
	}

}
