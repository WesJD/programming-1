public class TestCircle {
	
	private TestCircle() {
		final Circle first = new Circle();
		first.setRadius(.5D);
		computeAndPrint("one", first);
		
		final Circle second = new Circle();
		second.setRadius(2D);
		computeAndPrint("two", second);

		computeAndPrint("three (default)", new Circle());
	}
	
	private void computeAndPrint(String name, Circle circle) {
		circle.computeDiameter();
		circle.computeArea();
		System.out.println("Circle " + name + " has a diameter of " + circle.getDiameter() + 
				" and an area of " + circle.getArea());
	}
	
	public static void main(String[] args) {
		new TestCircle();
	}
}
