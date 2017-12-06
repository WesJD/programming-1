import java.util.function.Function;

import javax.swing.JOptionPane;

public class TestScores {
	
	private TestScores() {
		final double score1 = requestTypeSafely("What is your first test score?", Double::parseDouble);
		final double score2 = requestTypeSafely("What is your second test score?", Double::parseDouble);
		final double score3 = requestTypeSafely("What is your third test score?", Double::parseDouble);
		
		final double average = (score1 + score2 + score3) / 3;
		char letterGrade = 'X';
		if(average < 60) letterGrade = 'F';
		else if(average <= 69) letterGrade = 'D';
		else if(average <= 79) letterGrade = 'C';
		else if(average <= 89) letterGrade = 'B';
		else letterGrade = 'A';
		
		JOptionPane.showMessageDialog(null, 
				"The average was " + average + " which is the letter grade of '" + letterGrade + "'", 
				"Response", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private <T> T requestTypeSafely(String prompt, Function<String, T> conversion) {
		try {
			return conversion.apply(JOptionPane.showInputDialog(prompt));
		} catch (Exception ex) {
			return requestTypeSafely("Invalid answer. " + prompt, conversion);
		}
	}
	
	public static void main(String[] args) {
		new TestScores();
	}

}
