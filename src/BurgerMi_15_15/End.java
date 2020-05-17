package BurgerMi_15_15;

import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;

public class End {

	KeyListener keyListener = Main.burgermi.game.keyListener;
	Burger burger = Main.burgermi.game.keyListener.burger;

	// 게임시작 버튼
	MouseListener mouse = new MouseListener();
	private JButton replayBtn = new JButton(mouse.ReplayBasicImage);
	private JButton QuitBtn = new JButton(mouse.QuitBasicImage);

	public JLabel GameResult = new JLabel("게임 결과");
	public JLabel rank = new JLabel("이름                       점수                       순위");
	public Font font = new Font("나눔스퀘어라운드 Light", Font.PLAIN, 40);
	public JLabel allGrade = Main.burgermi.game.score.scoreLabel;

	JLabel[] rankLable = new JLabel[5];
	LinkedList<String[]> ranking;
	
	End(JLabel time) {
		this.burger.MakeBurgerIntArray.clear();
		this.burger.burgerIngredient.clear(); // = new LinkedList<Object>();
		this.burger.i.clear();

		Main.burgermi.game.removeKeyListener(keyListener);
		Main.burgermi.game.start = false;
		Main.burgermi.game.gameMusic.close();
		Main.burgermi.game.end = true;

		// 시간 안보이기
		time.setVisible(false);

		GameResult.setFont(Main.burgermi.game.score.font);
		rank.setFont(font);
		
		Ranking();
		End();

	}

	public void End() {

//		// 랭킹
//		Ranking ranking = new Ranking();

		GameResult.setBounds(530, -270, 800, 800);
		rank.setBounds(290, -290, 1000, 1000);
		allGrade.setBounds(1000, -270, 800, 800);
		Main.burgermi.game.add(GameResult);
		Main.burgermi.game.add(rank);

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
	
	public void Ranking() {
		// DB 점수 추가
		DB db = new DB();
		db.Insert(Main.burgermi.game.score.score);
		ranking = db.Select();
		
		int y=-240;
//		ranking.add(rankList);
		for(int i=0; i<rankLable.length; i++) {
//			System.out.println(ranking.get(i)[2]);
			if(i == ranking.size()) {
				break;
			}
			rankLable[i] = new JLabel((ranking.get(i))[1] + "                   " + (ranking.get(i))[0] + "                           " + (ranking.get(i))[2]);
			
			
			System.out.println(rankLable[i].getText().length());
			rankLable[i].setBounds(290, y, 1000, 1000);
			rankLable[i].setFont(font);
			Main.burgermi.game.add(rankLable[i]);
			y += 40;
		}
		
	}
}