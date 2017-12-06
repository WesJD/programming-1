public class RetailItem {
	
	private String description;
	private int unitsOnHand;
	private double price;
	
	public RetailItem(String description, int unitsOnHand, double price) {
		this.description = description;
		this.unitsOnHand = unitsOnHand;
		this.price = price;
	}
	
	public RetailItem() {}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUnitsOnHand() {
		return unitsOnHand;
	}

	public void setUnitsOnHand(int unitsOnHand) {
		this.unitsOnHand = unitsOnHand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void display() {
		System.out.println("There are " + unitsOnHand + " on hand that are $" + price + " each");
	}

}
