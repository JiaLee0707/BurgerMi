package BurgerMi__66;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public class Order extends Thread {
	// 만들때 사용하는 버거
	private Image TrayImage = new ImageIcon("src/images/쟁반111.png").getImage();
	private Image belowBreadImage = new ImageIcon("src/images/아래빵.png").getImage();
	private Image topBreadImage = new ImageIcon("src/images/윗빵.png").getImage();
	private Image lettuceImage = new ImageIcon("src/images/채소.png").getImage();
	private Image tomatoImage = new ImageIcon("src/images/토마토.png").getImage();
	private Image pattyImage = new ImageIcon("src/images/패티.png").getImage();
	private Image cheeseImage = new ImageIcon("src/images/치즈.png").getImage();

	// 주문받은 버거
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

	// 손님
	private Image guest1 = new ImageIcon("src/images/11.png").getImage();
	private Image guest2 = new ImageIcon("src/images/22.png").getImage();
	private Image guest3 = new ImageIcon("src/images/33.png").getImage();
	private Image guest4 = new ImageIcon("src/images/44.png").getImage();
	private Image guest5 = new ImageIcon("src/images/55.png").getImage();
	private Image guest6 = new ImageIcon("src/images/66.png").getImage();

	public Image[] guestArray = { guest1, guest2, guest3, guest4, guest5, guest6 };
	public int guest, y = 100;
	public boolean G = false;

	Random random = new Random();

	// 주문받은 버거
	List<Object> orderBurger = new ArrayList<Object>();
	// 만든 버거
	List<Object> MakeBurger = new ArrayList<Object>();

	public List<Object> ingredients;

	Order() {
		System.out.println("order");
		int keySheet[] = { 65, 68, 69, 81, 83, 87 };

		while (orderBurger.size() != 5) {
			List<Object> ingredients = new ArrayList<Object>();
			int i = 0;
			int orderSheet = (int) ((Math.random() * 86) + 65);

			// 햄버거 재료 위치 초기화
			int xx = 0, yy = 150;

			for (i = 0; i < keySheet.length; i++) {
				if (orderSheet == keySheet[i]) {
					switch (orderSheet) {
					case 65: // 패티
						System.out.println("패티");
						ingredients.add("patty"); // 햄버거 재료 이미지
						ingredients.add(orderpattyImage); // 햄버거 재료 이미지
						xx = 500; // 햄버거 재료 x좌표
						break;
					case 68: // 상추
						System.out.println("상추");
						ingredients.add("lettuce"); // 햄버거 재료 이미지
						ingredients.add(orderlettuceImage); // 햄버거 재료 이미지
						xx = 495; // 햄버거 재료 x좌표
						break;
					case 69: // 치즈
						System.out.println("치즈");
						ingredients.add("cheese"); // 햄버거 재료 이미지
						ingredients.add(ordercheeseImage); // 햄버거 재료 이미지
						xx = 495; // 햄버거 재료 x좌표
						break;
					case 81: // 토마토
						System.out.println("토마토");
						ingredients.add("tomato"); // 햄버거 재료 이미지
						ingredients.add(ordertomatoImage); // 햄버거 재료 이미지
						xx = 510; // 햄버거 재료 x좌표
						break;
					case 83: // 밑빵
						System.out.println("밑빵");
						ingredients.add("belowBread"); // 햄버거 재료 이미지
						ingredients.add(orderbelowBreadImage);// 햄버거 재료 이미지
						xx = 520; // 햄버거 재료 x좌표
						break;
					case 87: // 윗빵
						System.out.println("윗빵");
						ingredients.add("topBread"); // 햄버거 재료 이미지
						ingredients.add(ordertopBreadImage); // 햄버거 재료 이미지
						xx = 500; // 햄버거 재료 x좌표
						break;
					}

					// 재료 순서에 따른 y좌표
					if (orderBurger.size() + 1 > 1) {
						yy = yy - (20 * (orderBurger.size() + 1));
						// 토마토 또는 패티면 30 더 밑으로
						if ((orderSheet == 81) || (orderSheet == 65)) {
							// .equals("tomato") || ingredients.equals("patty")) {
							yy = yy + 20;
						}
						// 윗빵이면 50 더 위로
						else if (orderSheet == 87) {
							yy = yy - 60;
						}
					}

					// x, y좌표 추가
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

	

	// 손님
	public void Guest() {
		guest = (int) (Math.random() * 6);
	}

	public void run() {
//			System.out.println("asdf");
		try {
			G = true;
			while (y != 136) {
				y += 1;
//				System.out.println(y);
//				System.out.println(G);
				BurgerMi.game.repaint();
				Thread.sleep(10);
			}
			G = false;
		} catch (Exception e) {
//			e.printStackTrace();
			e.getMessage();
		}
	}

	// 햄버거 만들기
	public void Make(String key) {
		new Music("203.mp3", false).start();

		// 햄버거 재료 위치 초기화
		int xx = 0, yy = 500;
		Image ingredients = null;

		// 햄버거 재료 x좌표, 이미지
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
		// 재료 순서에 따른 y좌표
		if (MakeBurger.size() + 1 > 1) {
			yy = yy - (20 * (MakeBurger.size() + 1));
			// 토마토 또는 패티면 30 더 밑으로
			if (key.equals("tomato") || key.equals("patty")) {
				yy = yy + 30;
			}
			// 윗빵이면 50 더 위로
			else if (key.equals("topBread")) {
				yy = yy - 50;
			}
		}

		BurgerMi.game.burger = new Burger(xx, yy, ingredients, key);
		BurgerMi.game.burger.start();

	}

}