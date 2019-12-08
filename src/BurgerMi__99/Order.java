package BurgerMi__99;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public class Order extends Thread {
	Random random = new Random();

	// ���鶧 ����ϴ� ����
	private Image belowBreadImage = new ImageIcon("src/images/�Ʒ���.png").getImage();
	private Image topBreadImage = new ImageIcon("src/images/����.png").getImage();
	private Image lettuceImage = new ImageIcon("src/images/ä��.png").getImage();
	private Image tomatoImage = new ImageIcon("src/images/�丶��.png").getImage();
	private Image pattyImage = new ImageIcon("src/images/��Ƽ.png").getImage();
	private Image cheeseImage = new ImageIcon("src/images/ġ��.png").getImage();

	// �ֹ����� ����
	private Image orderTrayImage = new ImageIcon("src/images/Order�Ʒ���.png").getImage();
	private Image orderbelowBreadImage = new ImageIcon("src/images/Order�Ʒ���.png").getImage();
	private Image ordertopBreadImage = new ImageIcon("src/images/Order����.png").getImage();
	private Image orderlettuceImage = new ImageIcon("src/images/Orderä��.png").getImage();
	private Image ordertomatoImage = new ImageIcon("src/images/Order�丶��.png").getImage();
	private Image orderpattyImage = new ImageIcon("src/images/Order��Ƽ.png").getImage();
	private Image ordercheeseImage = new ImageIcon("src/images/Orderġ��.png").getImage();

	// �մ�
	private Image guest1 = new ImageIcon("src/images/11.png").getImage();
	private Image guest2 = new ImageIcon("src/images/22.png").getImage();
	private Image guest3 = new ImageIcon("src/images/33.png").getImage();
	private Image guest4 = new ImageIcon("src/images/44.png").getImage();
	private Image guest5 = new ImageIcon("src/images/55.png").getImage();
	private Image guest6 = new ImageIcon("src/images/66.png").getImage();
	public Image[] guestArray = { guest1, guest2, guest3, guest4, guest5, guest6 };

	public int guest, y = 100; // (����)�մ� �̹���, �մ� y��ǥ
	public boolean G = false; // �մ� ����(boolean)
	int obnoxious; // (����)���� �մ�

	List<Object> orderBurger = new ArrayList<Object>(); // �ֹ����� ����
	List<Object> MakeBurger = new ArrayList<Object>(); // ���� ����

	Order() {
		int keySheet[] = { 65, 68, 69, 81, 83, 87 };

		// �մ� �̹��� ����
		guest = (int) (Math.random() * 6);
		// ����մ� ����
		obnoxious = (int) (Math.random() * 6);

		int ii = 0; // �ܹ��� ��� ���� ����(0 or 1)

		// ����մ��� �ƴϸ� (�ػ� �߰�)
		if (obnoxious != 4) {
			// �ܹ��� ��� �ϳ��� �̹���, ��ǥ (Vector)
			List<Object> ingredients = new ArrayList<Object>();
			ingredients.add("belowBread"); // �ܹ��� ��� �̹���
			ingredients.add(orderbelowBreadImage);// �ܹ��� ��� �̹���

			// x, y��ǥ �߰�
			ingredients.add(160);
			ingredients.add(150);
			System.out.println("�ػ�");

			// �ܹ��ſ� ��� �̹���, ��ǥ �߰�
			orderBurger.add((List<Object>) ingredients);

			ii = 1;
		}

		// �ܹ��� ��ᰡ 5���� �ɶ����� �ݺ�
		// ����մ��̸� �ܹ��� ��� 5�� ����
		// ����մ��� �ƴϸ� // �̹� �� �ִ� ���� �����Ͽ� 4���� �� ������ ����
		while (orderBurger.size() != 5 - ii) {
			// �ܹ��� ��� �ϳ��� �̹���, ��ǥ (Vector)
			List<Object> ingredients = new ArrayList<Object>();
			// �ܹ��� ��� ����
			int orderSheet = (int) ((Math.random() * 86) + 65);

			// �ܹ��� ��� ��ġ �ʱ�ȭ
			int xx = 0, yy = 160;

			// �ܹ��� ��� ����
			for (int i = 0; i < keySheet.length; i++) {
				// ����մ��� �ƴϸ� �ܹ��� �ػ�,���� ����
				if (obnoxious != 4 && ((orderSheet == 83) || (orderSheet == 87))) {
					break;
				}
				// ������ �ܹ��� ��ᰡ ������
				if (orderSheet == keySheet[i]) {
					switch (orderSheet) {
					case 65: // ��Ƽ
						System.out.println("��Ƽ");
						ingredients.add("patty"); // �ܹ��� ���
						ingredients.add(orderpattyImage); // �ܹ��� ��� �̹���
						xx = 140; // �ܹ��� ��� x��ǥ
						break;
					case 68: // ����
						System.out.println("����");
						ingredients.add("lettuce"); // �ܹ��� ���
						ingredients.add(orderlettuceImage); // �ܹ��� ��� �̹���
						xx = 138; // �ܹ��� ��� x��ǥ
						break;
					case 69: // ġ��
						System.out.println("ġ��");
						ingredients.add("cheese"); // �ܹ��� ���
						ingredients.add(ordercheeseImage); // �ܹ��� ��� �̹���
						xx = 138; // �ܹ��� ��� x��ǥ
						break;
					case 81: // �丶��
						System.out.println("�丶��");
						ingredients.add("tomato"); // �ܹ��� ���
						ingredients.add(ordertomatoImage); // �ܹ��� ��� �̹���
						xx = 150; // �ܹ��� ��� x��ǥ
						break;
					case 83: // �ػ�
						System.out.println("�ػ�");
						ingredients.add("belowBread"); // �ܹ��� ���
						ingredients.add(orderbelowBreadImage);// �ܹ��� ��� �̹���
						xx = 160; // �ܹ��� ��� x��ǥ
						break;
					case 87: // ����
						System.out.println("����");
						ingredients.add("topBread"); // �ܹ��� ���
						ingredients.add(ordertopBreadImage); // �ܹ��� ��� �̹���
						xx = 145; // �ܹ��� ��� x��ǥ
						break;
					}

					// ��� ������ ���� y��ǥ
					if (orderBurger.size() + 1 > 1) {
						yy = yy - (20 * (orderBurger.size() + 1));
						// �丶�� �Ǵ� ��Ƽ�� 40 �� ������
						if ((orderSheet == 81) || (orderSheet == 65)) {
							yy = yy + 40;
						}
						// �����̸� 45 �� ����
						else if (orderSheet == 87) {
							yy = yy - 45;
						}
					}

					// x, y��ǥ �߰�
					ingredients.add(xx);
					ingredients.add(yy);

					// �ܹ��� ��� �̹���, ��ǥ�� �߰�
					orderBurger.add((List<Object>) ingredients);

					break;
				} // if
			} // for
		} // while

		// ����մ��� �ƴϸ� (���� �߰�)
		if (obnoxious != 4) {
			// �ܹ��� ��� �ϳ��� �̹���, ��ǥ (Vector)
			List<Object> ingredients = new ArrayList<Object>();
			ingredients.add("topBread"); // �ܹ��� ��� �̹���
			ingredients.add(ordertopBreadImage); // �ܹ��� ��� �̹���
			System.out.println("����");

			// x, y��ǥ �߰�
			ingredients.add(145);
			ingredients.add(30);

			// �ܹ��� ��� �̹���, ��ǥ�� �߰�
			orderBurger.add((List<Object>) ingredients);

		}
	}

	// �մ� Thread
	public void run() {
		try {
			G = true;
			while (y != 136) {
				y += 1;
				BurgerMi.game.repaint();
				Thread.sleep(10);
			}
			G = false;
		} catch (Exception e) {
//			e.printStackTrace();
			e.getMessage();
		}
	}

	// �ܹ��� �����
	public void Make(String key) {
		new Music("203.mp3", false).start();

		// �ܹ��� ��� ��ġ �ʱ�ȭ
		int xx = 0, yy = 500;
		Image ingredients = null;

		// �ܹ��� ��� x��ǥ, �̹���
		switch (key) {
		case "belowBread": // �ػ�
			xx = 500;
			ingredients = belowBreadImage;
			break;
		case "topBread": // ����
			xx = 480;
			ingredients = topBreadImage;
			break;
		case "lettuce": // ����
			xx = 475;
			ingredients = lettuceImage;
			break;
		case "tomato": // �丶��
			xx = 490;
			ingredients = tomatoImage;
			break;
		case "patty": // ��Ƽ
			xx = 480;
			ingredients = pattyImage;
			break;
		case "cheese": // ġ��
			xx = 475;
			ingredients = cheeseImage;
			break;
		}

		// ��� ������ ���� y��ǥ
		if (MakeBurger.size() + 1 > 1) {
			yy = yy - (20 * (MakeBurger.size() + 1));
			// �丶�� �Ǵ� ��Ƽ�� 30 �� ������
			if (key.equals("tomato") || key.equals("patty")) {
				yy = yy + 30;
			}
			// �����̸� 50 �� ����
			else if (key.equals("topBread")) {
				yy = yy - 50;
			}
		}

		// �ܹ��� ���, ��ǥ �ʱ�ȭ
		BurgerMi.game.burger = new Burger(xx, yy, ingredients, key);
		BurgerMi.game.burger.start(); // �ܹ��� �������� ������

		return;
	}

}