import javax.swing.JOptionPane;


public class TelephoneNumber {
	
	private TelephoneNumber() {
		final String input = JOptionPane.showInputDialog("What is the company's telephone number?").toUpperCase();
		final StringBuilder sb = new StringBuilder();
		for(char c : input.toCharArray()) {
			try {
				sb.append(Integer.parseInt(Character.toString(c)));
			} catch (NumberFormatException ex) {
				switch(c) {
					case 'A':
					case 'B':
					case 'C':
						sb.append(2);
						break;
					case 'D':
					case 'E':
					case 'F':
						sb.append(3);
						break;
					case 'G':
					case 'H':
					case 'I':
						sb.append(4);
						break;
					case 'J':
					case 'K':
					case 'L':
						sb.append(5);
						break;
					case 'M':
					case 'N':
					case 'O':
						sb.append(6);
						break;
					case 'P':
					case 'Q':
					case 'R':
					case 'S':
						sb.append(7);
						break;
					case 'T':
					case 'U':
					case 'V':
						sb.append(8);
						break;
					case 'W':
					case 'X':
					case 'Y':
					case 'Z':
						sb.append(9);
						break;
					default:
						sb.append(c);
						break;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "The phone number of " + input + " is equal to " + sb.toString());
	}
	
	public static void main(String[] args) {
		new TelephoneNumber();
	}
}
