import javax.swing.JFrame;

public class CarViewer {

	public CarViewer() {
		final JFrame frame = new JFrame();
		frame.setTitle("Car Viewer");
		frame.setSize(750, 750);
		frame.add(new CarComponent());
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new CarViewer();
	}

}
