package BurgerMi_13_13;

import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JLabel;

public class Score {
	Order order;
	Burger burger;
	private Order.Guest guest;

	int score = 0;
	int scoreArray[] = { 10, 20, -5 };
	public JLabel scoreLabel = new JLabel(score + "점");
	Music musicOX;

	Score(Order order) {
		this.order = order;
		guest  = order.new Guest();
		scoreLabel.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.ITALIC, 50)); // 폰트 설정
		scoreLabel.setSize(500, 500); // 크키 설정
		scoreLabel.setLocation(1160, -150); // 위치 설정
		Main.burgermi.game.add(scoreLabel);
	}
	public void Score(Burger burger) {
		this.burger = burger;
		
		boolean OX = Discriminate();
		
		//점수 계산
		if(OX == true) {
			musicOX = new Music("tpir-sdclock.mp3", false);
			if(order.who == 4) {
				score += scoreArray[1];
			} else score += scoreArray[0];
		} else {
			musicOX = new Music("띠-으-으.mp3", false);
			if(order.who == 4) {
				score += scoreArray[2];
			}
		}
		musicOX.start();
		
		scoreLabel.setText(score + "점");
//		Main.burgermi.game.getParent().repaint();
		
		this.burger.MakeBurgerObjectArray.clear();
		this.burger.MakeBurgerIntArray.clear();
		this.burger.burgerIngredient = new LinkedList<Object>();
		this.burger.burgerIngredient.add(null);
		this.burger.burgerIngredient.add(0);
		this.burger.burgerIngredient.add(0);
		order.orderBurgerArray = new int[5];;
		
		Main.burgermi.game.order = new Order();
		Main.burgermi.game.ReGame();
//		Main.burgermi.game.revalidate();
//		Main.burgermi.game.repaint();
		Main.burgermi.game.getParent().repaint();
	}

	public boolean Discriminate() {
		boolean OX = true;
		
		int orderSize = order.orderBurgerArray.length;
		int makeSize = burger.MakeBurgerIntArray.size();

		System.out.println("\n\n\n\n\n" + orderSize + " " + makeSize);

		// 버거 사이즈 비교
		if (orderSize != makeSize) {
			OX = false;
		} else {
			// 버거 재료 비교
			for (int i = 0; i < orderSize; i++) {
				System.out.println(order.orderBurgerArray[i] + "----" + burger.MakeBurgerIntArray.get(i));
				// 버거 재료가 다르면
				if (order.orderBurgerArray[i] != burger.MakeBurgerIntArray.get(i)) {
					OX = false;
					break;
				}
			}
		}
		
		return OX;
	}

}
