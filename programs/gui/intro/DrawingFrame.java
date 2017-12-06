import javax.swing.JFrame;

public class DrawingFrame {
	
	private DrawingFrame() {
		try {
			final JFrame frame = new JFrame();
			frame.setSize(500, 500);
			frame.setTitle("Drawing");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//frame.add(new RectangleComponent());
			//frame.add(new FaceComponent());
			//frame.add(new HouseComponent());
			//frame.add(new NameComponent());
			frame.add(new OlympicRingsComponent());
			frame.setVisible(true);
			Thread.sleep(1000 * 30);
			frame.setVisible(false);
			frame.dispose();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new DrawingFrame();
	}

}
