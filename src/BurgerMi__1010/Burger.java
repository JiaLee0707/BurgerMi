package BurgerMi__1010;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

//햄버거 내려오는 쓰레드
public class Burger extends Thread {
	int x, y; // 햄버거 x,y 좌표
	String StringIngeredients; // 햄버거 재료 이름
	Image ingredients; // 햄버거 재료 이미지

	// 햄버거 재료, 좌표 초기화
	Burger(int x, int y, Image ingredients, String string) {
		this.x = x;
		this.y = y;
		this.ingredients = ingredients;
		this.StringIngeredients = string;
	}

	public void run() {
		int i = 0; // 내려오는 재료의 y좌표
		boolean bool = true; // 햄버거 내려오냐/안내려오냐
		try {
			// i가 y가 아닐때까지 스레드 실행
			while (i != y) {
				i = i + 1;
				BurgerMi.game.Thread(ingredients, x, i, bool); // 화면에 그리기 위해
																// Game 클래스에 변수 초기화
				BurgerMi.game.repaint(); // 화면 다시그리기
				Thread.sleep(1); // 햄버거 재료 내려오는 속도
			}

			// MakeBurger에 추가
			List<Object> BurgerArray = new ArrayList<Object>(); // 햄버거 재료 하나의 이미지, 위치 List
			BurgerArray.add(this.StringIngeredients);
			BurgerArray.add(this.ingredients);
			BurgerArray.add(this.x);
			BurgerArray.add(this.y);
			// 햄버거에 재료 추가
			BurgerMi.game.order.MakeBurger.add((List<Object>) BurgerArray);
			System.out.println("");
			bool = false; // 햄버거 내려오기 끝
		} catch (InterruptedException e) {
			return;
		}
	}
}