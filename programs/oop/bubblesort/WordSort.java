import static java.lang.System.out;

import java.util.Arrays;

public class WordSort {
	
	private final String THE_SENTENCE = "Hello there, Sean Mitchell. I love you.";
	
	private WordSort() {
		final String[] words = THE_SENTENCE.replaceAll("[.,!?]", "").split(" ");
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
		out.println("Sorted lexicographically:");
		out.println(Arrays.toString(words));
	}
	
	public static void main(String[] args) {
		new WordSort();
	}

}
