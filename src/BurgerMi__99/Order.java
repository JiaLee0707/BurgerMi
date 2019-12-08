package BurgerMi__99;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public class Order extends Thread {
	Random random = new Random();

	// 만들때 사용하는 버거
	private Image belowBreadImage = new ImageIcon("src/images/아래빵.png").getImage();
	private Image topBreadImage = new ImageIcon("src/images/윗빵.png").getImage();
	private Image lettuceImage = new ImageIcon("src/images/채소.png").getImage();
	private Image tomatoImage = new ImageIcon("src/images/토마토.png").getImage();
	private Image pattyImage = new ImageIcon("src/images/패티.png").getImage();
	private Image cheeseImage = new ImageIcon("src/images/치즈.png").getImage();

	// 주문받은 버거
	private Image orderTrayImage = new ImageIcon("src/images/Order아래빵.png").getImage();
	private Image orderbelowBreadImage = new ImageIcon("src/images/Order아래빵.png").getImage();
	private Image ordertopBreadImage = new ImageIcon("src/images/Order윗빵.png").getImage();
	private Image orderlettuceImage = new ImageIcon("src/images/Order채소.png").getImage();
	private Image ordertomatoImage = new ImageIcon("src/images/Order토마토.png").getImage();
	private Image orderpattyImage = new ImageIcon("src/images/Order패티.png").getImage();
	private Image ordercheeseImage = new ImageIcon("src/images/Order치즈.png").getImage();

	// 손님
	private Image guest1 = new ImageIcon("src/images/11.png").getImage();
	private Image guest2 = new ImageIcon("src/images/22.png").getImage();
	private Image guest3 = new ImageIcon("src/images/33.png").getImage();
	private Image guest4 = new ImageIcon("src/images/44.png").getImage();
	private Image guest5 = new ImageIcon("src/images/55.png").getImage();
	private Image guest6 = new ImageIcon("src/images/66.png").getImage();
	public Image[] guestArray = { guest1, guest2, guest3, guest4, guest5, guest6 };

	public int guest, y = 100; // (랜덤)손님 이미지, 손님 y좌표
	public boolean G = false; // 손님 입장(boolean)
	int obnoxious; // (랜덤)진상 손님

	List<Object> orderBurger = new ArrayList<Object>(); // 주문받은 버거
	List<Object> MakeBurger = new ArrayList<Object>(); // 만든 버거

	Order() {
		int keySheet[] = { 65, 68, 69, 81, 83, 87 };

		// 손님 이미지 랜덤
		guest = (int) (Math.random() * 6);
		// 진상손님 랜덤
		obnoxious = (int) (Math.random() * 6);

		int ii = 0; // 햄버거 재료 개수 조절(0 or 1)

		// 진상손님이 아니면 (밑빵 추가)
		if (obnoxious != 4) {
			// 햄버거 재료 하나의 이미지, 좌표 (Vector)
			List<Object> ingredients = new ArrayList<Object>();
			ingredients.add("belowBread"); // 햄버거 재료 이미지
			ingredients.add(orderbelowBreadImage);// 햄버거 재료 이미지

			// x, y좌표 추가
			ingredients.add(160);
			ingredients.add(150);
			System.out.println("밑빵");

			// 햄버거에 재료 이미지, 좌표 추가
			orderBurger.add((List<Object>) ingredients);

			ii = 1;
		}

		// 햄버거 재료가 5개가 될때까지 반복
		// 진상손님이면 햄버거 재료 5개 랜덤
		// 진상손님이 아니면 // 이미 들어가 있는 윗빵 제외하여 4개가 될 때까지 랜덤
		while (orderBurger.size() != 5 - ii) {
			// 햄버거 재료 하나의 이미지, 좌표 (Vector)
			List<Object> ingredients = new ArrayList<Object>();
			// 햄버거 재료 랜덤
			int orderSheet = (int) ((Math.random() * 86) + 65);

			// 햄버거 재료 위치 초기화
			int xx = 0, yy = 160;

			// 햄버거 재료 랜덤
			for (int i = 0; i < keySheet.length; i++) {
				// 진상손님이 아니면 햄버거 밑빵,윗빵 제외
				if (obnoxious != 4 && ((orderSheet == 83) || (orderSheet == 87))) {
					break;
				}
				// 랜덤에 햄버거 재료가 있으면
				if (orderSheet == keySheet[i]) {
					switch (orderSheet) {
					case 65: // 패티
						System.out.println("패티");
						ingredients.add("patty"); // 햄버거 재료
						ingredients.add(orderpattyImage); // 햄버거 재료 이미지
						xx = 140; // 햄버거 재료 x좌표
						break;
					case 68: // 상추
						System.out.println("상추");
						ingredients.add("lettuce"); // 햄버거 재료
						ingredients.add(orderlettuceImage); // 햄버거 재료 이미지
						xx = 138; // 햄버거 재료 x좌표
						break;
					case 69: // 치즈
						System.out.println("치즈");
						ingredients.add("cheese"); // 햄버거 재료
						ingredients.add(ordercheeseImage); // 햄버거 재료 이미지
						xx = 138; // 햄버거 재료 x좌표
						break;
					case 81: // 토마토
						System.out.println("토마토");
						ingredients.add("tomato"); // 햄버거 재료
						ingredients.add(ordertomatoImage); // 햄버거 재료 이미지
						xx = 150; // 햄버거 재료 x좌표
						break;
					case 83: // 밑빵
						System.out.println("밑빵");
						ingredients.add("belowBread"); // 햄버거 재료
						ingredients.add(orderbelowBreadImage);// 햄버거 재료 이미지
						xx = 160; // 햄버거 재료 x좌표
						break;
					case 87: // 윗빵
						System.out.println("윗빵");
						ingredients.add("topBread"); // 햄버거 재료
						ingredients.add(ordertopBreadImage); // 햄버거 재료 이미지
						xx = 145; // 햄버거 재료 x좌표
						break;
					}

					// 재료 순서에 따른 y좌표
					if (orderBurger.size() + 1 > 1) {
						yy = yy - (20 * (orderBurger.size() + 1));
						// 토마토 또는 패티면 40 더 밑으로
						if ((orderSheet == 81) || (orderSheet == 65)) {
							yy = yy + 40;
						}
						// 윗빵이면 45 더 위로
						else if (orderSheet == 87) {
							yy = yy - 45;
						}
					}

					// x, y좌표 추가
					ingredients.add(xx);
					ingredients.add(yy);

					// 햄버거 재료 이미지, 좌표에 추가
					orderBurger.add((List<Object>) ingredients);

					break;
				} // if
			} // for
		} // while

		// 진상손님이 아니면 (윗빵 추가)
		if (obnoxious != 4) {
			// 햄버거 재료 하나의 이미지, 좌표 (Vector)
			List<Object> ingredients = new ArrayList<Object>();
			ingredients.add("topBread"); // 햄버거 재료 이미지
			ingredients.add(ordertopBreadImage); // 햄버거 재료 이미지
			System.out.println("윗빵");

			// x, y좌표 추가
			ingredients.add(145);
			ingredients.add(30);

			// 햄버거 재료 이미지, 좌표에 추가
			orderBurger.add((List<Object>) ingredients);

		}
	}

	// 손님 Thread
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

	// 햄버거 만들기
	public void Make(String key) {
		new Music("203.mp3", false).start();

		// 햄버거 재료 위치 초기화
		int xx = 0, yy = 500;
		Image ingredients = null;

		// 햄버거 재료 x좌표, 이미지
		switch (key) {
		case "belowBread": // 밑빵
			xx = 500;
			ingredients = belowBreadImage;
			break;
		case "topBread": // 윗빵
			xx = 480;
			ingredients = topBreadImage;
			break;
		case "lettuce": // 상추
			xx = 475;
			ingredients = lettuceImage;
			break;
		case "tomato": // 토마토
			xx = 490;
			ingredients = tomatoImage;
			break;
		case "patty": // 패티
			xx = 480;
			ingredients = pattyImage;
			break;
		case "cheese": // 치즈
			xx = 475;
			ingredients = cheeseImage;
			break;
		}

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

		// 햄버거 재료, 좌표 초기화
		BurgerMi.game.burger = new Burger(xx, yy, ingredients, key);
		BurgerMi.game.burger.start(); // 햄버거 내려오는 쓰레드

		return;
	}

}