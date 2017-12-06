class Circle {
	
	private double radius,
				   area,
				   diameter;
	
	public Circle() {
		this.radius = 1;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void computeDiameter() {
		this.diameter = radius * 2;
	}
	
	public void computeArea() {
		this.area = Math.PI * Math.pow(radius, 2);
	}
	
	public double getDiameter() {
		return diameter;
	}
	
	public double getArea() {
		return area;
	}

}
