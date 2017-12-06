import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

public class FileData {
	
	private final int[] numbers;
	private final IntSummaryStatistics statistics;
	
	public FileData(String resource) {
		try {
			final List<Integer> lines = new ArrayList<>();
			final BufferedReader reader = new BufferedReader(new InputStreamReader(
					getClass().getResourceAsStream(resource)));
			{
				String line;
				while((line = reader.readLine()) != null) lines.add(Integer.parseInt(line));
			}
			reader.close();
			
			if(lines.isEmpty()) throw new RuntimeException("File is empty");
			
			final IntStream.Builder builder = IntStream.builder();
			for(int line : lines) builder.add(line);
			final IntStream stream = builder.build();
			numbers = stream.toArray();
			statistics = IntStream.of(numbers).summaryStatistics();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public double getAverage() {
		return statistics.getAverage();
	}
	
	public int getHighestNumber() {
		return statistics.getMax();
	}
	
	public int getLowestNumber() {
		return statistics.getMin();
	}

}
