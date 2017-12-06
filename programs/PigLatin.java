import javax.swing.JOptionPane;


public class PigLatin {
	
	private PigLatin() {
		final String input = JOptionPane.showInputDialog("What is your sentence?").toUpperCase();
		final StringBuilder sb = new StringBuilder();
		for(String word : input.split(" ")) sb.append(word.substring(1)).append(word.charAt(0)).append("AY ");
		JOptionPane.showMessageDialog(null, "In Pig Latin, that is:\n " + sb.toString());
	}
	
	public static void main(String[] arg) {
		new PigLatin();
	}

}
