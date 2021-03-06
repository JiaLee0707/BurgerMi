package BurgerMi_15_15;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Burger {

	// 만들때 사용하는 버거
	private Image belowBreadImage = new ImageIcon("src/images/breadBelowSesame.png").getImage();
	private Image topBreadImage = new ImageIcon("src/images/breadTopSesame.png").getImage();
	private Image lettuceImage = new ImageIcon("src/images/lettuce.png").getImage();
	private Image tomatoImage = new ImageIcon("src/images/tomato.png").getImage();
	private Image pattyImage = new ImageIcon("src/images/patty.png").getImage();
	private Image cheeseImage = new ImageIcon("src/images/cheese.png").getImage();
	public Image[] MakeBurgerImageArray = { cheeseImage, pattyImage, tomatoImage, lettuceImage, topBreadImage,
			belowBreadImage };

	public LinkedList<Integer> MakeBurgerIntArray = new LinkedList<Integer>(); // 만드는 버거 int
//	public LinkedList<Object> MakeBurgerObjectArray = new LinkedList<Object>(); // 만드는 버거 이미지, 위치
	public LinkedList<Object> burgerIngredient = new LinkedList<Object>(); // 내려오는 버거
	public LinkedList<Object> Ingredient;
	public LinkedList<Integer> i = new LinkedList<Integer>();
	int x, y; // 햄버거 x, y, i 좌표

	boolean key = false;

	public void Burger(int m) {
		key = true;

		Ingredient = new LinkedList<Object>();
		Ingredient.add(MakeBurgerImageArray[m]);
		MakeBurgerIntArray.add(m);
		for (int i = 0; i < MakeBurgerIntArray.size(); i++) {
			System.out.println(MakeBurgerIntArray.get(i));
		}

		y = 540 - 25 * (MakeBurgerIntArray.size());

		switch (m) {
		case 0: // 치즈
			x = 485;
			y -= 30;
//			System.out.println("치즈");
			break;
		case 1: // 패티
			x = 490;
//			y -= 5;
//			System.out.println("패티");
			break;
		case 2: // 토마토
			x = 503;
//			y -= 5;
//			System.out.println("토마토");
			break;
		case 3: // 채소
			x = 485;
			y -= 40;
//			System.out.println("채소");
			break;
		case 4: // 윗빵
			x = 495;
			y -= 60;
//			System.out.println("윗빵");
			break;
		case 5: // 아랫빵
			x = 510;
			y -= 20;
//			System.out.println("밑빵");
			break;
		}
		Ingredient.add(x);
		Ingredient.add(y);
		burgerIngredient.add(Ingredient);
		i.add(0);
		BurgerThread thread = new BurgerThread(Ingredient, i.size());
		thread.start();

		Main.burgermi.game.getParent().repaint();
	}

	class BurgerThread extends Thread {
		LinkedList<Object> IngredientBurger;
		int j;

		public BurgerThread(LinkedList<Object> Ingredient, int i) {
			IngredientBurger = Ingredient;
			j = i - 1;
		}

		public void run() {
			try {
				int ii = (int) IngredientBurger.get(2);
				while (i.get(j) != ii) {
					i.set(j, i.get(j) + 1);
//					System.out.println(i.get(j));
					Main.burgermi.game.getParent().repaint();
					Thread.sleep(1);
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
}