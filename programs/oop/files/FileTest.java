import static java.lang.System.out;

public class FileTest {
	
	private FileTest() {
		final FileData data = new FileData("../numbers.txt");
		out.println("Average: " + data.getAverage());
		out.println("Highest number: " + data.getHighestNumber());
		out.println("Lowest number: " + data.getLowestNumber());
	}

	public static void main(String[] args) {
		new FileTest();
	}

}
