public class TestPet {
	
	private TestPet() {
		final Pet pet = new Pet();
		pet.setType("human");
		pet.setName("ms. song");
		pet.setAge(27);
		System.out.println(pet.getName() + " is a " + pet.getType() + " that has an age of " + pet.getAge());
	}
	
	public static void main(String[] args) {
		new TestPet();
	}

}
