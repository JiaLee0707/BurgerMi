package BurgerMi_11_11;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MouseListener extends MouseAdapter{
	ImageIcon Basic;
	ImageIcon Entered;

	public MouseListener(ImageIcon BasicImageIcon, ImageIcon EnteredImageIcon) {
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

		if (Entered.equals(QuitEnteredImage)) {
			System.exit(0);
		}

		background.setVisible(false);
		game = new Game();
		setContentPane(game);
		game.Game();
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
