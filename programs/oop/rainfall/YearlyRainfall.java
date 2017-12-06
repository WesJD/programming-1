import java.util.Arrays;
import java.util.DoubleSummaryStatistics;

public class YearlyRainfall {
	
	private final DoubleSummaryStatistics stats;
	
	public YearlyRainfall(double... rainfalls) {
		this.stats = Arrays.stream(rainfalls).summaryStatistics();
	}
	
	public double getTotal() {
		return stats.getSum();
	}
	
	public double getAverage() {
		return stats.getAverage();
	}
	
	public double getMostRain() {
		return stats.getMax();
	}
	
	public double getLeastRain() {
		return stats.getMin();
	}

}
