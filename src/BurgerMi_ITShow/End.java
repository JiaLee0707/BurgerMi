package BurgerMi_ITShow;

import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;

public class End {

	KeyListener keyListener = Main.burgermi.game.keyListener;
	Make make = Main.burgermi.game.keyListener.make;

	// 버튼
	MouseListener mouse = new MouseListener();
	private JButton replayBtn = new JButton(mouse.ReplayBasicImage);
//	private JButton QuitBtn = new JButton(mouse.QuitBasicImage);


	public Font font = new Font("HY얕은샘물M", Font.PLAIN, 40);
//	public Font font2 = new Font("나눔스퀘어라운드 Light", Font.PLAIN, 40);
	public JLabel allGrade = Main.burgermi.game.sales.salesLabel;

	LinkedList<String[]> ranking;
	int i=0;
	
	End() {
		this.make.MakeInformation.clear();
		this.make.MakeOrderSheetArray.clear();
		this.make.MakeBurgerArray.clear();
		this.make.i.clear();

		Main.burgermi.game.removeKeyListener(keyListener);
		Main.burgermi.game.start = false;
		Main.burgermi.game.gameMusic.close();

		Ranking ranking = new Ranking();
		ranking.Ranking(5, ranking);
		
		End();

		allGrade.setFont(font);
	}

	public void End() {

//		GameResult.setBounds(530, -300, 800, 800);
//		myResult.setBounds(290, 80, 800, 800);
		allGrade.setBounds(290, 140, 800, 800);
//		Main.burgermi.game.add(GameResult);
//		Main.burgermi.game.add(myResult);

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