package BurgerMi_ITShow;

import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JLabel;

public class Score {
	Order order;
	Make burger;

	int score = 0;
	int scoreArray[] = { 10, 20, -5 };
	public JLabel scoreLabel = new JLabel(score + "점");
	Music musicOX;

	public Font font = new Font("나눔스퀘어라운드 ExtraBold", Font.ITALIC, 50);
	
	public Score() {
		scoreLabel.setFont(font); // 폰트 설정
		scoreLabel.setSize(500, 500); // 크키 설정
		scoreLabel.setLocation(1160, -150); // 위치 설정
		Main.burgermi.game.add(scoreLabel);
	}

	public void Score() {
		order = Main.burgermi.game.order;
		burger = Main.burgermi.game.keyListener.burger;

		boolean OX = Discriminate();

		// 점수 계산
		if (OX == true) {
			musicOX = new Music("tpir-sdclock.mp3", false);
			if (order.who != 4) {
				score += scoreArray[0];
				System.out.println("성공");
			} else {
				score += scoreArray[1];
				System.out.println("진상 성공");
			}
		} else {
			musicOX = new Music("띠-으-으.mp3", false);
			System.out.println("실패");
			if (order.who == 4) {
				score += scoreArray[2];
				System.out.println("진상 실패");
			}
		}
		musicOX.start();

		if(score > 0 || score < 0) {
			scoreLabel.setLocation(1140, -150); // 위치 설정
		} else if(score >= 100) {
			scoreLabel.setLocation(1130, -150); // 위치 설정
		}
		scoreLabel.setText(score + "점");

		// this.burger.MakeBurgerObjectArray.clear();
		this.burger.MakeBurgerIntArray.clear();
		this.burger.burgerIngredient.clear(); // = new LinkedList<Object>();
		this.burger.i.clear();
//		this.burger.burgerIngredient.add(null);
//		this.burger.burgerIngredient.add(0);
//		this.burger.burgerIngredient.add(0);
		order.orderBurgerArray = new int[5];
		;

		if (order.who == 4) {
			Throw th = new Throw();
			th.start();
		} else {
			Main.burgermi.game.order = new Order();
			Main.burgermi.game.ReGame();
		}
//		Main.burgermi.game.revalidate();
//		Main.burgermi.game.repaint();
		Main.burgermi.game.getParent().repaint();
	}

	public boolean Discriminate() {
		boolean OX = true;

		int orderSize = Main.burgermi.game.order.orderBurgerArray.length;
		int makeSize = Main.burgermi.game.keyListener.burger.MakeBurgerIntArray.size();

		System.out.println("\n\n\n\n\n" + orderSize + " " + makeSize);

		// 버거 사이즈 비교
		if (orderSize != makeSize) {
			OX = false;
		} else {
			// 버거 재료 비교
			for (int i = 0; i < orderSize; i++) {
				System.out.println(Main.burgermi.game.order.orderBurgerArray[i] + "----"
						+ Main.burgermi.game.keyListener.burger.MakeBurgerIntArray.get(i));
				// 버거 재료가 다르면
				if (Main.burgermi.game.order.orderBurgerArray[i] != Main.burgermi.game.keyListener.burger.MakeBurgerIntArray
						.get(i)) {
					OX = false;
					break;
				}
			}
		}

		return OX;
	}

}