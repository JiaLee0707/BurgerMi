package BurgerMi_15_15;

import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;

import BurgerMi_15_15.MouseListener.Listener;

public class Ranking {

	MouseListener mouse = new MouseListener();
	private JButton NextBut = new JButton(mouse.NextBasicImage);


	public JLabel rank = new JLabel("순위                       이름                     점수");
	public Font font1 = new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 40);
	public Font font2 = new Font("나눔스퀘어라운드 Light", Font.PLAIN, 40);

	JLabel[][] rankLable;
	LinkedList<String[]> ranking;
	int i = 0;

	Ranking(int n) {
		// DB 점수 추가
		DB db = new DB();
		db.Insert(Main.burgermi.game.score.score);
		ranking = db.Select();

		Button(n);

		rank.setBounds(290, -330, 1000, 1000);
		Main.burgermi.game.add(rank);
		rank.setFont(font1);
		

		rankLable = new JLabel[n][3];

		int y = -280;
		for (i = 0; i < n; i++) {
			int x = 310;
//			System.out.println(ranking.get(i)[2]);
			if (i == ranking.size()) {
				break;
			}
			for (int j = 0; j < rankLable[i].length; j++) {
				rankLable[i][j] = new JLabel(ranking.get(i)[j]);
				rankLable[i][j].setBounds(x, y, 1000, 1000);
				rankLable[i][j].setFont(font2);
				if (ranking.get(i)[1].equals(db.name)
						&& ranking.get(i)[2].equals(Integer.toString(Main.burgermi.game.score.score))) {
					System.out.println("동일");
					rankLable[i][j].setFont(font1);
				}
				Main.burgermi.game.add(rankLable[i][j]);
				x += 280;
			}
			y += 50;
		}

		Main.burgermi.game.end = true;
		Main.burgermi.game.getParent().repaint();
	}

	public void Button(int n) {
		if(n==5) {
			NextBut.setBounds(865, 280, 340, 120);			
		} else {
			NextBut.setBounds(915, 560, 340, 120);						
		}
		
		// 다시시작 버튼
		NextBut.setBorderPainted(false);
		NextBut.setContentAreaFilled(false);
		NextBut.setFocusPainted(false);
		NextBut.addMouseListener(mouse.new NextButton(mouse.NextBasicImage, mouse.NextEnteredImage));
		NextBut.setVisible(true);
		Main.burgermi.game.add(NextBut);
		
	}
}
