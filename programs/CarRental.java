import javax.swing.JOptionPane;

public class CarRental {
	
	private CarRental() {
		final String make = JOptionPane.showInputDialog("What is the car make?");
		final String model = JOptionPane.showInputDialog("What is the car model?");
		final String licensePlate = JOptionPane.showInputDialog("What is the license plate value?");
		
		final int digits = Integer.parseInt(licensePlate.substring(4));
		int charTotal = 0;
		for(char c :  licensePlate.substring(0, 3).toCharArray()) charTotal += c;
		
		final int sum = digits + charTotal;
		final char letter = (char) ('A' + (sum % 26));

		JOptionPane.showMessageDialog(null, 
				"Make = " + make + "\nModel = " + model + "\n" + licensePlate + " = " + letter + "" + sum);
	}
	
	public static void main(String[] args) {
		new CarRental();
	}

}
