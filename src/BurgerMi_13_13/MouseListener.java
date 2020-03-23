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

			if (Entered.equals(QuitEnteredImage)) {	// 게임 끝
				System.exit(0);
			} else if(panel.equals("Background") && Entered.equals(StartEnteredImage)) {	// 타이틀에서 게임 시작
				Main.burgermi.JPanelChange("game");
			} else if(panel.equals("Game") && Entered.equals(StartEnteredImage)) {	// 게임방법 이후 게임 시작
				Main.burgermi.game.GameStart();
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
