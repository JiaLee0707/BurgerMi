package BurgerMi_13_13;

import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;

public class Order {
	Random random = new Random();

	// 손님
	private Image guest1 = new ImageIcon("src/images/11.png").getImage();
	private Image guest2 = new ImageIcon("src/images/22.png").getImage();
	private Image guest3 = new ImageIcon("src/images/33.png").getImage();
	private Image guest4 = new ImageIcon("src/images/44.png").getImage();
	private Image guest5 = new ImageIcon("src/images/55.png").getImage();
	private Image guest6 = new ImageIcon("src/images/66.png").getImage();
	private Image[] guestArray = { guest1, guest2, guest3, guest4, guest5, guest6 };
	public Image thisGuest = null;

	// 주문받은 버거
	private Image orderbelowBreadImage = new ImageIcon("src/images/Order아래빵.png").getImage(); // 5
	private Image ordertopBreadImage = new ImageIcon("src/images/Order윗빵.png").getImage(); // 4
	private Image orderlettuceImage = new ImageIcon("src/images/Order채소.png").getImage(); // 3
	private Image ordertomatoImage = new ImageIcon("src/images/Order토마토.png").getImage(); // 2
	private Image orderpattyImage = new ImageIcon("src/images/Order패티.png").getImage(); // 1
	private Image ordercheeseImage = new ImageIcon("src/images/Order치즈.png").getImage(); // 0
	public Image[] orderBurgerImageArray = { ordercheeseImage, orderpattyImage, ordertomatoImage, orderlettuceImage,
			ordertopBreadImage, orderbelowBreadImage };

	public List<Object> orderBurger = new LinkedList<Object>();
	public List<Object> burgerIngredient;

	int[] orderBurgerArray;
	int who, y;

	public void Order() {
		orderBurgerArray = new int[5];
		int orderBurger = 0, i = 0, random = 6; // 주문 버거

		// 주문받은 버거
		if (who != 4) { // 진상 손님이 아니라면
			System.out.println("진상X");
			i = 1;
			random = 4;
			orderBurgerArray[0] = 5;
			orderBurgerArray[4] = 4;
		}

		// 주문 랜덤
		for (int j = i; j < 5 - i; j++) {
			orderBurger = (int) (Math.random() * random);
			orderBurgerArray[j] = orderBurger;
		}
	}

	public void Burger(int i) {
		burgerIngredient = new LinkedList<Object>();
		// 햄버거 재료 위치 조정
		int y = 160 - 25 * i;
		burgerIngredient.add(orderBurgerImageArray[orderBurgerArray[i]]);
		switch (orderBurgerArray[i]) {
		case 0: // 치즈
			burgerIngredient.add(130);
			burgerIngredient.add(y + 5);
//			System.out.println("치즈");
			break;
		case 1: // 패티
			burgerIngredient.add(135);
			burgerIngredient.add(y + 27);
//			System.out.println("패티");
			break;
		case 2: // 토마토
			burgerIngredient.add(146);
			burgerIngredient.add(y + 28);
//			System.out.println("토마토");
			break;
		case 3: // 채소
			burgerIngredient.add(131);
			burgerIngredient.add(y - 10);
//			System.out.println("채소");
			break;
		case 4: // 윗빵
			burgerIngredient.add(137);
			burgerIngredient.add(y - 20);
//			System.out.println("윗빵");
			break;
		case 5: // 아랫빵
			burgerIngredient.add(153);
			burgerIngredient.add(y);
//			System.out.println("아랫빵");
			break;
		}
		orderBurger.add((List<Object>) burgerIngredient);
//		System.out.println(orderBurger.get(i));

	}

	class Guest extends Thread {
		public Guest() {
			who = (int) (Math.random() * 6); // 손님 랜덤
			thisGuest = guestArray[who];
			y = 100; // 손님 y좌표
		}

		public void Guest() {
			this.start();

		}

		public void run() {
			try {
				while (y != 136) {
					y += 1;
					// Main.burgermi.game.revalidate();
					Main.burgermi.game.getParent().repaint();
					Thread.sleep(10);
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}

	}
}