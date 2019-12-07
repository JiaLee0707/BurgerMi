package BurgerMi__99;

import java.util.List;

public class Score {
//	boolean Enter = false;
	int score = 0;

	public void Score() {
		int count = 0;

		// 점수 계산
		while (true) {
			// 버거 size가 같으면 (성공)
			if (count == BurgerMi.game.order.orderBurger.size()) {
				Music OX = new Music("tpir-sdclock.mp3", false);
				OX.start();

				// 진상손님이면 점수 +20
				if (BurgerMi.game.order.obnoxious == 4) {
					score += 20;
				} 
				// 일반손님이면 점수 +10
				else {
					score += 10;
				}
				BurgerMi.game.grade.setText(score + "점");
				System.out.println("성공");
				break;
			} 
			// 주문 버거와 만든 버거가 다르면
			// size, 재료
			else if ((BurgerMi.game.order.MakeBurger.size() != BurgerMi.game.order.orderBurger.size())
					|| (((List<Object>) BurgerMi.game.order.orderBurger.get(count))
							.get(0) != ((List<Object>) BurgerMi.game.order.MakeBurger.get(count)).get(0))) {
				Music OX = new Music("띠-으-으.mp3", false);
				OX.start();
				// 진상손님이면 점수 -5
				if(BurgerMi.game.order.obnoxious == 4) {
					score -= 5;
				}
				BurgerMi.game.grade.setText(score + "점");
				System.out.println("실패");
				break;
			} 
			// 순서대로 햄버거 재료가 같으면 count++
			else if (((List<Object>) BurgerMi.game.order.orderBurger.get(count))
					.get(0) == ((List<Object>) BurgerMi.game.order.MakeBurger.get(count)).get(0)) {
				count++;
			}
		}

		// 주문버거, 만든버거 clear
		BurgerMi.game.order.orderBurger.clear();
		BurgerMi.game.order.MakeBurger.clear();

		System.out.println("");
		
		// 진상손님이면 햄버거 던지기
		if(BurgerMi.game.order.obnoxious==4) {
			Throw th = new Throw();
			th.start();
		}
		// 일반손님이면 새로운 손님 부르기
		else {
			BurgerMi.game.order = new Order();
			BurgerMi.game.order.start();
		}
		
		// 화면 다시그리기
		BurgerMi.game.revalidate();
		BurgerMi.game.repaint();

//		System.out.println("Order");
//		for (int i = 0; i < BurgerMi.game.order.orderBurger.size(); i++) {
//			System.out.println(BurgerMi.game.order.orderBurger.get(i));
//		}
//		System.out.println("");
//
//		System.out.println("");

	}

}