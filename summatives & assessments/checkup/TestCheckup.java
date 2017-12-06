public class TestCheckup {

	public TestCheckup() {
		final Checkup checkup = new Checkup();
		checkup.setPatientNumber(371094);
		checkup.setSystoli(110);
		checkup.setDiastolic(78);
		checkup.setLdl(100);
		checkup.setHdl(40);
		checkup.computeRatio();
		checkup.display();
	}

	public static void main(String[] args) {
		new TestCheckup();
	}

}
