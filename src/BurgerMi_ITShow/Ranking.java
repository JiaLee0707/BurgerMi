package BurgerMi_ITShow;

import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Ranking {

	Ranking ranking;
	DB db;
	MouseListener mouse = new MouseListener();
	public JButton rightNextBut = new JButton(mouse.rightNextBasicImage);
	public JButton leftNextBut = new JButton(mouse.leftNextBasicImage);

//	public JLabel rank = new JLabel("순위                    이름                        점수");
//	public Font font1 = new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 40);
//	public Font font2 = new Font("나눔스퀘어라운드 Light", Font.PLAIN, 40);

	public Font font_1 = new Font("HY얕은샘물M", Font.PLAIN, 50);
	public Font font_2 = new Font("HY얕은샘물M", Font.BOLD, 1000);

	JLabel[][] rankLable;
	LinkedList<String[]> rankingList;
	int i, n = 0, count = 0;

	public int getI() {
//		System.out.println("i : " + i);
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public void Ranking(int n, Ranking ranking) {
		this.n = n;
		this.ranking = ranking;
		
		// DB 점수 추가
		db = new DB();
		db.Insert(Main.burgermi.game.sales.sales);
		rankingList = db.Select();
		count = rankingList.size();
		
	/*	rank.setBounds(310, -330, 1000, 1000);
		Main.burgermi.game.add(rank);
		rank.setFont(font1);*/
		

		rankLable = new JLabel[n][3];

		int y = -280;
		for (i = 0; i < n; i++) {
			int x = 150;
//			System.out.println(ranking.get(i)[2]);
			if (i == rankingList.size()) {
				break;
			}
			for (int j = 0; j < rankLable[i].length; j++) {
				rankLable[i][j] = new JLabel(rankingList.get(i)[j]);
				rankLable[i][j].setBounds(x, y, 1000, 1000);
				rankLable[i][j].setFont(font_1);
				if (rankingList.get(i)[0].equals(db.name)
						&& rankingList.get(i)[1].equals(Integer.toString(Main.burgermi.game.sales.sales))) {
					System.out.println("동일");
					rankLable[i][j].setFont(font_2);
				} else {
					rankLable[i][j].setFont(font_1);
				}
				Main.burgermi.game.add(rankLable[i][j]);
				x += 460;
			}
			y += 60;
		}



		Button(n);
//		System.out.println("ranking i : " + i);
		Main.burgermi.game.end = true;
		Main.burgermi.game.getParent().repaint();
	}

	public void Button(int n) {
	
		// 버튼 위치
		if(n==5) {
			rightNextBut.setBounds(1120, 280, 80, 80);			
			leftNextBut.setBounds(50, 280, 80, 80);			
		} else {
			rightNextBut.setBounds(1120, 560, 340, 120);						
			leftNextBut.setBounds(50, 560, 340, 120);						
		}
		
		MouseListener.rightNextButton right = mouse.new rightNextButton(ranking, mouse.rightNextBasicImage, mouse.rightNextEnteredImage);
		MouseListener.leftNextButton left = mouse.new leftNextButton(ranking, mouse.leftNextBasicImage, mouse.leftNextEnteredImage);
		
		
		// 오른쪽 버튼
		rightNextBut.setBorderPainted(false);
		rightNextBut.setContentAreaFilled(false);
		rightNextBut.setFocusPainted(false);
		rightNextBut.addMouseListener(right);
		if(count > 5) {
			rightNextBut.setVisible(true);			
		} else {
			rightNextBut.setVisible(false);			
		}
		Main.burgermi.game.add(rightNextBut);
		
		// 왼쪽 버튼
		leftNextBut.setBorderPainted(false);
		leftNextBut.setContentAreaFilled(false);
		leftNextBut.setFocusPainted(false);
		leftNextBut.addMouseListener(left);
		leftNextBut.setVisible(false);
		Main.burgermi.game.add(leftNextBut);
	}
	
}