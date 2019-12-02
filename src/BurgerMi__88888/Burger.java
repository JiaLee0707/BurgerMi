package BurgerMi__88888;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Burger extends Thread {

	int x, y;
	String StringIngeredients;
	Image ingredients;

	Burger(int x, int y, Image ingredients, String string) {
//		System.out.println("Burger");
		this.x = x;
		this.y = y;
		this.ingredients = ingredients;
		this.StringIngeredients = string;
//		System.out.println(x+","+y);
	}

	public void run() {
//		System.out.println("run : "+x+","+y);
		int i = 0;
		boolean bool = true;
		try {
			// i�� x�� �ƴҶ����� ������ ����
			while (i != y) {
				i = i + 1;
//				System.out.println(i);
				BurgerMi.game.Thread(ingredients, x, i, bool);
//				System.out.println(ingredients);
				BurgerMi.game.revalidate();
				BurgerMi.game.repaint();
				Thread.sleep(1);
			}

			// MakeBurger�� �߰�
			List<Object> BurgerArray = new ArrayList<Object>(); // �ϳ��� �ܹ��� �̹���, ��ġ List
			BurgerArray.add(this.StringIngeredients);
			BurgerArray.add(this.ingredients);
			BurgerArray.add(this.x);
			BurgerArray.add(this.y);
			BurgerMi.game.order.MakeBurger.add((List<Object>) BurgerArray);
//			for (i = 0; i < BurgerMi.game.order.MakeBurger.size(); i++) {
//				System.out.println(BurgerMi.game.order.MakeBurger.get(i));
//			}
			System.out.println("");
			bool = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
