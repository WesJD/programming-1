import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberSort {
	
	private NumberSort() { 
		try {
			final List<Integer> lines = new ArrayList<>();
			final BufferedReader reader = new BufferedReader(new InputStreamReader(
					getClass().getResourceAsStream("../numbers.txt")));
			{
				String line;
				while((line = reader.readLine()) != null) lines.add(Integer.parseInt(line));
			}
			reader.close();
			
			final int[] numbers = lines.stream().mapToInt(v -> v.intValue()).toArray();
			for(int x=0; x < numbers.length-1; x++) {
				for(int i=0; i < numbers.length-1; i++) {
					final int current = numbers[i];
					final int next = numbers[i+1];
					if(current > next) {
						numbers[i] = next;
						numbers[i+1] = current;
					}
				}
			}
			System.out.println("Sorted numbers: " + Arrays.toString(numbers));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new NumberSort();
	}

}
