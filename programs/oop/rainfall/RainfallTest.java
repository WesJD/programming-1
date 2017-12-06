import static java.lang.System.out;

import java.text.NumberFormat;

public class RainfallTest {

	public RainfallTest() {
		final YearlyRainfall rainfall = new YearlyRainfall(19, 20, 22, 21, 14, 15, 27, 18, 25, 11, 13, 18);
		out.println("The total rainfall was " + rainfall.getTotal());
		out.println("The average monthly rainfall was " 
				+ NumberFormat.getNumberInstance().format(rainfall.getAverage()));
		out.println("The least rain was " + rainfall.getLeastRain());
		out.println("The most rain was " + rainfall.getMostRain());
	}

	public static void main(String[] args) {
		new RainfallTest();
	}

}
