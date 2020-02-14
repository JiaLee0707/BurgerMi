package BurgerMi_11_11;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MouseListener{	
	ImageIcon StartBasicImage = new ImageIcon("src/images/startButtonBasic.png");
	ImageIcon StartEnteredImage = new ImageIcon("src/images/startButtonEntered.png");
	ImageIcon QuitBasicImage = new ImageIcon("src/images/quitButtonBasic.png");
	ImageIcon QuitEnteredImage = new ImageIcon("src/images/quitButtonEntered.png");
	
	public MouseListener() {}

	class Listener extends MouseAdapter {
		public BurgerMi burgermi;
		ImageIcon Basic;
		ImageIcon Entered;

		public Listener(BurgerMi burgermi, ImageIcon BasicImageIcon, ImageIcon EnteredImageIcon) {
			this.burgermi = burgermi;
			Basic = BasicImageIcon;
			Entered = EnteredImageIcon;
		}

		// 기본버튼
		@Override
		public void mouseExited(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Basic);
		}

		// 클릭버튼
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Entered);

			Music Button = new Music("buttonPressedMusic.mp3", false);
			Button.start();

			if (Entered.equals(QuitEnteredImage)) {
				System.exit(0);
			} else {
				burgermi.JPanelChange("game");
			}

		}

		// 버튼 위에 올리면
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
