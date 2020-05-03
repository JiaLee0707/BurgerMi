package Test;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test extends JFrame {
	Panel p = new Panel();

	Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(p);
		setVisible(true);
	}

	public static void main(String[] args) {
		Test test = new Test();
	}

	class Panel extends JPanel {
		Panel() {
			JLabel label = new JLabel("Panel 1");
			JButton but = new JButton("Frame");
			but.addMouseListener(new MouseListener());
			add(label);
			add(but);
		}

		class MouseListener extends MouseAdapter {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton button = (JButton) e.getSource();
				button.setVisible(false);
				e ee = new e();
				setContentPane(ee);
			}
		}
	}
}

class e extends JPanel {
	e() {
		JLabel label = new JLabel("Panel 2");
		add(label);
	}
}