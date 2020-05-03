package Test;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JLabel extends JFrame {

	static ImageIcon belowBreadImage = new ImageIcon("src/images/아래빵.png");
	static JLabel label;

	public JLabel(ImageIcon belowBreadImage2) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		label = new JLabel(belowBreadImage);

	}

	public void JLabel() {
		JPanel panel = new JPanel();
		panel.add(label);
	}
}