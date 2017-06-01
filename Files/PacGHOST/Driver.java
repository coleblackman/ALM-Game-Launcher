import javax.swing.JFrame;

public class Driver {
	public static void main(String[] args) {
		JFrame frame = new JFrame("PACGHOST");
		frame.setSize(1000, 1000);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PanelPac p = new PanelPac();
		frame.setContentPane(p);
		p.requestFocus();
		frame.setUndecorated(true);
		frame.setVisible(true);
	}

}