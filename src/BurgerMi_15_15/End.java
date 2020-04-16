package BurgerMi_15_15;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class End {

	Image EndGame = new ImageIcon("src/images/EndGame.png").getImage();

	KeyListener keyListener = Main.burgermi.game.keyListener;
	Burger burger = Main.burgermi.game.keyListener.burger;
	
	// 게임시작 버튼
	MouseListener mouse = new MouseListener();
	private JButton replayBtn = new JButton(mouse.ReplayBasicImage);
	private JButton QuitBtn = new JButton(mouse.QuitBasicImage);

	public JLabel allGrade = Main.burgermi.game.score.scoreLabel;

	End(JLabel time) {
		this.burger.MakeBurgerIntArray.clear();
		this.burger.burgerIngredient.clear(); // = new LinkedList<Object>();
		this.burger.i.clear();
		
		Main.burgermi.game.removeKeyListener(keyListener);
		Main.burgermi.game.start = false;
		Main.burgermi.game.gameMusic.close();
		Main.burgermi.game.ImageBackground = EndGame;
		
		DB db = new DB();
		
		time.setVisible(false);
		allGrade.setBounds(540, -100, 800, 800);

		// 다시시작 버튼
		replayBtn.setBounds(280, 470, 340, 120);
		replayBtn.setBorderPainted(false);
		replayBtn.setContentAreaFilled(false);
		replayBtn.setFocusPainted(false);
		replayBtn.addMouseListener(mouse.new Listener("End", mouse.ReplayBasicImage, mouse.ReplayEnteredImage));
		replayBtn.setVisible(true);
		Main.burgermi.game.add(replayBtn);

		// 종료버튼
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