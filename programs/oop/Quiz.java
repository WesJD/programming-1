import static java.lang.System.out;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Quiz {
	
	private final Scanner SCANNER = new Scanner(System.in);
	private final Question[] questions = new Question[] {
			new Question("What is this programming language?", 2, "Scala", "Java", "C++"),
			new Question("What is an IDE?", 3, "A game", "A web browser", "An Integrated Development Environment"),
			new Question("Which IS NOT a web-based language?", 1, "Assembly", "JavaScript", "TypeScript"),
			new Question("What language is Java written in?", 2, "C#", "C", "Scala"),
			new Question("Which is NOT a statically typed language?", 2, "Haskell", "C++", "Go")
	};
	private int totalCorrect = 0;
	
	private Quiz() {
		Arrays.stream(questions).forEach(Question::ask);
		out.println("You got " + totalCorrect + "/" + questions.length + " correct.");
	}
	
	private <T> T requestTypeSafely(String prompt, Function<String, T> conversion) {
		return requestTypeSafely(prompt, conversion, false);
	}
	
	private <T> T requestTypeSafely(String prompt, Function<String, T> conversion, boolean wasInvalid) {
		try {
			System.out.println(prompt);
			System.out.print("> ");;
			return conversion.apply(SCANNER.next());
		} catch (Exception ex) {
			return requestTypeSafely((wasInvalid ? "" : "Invalid answer.\n\n") + prompt, conversion, true);
		}
	}
	
	private class Question {
		
		private final String question;
		private final String[] answers;
		private final int correctAnswer;
		
		public Question(String question, int correctAnswer, String... answers) {
			this.question = question;
			this.answers = answers;
			this.correctAnswer = correctAnswer;
		}
		
		public void ask() {
			final StringBuilder sb = new StringBuilder();
			sb.append(question).append("\n");
			for(int i=0; i<answers.length; i++) sb.append(i+1).append(". ").append(answers[i]).append("\n");
			final int answer = requestTypeSafely(sb.toString(), Integer::parseInt);
			if(correctAnswer == answer) {
				out.println("Correct!");
				totalCorrect++;
			} else out.println("Incorrect. The correct answer is #" + correctAnswer);
			out.println("-----------------------------");
		}
		
	}
	
	public static void main(String[] args) {
		new Quiz();
	}

}
