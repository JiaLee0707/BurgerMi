package BurgerMi_13_13;

import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;

public class Order {
	Random random = new Random();
	Guest guest;

	// �մ�
	private Image guest1 = new ImageIcon("src/images/11.png").getImage();
	private Image guest2 = new ImageIcon("src/images/22.png").getImage();
	private Image guest3 = new ImageIcon("src/images/33.png").getImage();
	private Image guest4 = new ImageIcon("src/images/44.png").getImage();
	private Image guest5 = new ImageIcon("src/images/55.png").getImage();
	private Image guest6 = new ImageIcon("src/images/66.png").getImage();
	private Image[] guestArray = { guest1, guest2, guest3, guest4, guest5, guest6 };
	public Image thisGuest = null;

	// �ֹ����� ����
	private Image orderbelowBreadImage = new ImageIcon("src/images/Order�Ʒ���.png").getImage(); // 5
	private Image ordertopBreadImage = new ImageIcon("src/images/Order����.png").getImage(); // 4
	private Image orderlettuceImage = new ImageIcon("src/images/Orderä��.png").getImage(); // 3
	private Image ordertomatoImage = new ImageIcon("src/images/Order�丶��.png").getImage(); // 2
	private Image orderpattyImage = new ImageIcon("src/images/Order��Ƽ.png").getImage(); // 1
	private Image ordercheeseImage = new ImageIcon("src/images/Orderġ��.png").getImage(); // 0
	public Image[] orderBurgerImageArray = { ordercheeseImage, orderpattyImage, ordertomatoImage, orderlettuceImage,
			ordertopBreadImage, orderbelowBreadImage };

	public List<Object> orderBurger = new LinkedList<Object>();
	public List<Object> burgerIngredient = new LinkedList<Object>();
	
	int[] orderBurgerArray = new int[5];

	public Order() {
		
		burgerIngredient.add(null);
		burgerIngredient.add(0);
		burgerIngredient.add(0);
		
		orderBurger.add(burgerIngredient);
		
		guest = new Guest();

		int orderBurger = 0, i = 0, random = 6; // �ֹ� ����

		// �ֹ����� ����
		if (guest.who != 4) { // ���� �մ��� �ƴ϶��
			System.out.println("����X");
			i = 1;
			random = 4;
			orderBurgerArray[0] = 5;
			orderBurgerArray[4] = 4;
		}

		// �ֹ� ����
		for (int j = i; j < 5 - i; j++) {
			orderBurger = (int) (Math.random() * random);
			orderBurgerArray[j] = orderBurger;
		}
	}

	public void Order(int i) {		
		// �ܹ��� ��� ��ġ ����
		int y = 160 - 25 * (i + 1);
//		System.out.println("asdfafd"+ orderBurgerImageArray[orderBurgerArray[i]]);
		burgerIngredient.add(orderBurgerImageArray[orderBurgerArray[i]]);
		switch (orderBurgerArray[i]) {
		case 0: // ġ��
			burgerIngredient.add(135);
			burgerIngredient.add(y + 10);
			System.out.println("ġ��");
			break;
		case 1: // ��Ƽ
			burgerIngredient.add(140);
			burgerIngredient.add(y + 13);
			System.out.println("��Ƽ");
			break;
		case 2: // �丶��
			burgerIngredient.add(140);
			burgerIngredient.add(y + 8);
			System.out.println("�丶��");
			break;
		case 3: // ä��
			burgerIngredient.add(138);
			burgerIngredient.add(y - 3);
			System.out.println("ä��");
			break;
		case 4: // ����
			burgerIngredient.add(135);
			burgerIngredient.add(y - 10);
			System.out.println("����");
			break;
		case 5: // �Ʒ���
			burgerIngredient.add(135);
			burgerIngredient.add(y);
			System.out.println("�Ʒ���");
			break;
		}
		orderBurger.add((List<Object>) burgerIngredient);
		System.out.println(orderBurger.get(i));

	}

	class Guest extends Thread {
		int who, y;

		public void Guest() {
			who = (int) (Math.random() * 6); // �մ� ����
			thisGuest = guestArray[who];
			y = 100; // �մ� y��ǥ

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
