package BurgerMi_15_15;

import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;

import BurgerMi_15_15.MouseListener.NextButton;

public class End {

	KeyListener keyListener = Main.burgermi.game.keyListener;
	Burger burger = Main.burgermi.game.keyListener.burger;

	// 버튼
	MouseListener mouse = new MouseListener();
	private JButton replayBtn = new JButton(mouse.ReplayBasicImage);
//	private JButton QuitBtn = new JButton(mouse.QuitBasicImage);

	public JLabel GameResult = new JLabel("게임 결과");
	public Font font1 = new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 40);
	public Font font2 = new Font("나눔스퀘어라운드 Light", Font.PLAIN, 40);
	public JLabel myResult = new JLabel("나의 결과");
	public JLabel allGrade = Main.burgermi.game.score.scoreLabel;

//	JLabel[][] rankLable = new JLabel[5][3];
	LinkedList<String[]> ranking;
	int i=0;
	
	End(JLabel time) {
		this.burger.MakeBurgerIntArray.clear();
		this.burger.burgerIngredient.clear(); // = new LinkedList<Object>();
		this.burger.i.clear();

		Main.burgermi.game.removeKeyListener(keyListener);
		Main.burgermi.game.start = false;
		Main.burgermi.game.gameMusic.close();

		Ranking ranking = new Ranking();
		ranking.Ranking(5, ranking);
		
		// 시간 안보이기
		time.setVisible(false);
		
		End();

		GameResult.setFont(Main.burgermi.game.score.font);
		myResult.setFont(font1);
		allGrade.setFont(font1);
	}

	public void End() {

		GameResult.setBounds(530, -300, 800, 800);
		myResult.setBounds(290, 80, 800, 800);
		allGrade.setBounds(290, 140, 800, 800);
		Main.burgermi.game.add(GameResult);
		Main.burgermi.game.add(myResult);

		// 다시시작 버튼
		replayBtn.setBounds(915, 560, 340, 120);
		replayBtn.setBorderPainted(false);
		replayBtn.setContentAreaFilled(false);
		replayBtn.setFocusPainted(false);
		replayBtn.addMouseListener(mouse.new Listener("End", mouse.ReplayBasicImage, mouse.ReplayEnteredImage));
		replayBtn.setVisible(true);
		Main.burgermi.game.add(replayBtn);
		
		// 종료버튼
//		QuitBtn.setBounds(630, 470, 340, 120);
//		QuitBtn.setBorderPainted(false);
//		QuitBtn.setContentAreaFilled(false);
//		QuitBtn.setFocusPainted(false);
//		QuitBtn.addMouseListener(mouse.new Listener("End", mouse.QuitBasicImage, mouse.QuitEnteredImage));
//		QuitBtn.setVisible(true);
//		Main.burgermi.game.add(QuitBtn);

	}
}