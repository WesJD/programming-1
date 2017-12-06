import java.util.Scanner;

public class Reversal {
	
	private Reversal() {
		System.out.println("Enter a word.");
		final Scanner scanner = new Scanner(System.in);
		final String input = scanner.next();
		
		for(int i=0; i<input.length(); i++) System.out.print(i + " ");
		System.out.println();
		for(char c : input.toCharArray()) System.out.print(c + " ");
		System.out.println();
		
		for(int i=input.length()-1; i>=0; i--) System.out.print(i + " ");
		System.out.println();
		for(int i=input.length()-1; i>=0; i--) System.out.print(input.charAt(i) + " ");
		System.out.println();
		
		System.out.println("The string length is " + input.length());
		scanner.close();
	}
	
	public static void main(String[] args) {
		new Reversal();
	}

}
