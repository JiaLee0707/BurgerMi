package BurgerMi_14_14;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class End {

	Image EndGame = new ImageIcon("src/images/EndGame.png").getImage();

	// ���ӽ��� ��ư
	MouseListener mouse = new MouseListener();
	private JButton replayBtn = new JButton(mouse.ReplayBasicImage);
	private JButton QuitBtn = new JButton(mouse.QuitBasicImage);

	public JLabel allGrade = Main.burgermi.game.score.scoreLabel;

	End(JLabel time) {
		Main.burgermi.game.start = false;
		Main.burgermi.game.ImageBackground = EndGame;
		Main.burgermi.game.gameMusic.close();
		time.setVisible(false);
		allGrade.setBounds(540, -100, 800, 800);

		// �ٽý��� ��ư
		replayBtn.setBounds(280, 470, 340, 120);
		replayBtn.setBorderPainted(false);
		replayBtn.setContentAreaFilled(false);
		replayBtn.setFocusPainted(false);
		replayBtn.addMouseListener(mouse.new Listener("End", mouse.ReplayBasicImage, mouse.ReplayEnteredImage));
		replayBtn.setVisible(true);
		Main.burgermi.game.add(replayBtn);

		// �����ư
		QuitBtn.setBounds(630, 470, 340, 120);
		QuitBtn.setBorderPainted(false);
		QuitBtn.setContentAreaFilled(false);
		QuitBtn.setFocusPainted(false);
		QuitBtn.addMouseListener(mouse.new Listener("End", mouse.QuitBasicImage, mouse.QuitEnteredImage));
		QuitBtn.setVisible(true);
		Main.burgermi.game.add(QuitBtn);

		Main.burgermi.game.getParent().repaint();

	}
}