package BurgerMi__33;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
	Random random = new Random();
	private List<Integer> orderIngredients = new ArrayList<Integer>();
	private List<Integer> orderMake = new ArrayList<Integer>();

	Order() {
//		BurgerMi.game.revalidate();
//		BurgerMi.game.repaint();

		System.out.println("order");
		while (orderIngredients.size() != 5) {
			int orderSheet = (int) ((Math.random() * 86) + 65);
			switch (orderSheet) {
			case 65: // 패티
				System.out.println("패티");
				orderIngredients.add(orderSheet);
				break;
			case 68: // 상추
				System.out.println("상추");
				orderIngredients.add(orderSheet);
				break;
			case 69: // 치즈
				System.out.println("치즈");
				orderIngredients.add(orderSheet);
				break;
			case 81: // 토마토
				System.out.println("토마토");
				orderIngredients.add(orderSheet);
				break;
			case 83: // 밑빵
				System.out.println("밑빵");
				orderIngredients.add(orderSheet);
				break;
			case 87: // 윗빵
				System.out.println("윗빵");
				orderIngredients.add(orderSheet);
				break;
			}
//			System.out.println(orderIngredients.get(i));
		}
	}

	public void Make(int make) {
		int size = 0;
		if (make == 10) {
			for (int i = 0; i < orderIngredients.size(); i++) {
//				System.out.print(orderIngredients.get(i)+ " ");
//				System.out.println(orderMake.get(i)+ " ");
				System.out.println(orderMake.size());
				if (size == orderIngredients.size()) {
					System.out.println("성공");
				} else if ((orderMake.size() == 0) || (orderIngredients.get(i) != orderMake.get(i))) {
					System.out.println("실패");
					break;
				} else if (orderIngredients.get(i) == orderMake.get(i)) {
					size++;
					continue;
				}
			}

			BurgerMi.game.BurgerArray.clear();
			BurgerMi.game.ListImage.clear();
			BurgerMi.game.ListX.clear();
			BurgerMi.game.ListY.clear();
			orderIngredients.clear();
			orderMake.clear();

			System.out.println("");
			BurgerMi.game.revalidate();
//			BurgerMi.game.invalidate();
			BurgerMi.game.repaint();
			System.out.println("Order");
			for (int i = 0; i < BurgerMi.game.BurgerArray.size(); i++) {
				System.out.println(BurgerMi.game.BurgerArray.get(i));
			}
			System.out.println("");

			BurgerMi.game.order = new Order();
		} else
			orderMake.add(make);
	}
}
