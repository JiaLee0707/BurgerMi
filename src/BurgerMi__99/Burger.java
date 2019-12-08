package BurgerMi__99;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

//�ܹ��� �������� ������
public class Burger extends Thread {
	int x, y;
	String StringIngeredients;
	Image ingredients;

	Burger(int x, int y, Image ingredients, String string) {
		// �ܹ��� ���, ��ǥ �ʱ�ȭ
		this.x = x;
		this.y = y;
		this.ingredients = ingredients;
		this.StringIngeredients = string;
	}

	public void run() {
		int i = 0;
		boolean bool = true;
		try {
			// i�� y�� �ƴҶ����� ������ ����
			while (i != y) {
				i = i + 1;
				BurgerMi.game.Thread(ingredients, x, i, bool);
				BurgerMi.game.repaint();
				Thread.sleep((long) 0.9);
			}

			// MakeBurger�� �߰�
			List<Object> BurgerArray = new ArrayList<Object>(); // �ϳ��� �ܹ��� �̹���, ��ġ List
			BurgerArray.add(this.StringIngeredients);
			BurgerArray.add(this.ingredients);
			BurgerArray.add(this.x);
			BurgerArray.add(this.y);
			BurgerMi.game.order.MakeBurger.add((List<Object>) BurgerArray);
			System.out.println("");
			bool = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
