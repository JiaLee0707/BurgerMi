package BurgerMi__99;

import java.util.List;

public class Score {
	int score = 0;
	boolean Enter = false;

	public void Score() {
		int size = 0, i = 0;

		// 점수 계산
		while (true) {
			if (size == BurgerMi.game.order.orderBurger.size()) {
				Music OX = new Music("tpir-sdclock.mp3", true);
				OX.start();

				if (BurgerMi.game.order.obnoxious == 4) {
					score += 20;
				} else {
					score += 10;
				}
				BurgerMi.game.grade.setText(score + "점");
				System.out.println("성공");
				break;
			} else if ((BurgerMi.game.order.MakeBurger.size() != BurgerMi.game.order.orderBurger.size())
					|| (((List<Object>) BurgerMi.game.order.orderBurger.get(i))
							.get(0) != ((List<Object>) BurgerMi.game.order.MakeBurger.get(i)).get(0))) {
				Music OX = new Music("띠-으-으.mp3", false);
				OX.start();
				if(BurgerMi.game.order.obnoxious == 4) {
					score -= 5;
				}
				BurgerMi.game.grade.setText(score + "점");
				System.out.println("실패");
				break;
			} else if (((List<Object>) BurgerMi.game.order.orderBurger.get(i))
					.get(0) == ((List<Object>) BurgerMi.game.order.MakeBurger.get(i)).get(0)) {
				size++;
			}
			i++;
		}

		// 주문버거, 만든버거 clear
		BurgerMi.game.order.orderBurger.clear();
		BurgerMi.game.order.MakeBurger.clear();

		System.out.println("");

//		if (BurgerMi.game.order.obnoxious == 4) {
//			Enter = true;
//		}
		
		if(BurgerMi.game.order.obnoxious==4) {
			Throw th = new Throw();
			th.start();
		}
		else {
			BurgerMi.game.order = new Order();
			BurgerMi.game.order.start();
		}
		
		// 화면 다시그리기
		BurgerMi.game.revalidate();
		BurgerMi.game.repaint();

		System.out.println("Order");
		for (i = 0; i < BurgerMi.game.order.orderBurger.size(); i++) {
			System.out.println(BurgerMi.game.order.orderBurger.get(i));
		}
		System.out.println("");

		System.out.println("");

	}

}