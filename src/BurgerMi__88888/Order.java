package BurgerMi__88888;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public class Order extends Thread {
	// ���鶧 ����ϴ� ����
	private Image TrayImage = new ImageIcon("src/images/���111.png").getImage();
	private Image belowBreadImage = new ImageIcon("src/images/�Ʒ���.png").getImage();
	private Image topBreadImage = new ImageIcon("src/images/����.png").getImage();
	private Image lettuceImage = new ImageIcon("src/images/ä��.png").getImage();
	private Image tomatoImage = new ImageIcon("src/images/�丶��.png").getImage();
	private Image pattyImage = new ImageIcon("src/images/��Ƽ.png").getImage();
	private Image cheeseImage = new ImageIcon("src/images/ġ��.png").getImage();

	// �ֹ����� ����
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

	// �մ�
	private Image guest1 = new ImageIcon("src/images/11.png").getImage();
	private Image guest2 = new ImageIcon("src/images/22.png").getImage();
	private Image guest3 = new ImageIcon("src/images/33.png").getImage();
	private Image guest4 = new ImageIcon("src/images/44.png").getImage();
	private Image guest5 = new ImageIcon("src/images/55.png").getImage();
	private Image guest6 = new ImageIcon("src/images/66.png").getImage();

	public Image[] guestArray = { guest1, guest2, guest3, guest4, guest5, guest6 };
	public int guest, y = 100;
	public boolean G = false;
	int obnoxious;

	Random random = new Random();
	
	// �ֹ����� ����
	List<Object> orderBurger = new ArrayList<Object>();
	// ���� ����
	List<Object> MakeBurger = new ArrayList<Object>();

	Order() {
		System.out.println("order");
		int keySheet[] = { 65, 68, 69, 81, 83, 87 };

		// �մ�
		guest = (int) (Math.random() * 6);
		// ����մ� ����
		obnoxious = (int) (Math.random() * 6);
		
		int ii=0;
		
		System.out.println(obnoxious);
		if(obnoxious!=4) {
			List<Object> ingredients = new ArrayList<Object>();
			System.out.println("�ػ�");
			ingredients.add("belowBread"); // �ܹ��� ��� �̹���
			ingredients.add(orderbelowBreadImage);// �ܹ��� ��� �̹���
			
			// x, y��ǥ �߰�
			ingredients.add(160);
			ingredients.add(150);

			orderBurger.add((List<Object>) ingredients);
			
			ii=1;
		}
		else {
			ii=0;
		}
		
//		System.out.println(ii);
		while (orderBurger.size() != 5-ii) {
			List<Object> ingredients = new ArrayList<Object>();
			int i = 0;
			int orderSheet = (int) ((Math.random() * 86) + 65);

			// �ܹ��� ��� ��ġ �ʱ�ȭ
			int xx = 0, yy = 160;	
//			System.out.println(ii);
			
			for (i=0; i < keySheet.length; i++) {
//				System.out.println("for : "+i);
//				System.out.println("asdfasdf");
				if(obnoxious!=4 && ((orderSheet==83)||(orderSheet==87))) {
					break;
				}
				if (orderSheet == keySheet[i]) {
					switch (orderSheet) {
					case 65: // ��Ƽ
						System.out.println("��Ƽ");
						ingredients.add("patty"); // �ܹ��� ��� �̹���
						ingredients.add(orderpattyImage); // �ܹ��� ��� �̹���
						xx = 140; // �ܹ��� ��� x��ǥ
						break;
					case 68: // ����
						System.out.println("����");
						ingredients.add("lettuce"); // �ܹ��� ��� �̹���
						ingredients.add(orderlettuceImage); // �ܹ��� ��� �̹���
						xx = 138; // �ܹ��� ��� x��ǥ
						break;
					case 69: // ġ��
						System.out.println("ġ��");
						ingredients.add("cheese"); // �ܹ��� ��� �̹���
						ingredients.add(ordercheeseImage); // �ܹ��� ��� �̹���
						xx = 138; // �ܹ��� ��� x��ǥ
						break;
					case 81: // �丶��
						System.out.println("�丶��");
						ingredients.add("tomato"); // �ܹ��� ��� �̹���
						ingredients.add(ordertomatoImage); // �ܹ��� ��� �̹���
						xx = 150; // �ܹ��� ��� x��ǥ
						break;
					case 83: // �ػ�
						System.out.println("�ػ�");
						ingredients.add("belowBread"); // �ܹ��� ��� �̹���
						ingredients.add(orderbelowBreadImage);// �ܹ��� ��� �̹���
						xx = 160; // �ܹ��� ��� x��ǥ
						break;
					case 87: // ����
						System.out.println("����");
						ingredients.add("topBread"); // �ܹ��� ��� �̹���
						ingredients.add(ordertopBreadImage); // �ܹ��� ��� �̹���
						xx = 145; // �ܹ��� ��� x��ǥ
						break;
					}

					// ��� ������ ���� y��ǥ
					if (orderBurger.size() + 1 > 1) {
						yy = yy - (20 * (orderBurger.size() + 1));
						// �丶�� �Ǵ� ��Ƽ�� 30 �� ������
						if ((orderSheet == 81) || (orderSheet == 65)) {
							// .equals("tomato") || ingredients.equals("patty")) {
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

					orderBurger.add((List<Object>) ingredients);

					break;
				} // if
			} // for
//			System.out.println("\n");
		}
		if(obnoxious!=4) {
			List<Object> ingredients = new ArrayList<Object>();
			System.out.println("����");
			ingredients.add("topBread"); // �ܹ��� ��� �̹���
			ingredients.add(ordertopBreadImage); // �ܹ��� ��� �̹���
			
			// x, y��ǥ �߰� 
			ingredients.add(145);
			ingredients.add(30);

			orderBurger.add((List<Object>) ingredients);
			
		}
//		System.out.println(orderBurger.size());
	}

	//�մ� Thread
	public void run() {
//			System.out.println("asdf");
		try {
			G = true;
			while (y != 136) {
				y += 1;
//				System.out.println(y);
//				System.out.println(G);
				BurgerMi.game.revalidate();
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