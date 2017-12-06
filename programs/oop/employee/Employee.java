class Employee {
	
	private String name;
	private int idNumber;
	private String department;
	private String position;
	
	public Employee(String name, int idNumber, String department, String position) {
		this.name = name;
		this.idNumber = idNumber;
		this.department = department;
		this.position = position;
	}
	
	public Employee(String name, int idNumber) {
		this.name = name;
		this.idNumber = idNumber;
	}
	
	public Employee() {}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	
	public void setDeparment(String department) {
		this.department = department;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getName() {
		return name;
	}
	
	public int getIdNumber() {
		return idNumber;
	}
	
	public String getDeparment() {
		return department;
	}
	
	public String getPosition() {
		return position;
	}

}
