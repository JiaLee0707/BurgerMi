package BurgerMi_13_13;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MouseListener{	
	ImageIcon StartBasicImage = new ImageIcon("src/images/startButtonBasic.png");
	ImageIcon StartEnteredImage = new ImageIcon("src/images/startButtonEntered.png");
	ImageIcon QuitBasicImage = new ImageIcon("src/images/quitButtonBasic.png");
	ImageIcon QuitEnteredImage = new ImageIcon("src/images/quitButtonEntered.png");
	
	public MouseListener() {}

	class Listener extends MouseAdapter {
		String panel;
		ImageIcon Basic;
		ImageIcon Entered;

		public Listener(String panel, ImageIcon BasicImageIcon, ImageIcon EnteredImageIcon) {
			this.panel = panel;
			Basic = BasicImageIcon;
			Entered = EnteredImageIcon;
		}

		// �⺻��ư
		@Override
		public void mouseExited(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Basic);
		}

		// Ŭ����ư
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Entered);

			Music Button = new Music("buttonPressedMusic.mp3", false);
			Button.start();

			if (Entered.equals(QuitEnteredImage)) {	// ���� ��
				System.exit(0);
			} else if(panel.equals("Background") && Entered.equals(StartEnteredImage)) {	// Ÿ��Ʋ���� ���� ����
				Main.burgermi.JPanelChange("game");
			} else if(panel.equals("Game") && Entered.equals(StartEnteredImage)) {	// ���ӹ�� ���� ���� ����
				Main.burgermi.game.GameStart();
			}
		}

		// ��ư ���� �ø���
		@Override
		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Entered);
			button.setCursor(new Cursor(Cursor.HAND_CURSOR));

			Music Button = new Music("buttonEnteredMusic.mp3", false);
			Button.start();

		}
	}
}
