package BurgerMi__55;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public class Order {
	private Image TrayImage = new ImageIcon("src/images/���111.png").getImage();
	private Image belowBreadImage = new ImageIcon("src/images/�Ʒ���.png").getImage();
	private Image topBreadImage = new ImageIcon("src/images/����.png").getImage();
	private Image lettuceImage = new ImageIcon("src/images/ä��.png").getImage();
	private Image tomatoImage = new ImageIcon("src/images/�丶��.png").getImage();
	private Image pattyImage = new ImageIcon("src/images/��Ƽ.png").getImage();
	private Image cheeseImage = new ImageIcon("src/images/ġ��.png").getImage();

	private Image orderTrayImage = TrayImage.getScaledInstance(TrayImage.getWidth(null) - 50,
			TrayImage.getHeight(null) - 50, TrayImage.SCALE_SMOOTH);
	private Image orderbelowBreadImage = belowBreadImage.getScaledInstance(belowBreadImage.getWidth(null) - 50,
			belowBreadImage.getHeight(null) - 50, belowBreadImage.SCALE_SMOOTH);
	private Image ordertopBreadImage = topBreadImage.getScaledInstance(topBreadImage.getWidth(null) - 50,
			topBreadImage.getHeight(null) - 50, topBreadImage.SCALE_SMOOTH);
	private Image orderlettuceImage = lettuceImage.getScaledInstance(lettuceImage.getWidth(null) - 50,
			lettuceImage.getHeight(null) - 50, lettuceImage.SCALE_SMOOTH);
	private Image ordertomatoImage = tomatoImage.getScaledInstance(tomatoImage.getWidth(null) - 50,
			tomatoImage.getHeight(null) - 50, tomatoImage.SCALE_SMOOTH);
	private Image orderpattyImage = pattyImage.getScaledInstance(pattyImage.getWidth(null) - 50,
			pattyImage.getHeight(null) - 50, pattyImage.SCALE_SMOOTH);
	private Image ordercheeseImage = cheeseImage.getScaledInstance(cheeseImage.getWidth(null) - 50,
			cheeseImage.getHeight(null) - 50, cheeseImage.SCALE_SMOOTH);

	Random random = new Random();
	// �ֹ����� ����
	List<Object> orderBurger = new ArrayList<Object>();
	// ���� ����
	List<Object> MakeBurger = new ArrayList<Object>();

	Order() {
		System.out.println("order");
		int keySheet[] = { 65, 68, 69, 81, 83, 87 };

		while (orderBurger.size() != 5) {
			List<Object> ingredients = new ArrayList<Object>();
			int i = 0;
			int orderSheet = (int) ((Math.random() * 86) + 65);

			// �ܹ��� ��� ��ġ �ʱ�ȭ
			int xx = 0, yy = 150;

			for (i = 0; i < keySheet.length; i++) {
				if (orderSheet == keySheet[i]) {
					switch (orderSheet) {
					case 65: // ��Ƽ
						System.out.println("��Ƽ");
						ingredients.add("patty"); // �ܹ��� ��� �̹���
						ingredients.add(orderpattyImage); // �ܹ��� ��� �̹���
						xx = 500; // �ܹ��� ��� x��ǥ
						break;
					case 68: // ����
						System.out.println("����");
						ingredients.add("lettuce"); // �ܹ��� ��� �̹���
						ingredients.add(orderlettuceImage); // �ܹ��� ��� �̹���
						xx = 495; // �ܹ��� ��� x��ǥ
						break;
					case 69: // ġ��
						System.out.println("ġ��");
						ingredients.add("cheese"); // �ܹ��� ��� �̹���
						ingredients.add(ordercheeseImage); // �ܹ��� ��� �̹���
						xx = 495; // �ܹ��� ��� x��ǥ
						break;
					case 81: // �丶��
						System.out.println("�丶��");
						ingredients.add("tomato"); // �ܹ��� ��� �̹���
						ingredients.add(ordertomatoImage); // �ܹ��� ��� �̹���
						xx = 510; // �ܹ��� ��� x��ǥ
						break;
					case 83: // �ػ�
						System.out.println("�ػ�");
						ingredients.add("belowBread"); // �ܹ��� ��� �̹���
						ingredients.add(orderbelowBreadImage);// �ܹ��� ��� �̹���
						xx = 520; // �ܹ��� ��� x��ǥ
						break;
					case 87: // ����
						System.out.println("����");
						ingredients.add("topBread"); // �ܹ��� ��� �̹���
						ingredients.add(ordertopBreadImage); // �ܹ��� ��� �̹���
						xx = 500; // �ܹ��� ��� x��ǥ
						break;
					}
					
					// ��� ������ ���� y��ǥ
					if (orderBurger.size() + 1 > 1) {
						yy = yy - (20 * (orderBurger.size() + 1));
						// �丶�� �Ǵ� ��Ƽ�� 30 �� ������
						if ((orderSheet == 81) || (orderSheet == 65)) {
							// .equals("tomato") || ingredients.equals("patty")) {
							yy = yy + 20;
						}
						// �����̸� 50 �� ����
						else if (orderSheet == 87) {
							yy = yy - 60;
						}
					}

					// x, y��ǥ �߰�
					ingredients.add(xx);
					ingredients.add(yy);

					orderBurger.add((List<Object>) ingredients);

//					for (i = 0; i < orderBurger.size(); i++) {
//						System.out.println(orderBurger.get(i));
//					}

//					ingredients.clear();

					break;
				} // if
			} // for
		}
	}

	public void Make(String key) {
		new Music("203.mp3", false).start();

		// �ܹ��� ��� ��ġ �ʱ�ȭ
		int xx = 0, yy = 500;
		Image ingredients = null;

		// �ܹ��� ��� x��ǥ, �̹���
		switch (key) {
		case "belowBread":
			xx = 500;
			ingredients = belowBreadImage;
			break;
		case "topBread":
			xx = 480;
			ingredients = topBreadImage;
			break;
		case "lettuce":
			xx = 475;
			ingredients = lettuceImage;
			break;
		case "tomato":
			xx = 490;
			ingredients = tomatoImage;
			break;
		case "patty":
			xx = 480;
			ingredients = pattyImage;
			break;
		case "cheese":
			xx = 475;
			ingredients = cheeseImage;
			break;
		}

//		System.out.println(BurgerArray.size());
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

		BurgerMi.game.burger = new Burger(xx, yy, ingredients, key);
		BurgerMi.game.burger.start();

	}
}
