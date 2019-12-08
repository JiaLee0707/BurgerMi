package BurgerMi__99;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

//햄버거 내려오는 쓰레드
public class Burger extends Thread {
	int x, y;
	String StringIngeredients;
	Image ingredients;

	Burger(int x, int y, Image ingredients, String string) {
		// 햄버거 재료, 좌표 초기화
		this.x = x;
		this.y = y;
		this.ingredients = ingredients;
		this.StringIngeredients = string;
	}

	public void run() {
		int i = 0;
		boolean bool = true;
		try {
			// i가 y가 아닐때까지 스레드 실행
			while (i != y) {
				i = i + 1;
				BurgerMi.game.Thread(ingredients, x, i, bool);
				BurgerMi.game.repaint();
				Thread.sleep((long) 0.9);
			}

			// MakeBurger에 추가
			List<Object> BurgerArray = new ArrayList<Object>(); // 하나의 햄버거 이미지, 위치 List
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
