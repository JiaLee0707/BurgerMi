package Test;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Key extends JFrame {
	public Key() {
		JPanel p = new JPanel();
		setVisible(true);
		p.addKeyListener(new Listener());
	}

	class Listener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			System.out.println(e.getKeyCode());
			if (e.getKeyCode() == KeyEvent.VK_A) {
				System.out.println("asdf");
			}
		}
	}

	public static void main(String ar[]) {
		Key key = new Key();
	}
}