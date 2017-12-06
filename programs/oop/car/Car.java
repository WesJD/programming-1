public class Car {

	private String model;
	private String make;
	private double speed;
	
	public Car(String model, String make) {
		this.model = model;
		this.make = make;
		this.speed = 0;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void accelerate() {
		speed += 5;
	}
	
	public void brake() {
		speed -= 5;
	}

}
