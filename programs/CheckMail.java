import java.util.Arrays;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import static java.lang.Integer.parseInt;

public class CheckMail {
	
	private final Pattern DIMENSIONS_PATTERN = Pattern.compile("\\d+x\\d+x\\d+");
	
	private CheckMail() {
		final double weight = requestTypeSafely("What is the package weight?", Double::parseDouble);
		final MailPackage pkg = requestTypeSafely("What are the demensions? (LxHxW)", (input) -> parsePackage(weight, input));
		
		final StringBuilder sb = new StringBuilder("Package is ");
		if(pkg.isWeightAcceptable() && pkg.isSizeAcceptable()) sb.append("acceptable");
		else if(!pkg.isWeightAcceptable() && !pkg.isSizeAcceptable()) sb.append("too large and too heavy");
		else if(!pkg.isWeightAcceptable()) sb.append("too heavy");
		else sb.append("too large");
		
		JOptionPane.showMessageDialog(null, sb.append(".").toString(), "Response", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private MailPackage parsePackage(double weight, String input) {
		final Matcher matcher = DIMENSIONS_PATTERN.matcher(input);
		if(matcher.find()) {
			final String[] split = matcher.group(0).split("x");
			return new MailPackage(weight, parseInt(split[0]), parseInt(split[1]), parseInt(split[2]));
		} else throw new RuntimeException("Not valid LxHxW input.");
	}
	
	private <T> T requestTypeSafely(String prompt, Function<String, T> conversion) {
		return requestTypeSafely(prompt, conversion, false);
	}
	
	private <T> T requestTypeSafely(String prompt, Function<String, T> conversion, boolean wasInvalid) {
		try {
			return conversion.apply(JOptionPane.showInputDialog(prompt));
		} catch (Exception ex) {
			ex.printStackTrace();
			return requestTypeSafely((wasInvalid ? "" : "Invalid answer.\n\n") + prompt, conversion, true);
		}
	}
	
	public static void main(String[] args) {
		new CheckMail();
	}
	
	private static class MailPackage {
		
		private final double weight, dim1, dim2, dim3, girth, length;
		
		public MailPackage(double weight, double dim1, double dim2, double dim3) {
			this.weight = weight;
			this.dim1 = dim1;
			this.dim2 = dim2;
			this.dim3 = dim3;
			
			final double[] sort = new double[] { dim1, dim2, dim3 };
			Arrays.sort(sort);
			this.girth = (sort[0]*2 + sort[1]*2);
			this.length = sort[2];
		}
		
		public double getWeight() {
			return weight;
		}
		
		public double getDimension1() {
			return dim1;
		}
		
		public double getDimension2() {
			return dim2;
		}
		
		public double getDimension3() {
			return dim3;
		}
		
		public double getGirth() {
			return girth;
		}
		
		public double getLength() {
			return length;
		}
		
		public boolean isWeightAcceptable() {
			return (weight <= 70);
		}
		
		public boolean isSizeAcceptable() {
			return (girth + length <= 100);
		}
		
	}
	
}
