public enum TemperaturePoint {
	
	ETHYL_ALCHOHOL(-173, 172),
	OXYGEN(-362, -306),
	WATER(32, 212);
	
	private final int freezingPoint;
	private final int boilingPoint;
	
	TemperaturePoint(int freezingPoint, int boilingPoint) {
		this.freezingPoint = freezingPoint;
		this.boilingPoint = boilingPoint;
	}

	public int getFreezingPoint() {
		return freezingPoint;
	}

	public int getBoilingPoint() {
		return boilingPoint;
	}
	
	public boolean canFreezeAt(int temp) {
		return temp <= freezingPoint;
	}
	
	public boolean canBoilAt(int temp) {
		return temp >= boilingPoint;
	}
	
	@Override
	public String toString() {
		return super.toString().replace("_", " ").toLowerCase();
	}

}
