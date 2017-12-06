public class RetailItemTest {

	public RetailItemTest() {
		final RetailItem jacket = new RetailItem("Jacket", 12, 59.95D);
		jacket.display();
		
		final RetailItem jeans = new RetailItem();
		jeans.setDescription("Designer Jeans");
		jeans.setUnitsOnHand(40);
		jeans.setPrice(34.95D);
		jeans.display();
		
		final RetailItem shirt = new RetailItem("Shirt", 20, 24.95D);
		shirt.display();
	}

	public static void main(String[] args) {
		new RetailItemTest();
	}

}
