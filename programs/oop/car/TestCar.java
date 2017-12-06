public class TestCar {

	public TestCar() {
		final Car car = new Car("Ford 2003", "Explorer");
		for(int i=0; i<5; i++) car.accelerate();
		System.out.println("The car is at " + car.getSpeed() + " MPH.");
		for(int i=0; i<5; i++) {
			car.brake();
			System.out.println("The car is at " + car.getSpeed() + " MPH.");
		}
	}
	
	public static void main(String[] args) {
		new TestCar();
	}

}
