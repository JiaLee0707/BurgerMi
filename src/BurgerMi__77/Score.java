package BurgerMi__77;

import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

public class Score {
	int score = 0;
	boolean Enter = false;

	public void Score() {
		int size = 0, i = 0;

		// 점수 계산
		while (true) {
			if (size == BurgerMi.game.order.orderBurger.size()) {

//				new Music("203.mp3", false).start();

				if (BurgerMi.game.order.obnoxious == 4) {
					score += 20;
				} else {
					score += 10;
				}
				BurgerMi.game.grade.setText(score + "점");
				System.out.println("성공");
				break;
			} else if ((BurgerMi.game.order.MakeBurger.size() == 0)
					|| !((((List<Object>) BurgerMi.game.order.orderBurger.get(i))
							.get(0) == ((List<Object>) BurgerMi.game.order.MakeBurger.get(i)).get(0)))) {
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

		Enter = true;

		// 화면 다시그리기
		BurgerMi.game.revalidate();
		BurgerMi.game.repaint();

		Enter = false;

		System.out.println("Order");
		for (i = 0; i < BurgerMi.game.order.orderBurger.size(); i++) {
			System.out.println(BurgerMi.game.order.orderBurger.get(i));
		}
		System.out.println("");

		BurgerMi.game.order = new Order();
		BurgerMi.game.order.start();
		Throw th = new Throw();
		th.start();
		System.out.println("");

	}

}