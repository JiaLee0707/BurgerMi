package BurgerMi_ITShow;

import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;

public class Order {
	Random random = new Random();

	// 손님
	private Image guest1 = new ImageIcon("src/images/손님1.png").getImage();
	private Image guest2 = new ImageIcon("src/images/손님2.png").getImage();
	private Image guest3 = new ImageIcon("src/images/손님3.png").getImage();
	private Image guest4 = new ImageIcon("src/images/손님4.png").getImage();
	private Image guest5 = new ImageIcon("src/images/손님5.png").getImage();
	private Image guest6 = new ImageIcon("src/images/손님6.png").getImage();
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
	int who, menu, y;

	public void Burger(int i) {
		burgerIngredient = new LinkedList<Object>();
		// 햄버거 재료 위치 조정
		int y = 160 - 25 * i;
		burgerIngredient.add(orderBurgerImageArray[orderBurgerArray[i]]);
		switch (orderBurgerArray[i]) {
		case 0:
			burgerIngredient.add(130);
			burgerIngredient.add(y + 5);
			break;
		case 1:
			burgerIngredient.add(135);
			burgerIngredient.add(y + 27);
			break;
		case 2:
			burgerIngredient.add(146);
			burgerIngredient.add(y + 28);
			break;
		case 3:
			burgerIngredient.add(131);
			burgerIngredient.add(y - 10);
			break;
		case 4:
			burgerIngredient.add(137);
			burgerIngredient.add(y - 20);
			break;
		case 5:
			burgerIngredient.add(153);
			burgerIngredient.add(y);
			break;
		}
		orderBurger.add((List<Object>) burgerIngredient);

	}

	class Guest extends Thread {
		public Guest() {
			who = (int) (Math.random() * 6); // 손님 랜덤
			menu = (int) (Math.random() * 6); // 주문 랜덤
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