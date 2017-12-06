import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DreamSpeechSort {
	
	private DreamSpeechSort() { 
		try {
			final List<String> lines = new ArrayList<>();
			final BufferedReader reader = new BufferedReader(new InputStreamReader(
					getClass().getResourceAsStream("../ihaveadream.txt")));
			{
				String line;
				while((line = reader.readLine()) != null) lines.add(line);
			}
			reader.close();
			
			final String[] words = lines.stream()
					                    .flatMap(line -> Arrays.stream(line.replaceAll("[.,!?���]", "").split(" ")))
					                    .toArray(size -> new String[size]);
			for(int x=0; x < words.length-1; x++) {
				for(int i=0; i < words.length-1; i++) {
					final String current = words[i];
					final String next = words[i+1];
					if(current.compareTo(next) > 0) {
						words[i] = next;
						words[i+1] = current;
					}
				}
			}
			System.out.println("Sorted words: " + Arrays.toString(words));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new DreamSpeechSort();
	}

}
