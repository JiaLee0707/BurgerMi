package BurgerMi__33;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Burger extends Thread {
	private Image TrayImage = new ImageIcon("src/images/쟁반111.png").getImage();
	private Image belowBreadImage = new ImageIcon("src/images/아래빵.png").getImage();
	private Image topBreadImage = new ImageIcon("src/images/윗빵.png").getImage();
	private Image lettuceImage = new ImageIcon("src/images/채소.png").getImage();
	private Image tomatoImage = new ImageIcon("src/images/토마토.png").getImage();
	private Image pattyImage = new ImageIcon("src/images/패티.png").getImage();
	private Image cheeseImage = new ImageIcon("src/images/치즈.png").getImage();

	int x, y;
	Image ingredients;

	Burger(int x, int y, String ingredients) {
		this.x = x;
		this.y = y;
//		System.out.println(x+","+y);

		switch (ingredients) {
		case "belowBread":
			this.ingredients = belowBreadImage;
			break;
		case "topBread":
			this.ingredients = topBreadImage;
			break;
		case "lettuce":
			this.ingredients = lettuceImage;
			break;
		case "tomato":
			this.ingredients = tomatoImage;
			break;
		case "patty":
			this.ingredients = pattyImage;
			break;
		case "cheese":
			this.ingredients = cheeseImage;
			break;
		}
	}

	public void run() {
//		System.out.println("run : "+x+","+y);
		int i = 0;
		boolean bool = true;
		try {
			// i가 x가 아닐때까지 스레드 실행
			while (i != y) {
				i = i + 1;
//				System.out.println(i);
				BurgerMi.game.Thread(ingredients, x, i, bool);
//				System.out.println(ingredients);
				BurgerMi.game.repaint();
				Thread.sleep(1);
			}

			// BurgerArray에 추가
			List<Object> Array = new ArrayList<Object>();
			Array.add(this.ingredients);
			Array.add(this.x);
			Array.add(this.y);
			BurgerMi.game.BurgerArray.add((List<Object>) Array);
			for (i = 0; i < BurgerMi.game.BurgerArray.size(); i++) {
				System.out.println(BurgerMi.game.BurgerArray.get(i));
			}
			System.out.println("");
			bool = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}