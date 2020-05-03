package BurgerMi__66;

import java.util.List;

public class Score {
	int score = 0;

	public void Score() {
		int size = 0, i = 0;
//		System.out.println(((List<Object>) BurgerMi.game.order.orderBurger.get(1)).get(0));
//		System.out.println(((List<Object>) BurgerMi.game.order.MakeBurger.get(1)).get(0));
//		for (int i = 0; i < BurgerMi.game.order.orderBurger.size(); i++) {
		while (true) {
			if (size == BurgerMi.game.order.orderBurger.size()) {
				score += 10;
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

		BurgerMi.game.order.orderBurger.clear();
		BurgerMi.game.order.MakeBurger.clear();

		System.out.println("");
		BurgerMi.game.revalidate();
		// BurgerMi.game.invalidate();
		BurgerMi.game.repaint();
		System.out.println("Order");
		for (i = 0; i < BurgerMi.game.order.orderBurger.size(); i++) {
			System.out.println(BurgerMi.game.order.orderBurger.get(i));
		}
		System.out.println("");

		BurgerMi.game.order = new Order();
		System.out.println("");
	}
}