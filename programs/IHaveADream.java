import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.out;

public class IHaveADream {
	
	private final char[] UNCOUNTED_CHARACTERS = {
			'.',
			'!',
			'"',
			'?'
	};
	
	private IHaveADream() {
		try {
			final BufferedReader reader = new BufferedReader(new InputStreamReader(
					getClass().getResourceAsStream("ihaveadream.txt")));
			final StringBuilder sb = new StringBuilder();
			String nextLine;
			while((nextLine = reader.readLine()) != null) sb.append(" ").append(nextLine);
			final String speech = sb.toString();
			
			out.println("I Have a Dream by Martin Luther King Jr.");
			out.println("----------------------------------------");
			out.println(speech);
			out.println("----------------------------------------");
			
			int wordCount = 0;
			String longestWord = "";
			for(String word : speech.split(" ")) {
				wordCount++;
				final String cleaned = removeUncounted(word);
				if(cleaned.length() > longestWord.length()) longestWord = cleaned;
			}
			out.println("The longest word is \"" + longestWord + "\".");
			out.println("The total word count is: " + wordCount);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private String removeUncounted(String str) {
		String ret = str;
		for(char c : UNCOUNTED_CHARACTERS) ret = ret.replace(Character.toString(c), "");
		return ret;
	}
	
	public static void main(String[] args) {
		new IHaveADream();
	}

}
