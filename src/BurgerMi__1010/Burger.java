package BurgerMi__1010;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

//�ܹ��� �������� ������
public class Burger extends Thread {
	int x, y; // �ܹ��� x,y ��ǥ
	String StringIngeredients; // �ܹ��� ��� �̸�
	Image ingredients; // �ܹ��� ��� �̹���

	// �ܹ��� ���, ��ǥ �ʱ�ȭ
	Burger(int x, int y, Image ingredients, String string) {
		this.x = x;
		this.y = y;
		this.ingredients = ingredients;
		this.StringIngeredients = string;
	}

	public void run() {
		int i = 0; // �������� ����� y��ǥ
		boolean bool = true; // �ܹ��� ��������/�ȳ�������
		try {
			// i�� y�� �ƴҶ����� ������ ����
			while (i != y) {
				i = i + 1;
				BurgerMi.game.Thread(ingredients, x, i, bool); // ȭ�鿡 �׸��� ����
																// Game Ŭ������ ���� �ʱ�ȭ
				BurgerMi.game.repaint(); // ȭ�� �ٽñ׸���
				Thread.sleep(1); // �ܹ��� ��� �������� �ӵ�
			}

			// MakeBurger�� �߰�
			List<Object> BurgerArray = new ArrayList<Object>(); // �ܹ��� ��� �ϳ��� �̹���, ��ġ List
			BurgerArray.add(this.StringIngeredients);
			BurgerArray.add(this.ingredients);
			BurgerArray.add(this.x);
			BurgerArray.add(this.y);
			// �ܹ��ſ� ��� �߰�
			BurgerMi.game.order.MakeBurger.add((List<Object>) BurgerArray);
			System.out.println("");
			bool = false; // �ܹ��� �������� ��
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
