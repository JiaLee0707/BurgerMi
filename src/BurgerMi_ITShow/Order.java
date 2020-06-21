package BurgerMi_ITShow;

import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;

public class Order {
	DB db;
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

	// 주문
	// 빵
	private Image OderTopSesameBread = new ImageIcon("src/images/OderTopSesameBread.png").getImage();
	private Image OrderBelowSesamebread = new ImageIcon("src/images/OrderBelowSesamebread.png").getImage();
	private Image OrderTopBread = new ImageIcon("src/images/OrderTopBread.png").getImage();
	private Image OrderBelowBread = new ImageIcon("src/images/OrderBelowBread.png").getImage();
	private Image OrderMoringTopBread = new ImageIcon("src/images/OrderMoringTopBread.png").getImage();
	private Image OrderMoringBelowBread = new ImageIcon("src/images/OrderMoringBelowBread.png").getImage();
	// 속재료
	private Image OrderCheese = new ImageIcon("src/images/OrderCheese.png").getImage();
	private Image OrderPatty = new ImageIcon("src/images/OrderPatty.png").getImage();
	private Image OrderTomato = new ImageIcon("src/images/OrderTomato.png").getImage();
	private Image OrderLettuce = new ImageIcon("src/images/OrderLettuce.png").getImage();
	private Image OrderEgg = new ImageIcon("src/images/OrderEgg.png").getImage();
	private Image OrderOnion = new ImageIcon("src/images/OrderOnion.png").getImage();
	// 사이드메뉴
	private Image CheeseStick = new ImageIcon("src/images/CheeseStick.png").getImage();
	private Image ChickenNuggets = new ImageIcon("src/images/ChickenNuggets.png").getImage();
	private Image FrenchFries = new ImageIcon("src/images/FrenchFries.png").getImage();
	private Image Icecream = new ImageIcon("src/images/Icecream.png").getImage();
	// 음료
	private Image Coke = new ImageIcon("src/images/Coke.png").getImage();
	private Image Sprite = new ImageIcon("src/images/Sprite.png").getImage();
	private Image Fanta = new ImageIcon("src/images/Fanta.png").getImage();
	private Image Coffee = new ImageIcon("src/images/Coffee.png").getImage();
	private Image orangeJuice = new ImageIcon("src/images/orangeJuice.png").getImage();

	// 햄버거 배열
	public String[] burger = { "계란 머핀", "모닝 머핀", "토마토햄 머핀", "햄모닝 머핀", "계란치즈 버거", "더블치즈 버거", "디폴트 버거", "불고기 버거",
			"오버플로 버거", "채식 버거", "치즈 버거", "함박 버거" };

	public HashMap<String, Image> hamMap = new HashMap<String, Image>();

	public List<Object> orderBurger = new LinkedList<Object>(); // 주문 이미지, 좌표
	public List<Object> Ingredient; // 주문 재료별 임시 이미지, 좌표

	List<String[]> orderSheet = new LinkedList<String[]>(); // 주문표
	LinkedList<String[]> burgerIngredient = new LinkedList<String[]>(); // 햄버거 레시피
	public int price = 0;

	int who, x, y;

	public Order(DB db) {
		this.db = db;

		// 메뉴 이미지들
		hamMap.put("깨윗빵", OderTopSesameBread);
		hamMap.put("깨아래빵", OrderBelowSesamebread);
		hamMap.put("기본윗빵", OrderTopBread);
		hamMap.put("기본아래빵", OrderBelowBread);
		hamMap.put("모닝윗빵", OrderMoringTopBread);
		hamMap.put("모닝아래빵", OrderMoringBelowBread);

		hamMap.put("치즈", OrderCheese);
		hamMap.put("패티", OrderPatty);
		hamMap.put("토마토", OrderTomato);
		hamMap.put("양상추", OrderLettuce);
		hamMap.put("계란", OrderEgg);
		hamMap.put("양파", OrderOnion);

		hamMap.put("치즈스틱", CheeseStick);
		hamMap.put("치킨너겟", ChickenNuggets);
		hamMap.put("감자튀김", FrenchFries);
		hamMap.put("아이스크림", Icecream);

		hamMap.put("콜라", Coke);
		hamMap.put("사이다", Sprite);
		hamMap.put("환타", Fanta);
		hamMap.put("커피", Coffee);
		hamMap.put("오렌지 주스", orangeJuice);
	}

	public void Order() {
		x = 40;
		y = 55;
//		y = 160 - 25 * i;
		for (int i = 0; i < orderSheet.size(); i++, x += 10) {
			// 세트일 때
			if (!orderSheet.get(i)[1].equals("")) {

				String ingredients = orderSheet.get(i)[1];
				String[] ingredientsArray = ingredients.split(";"); // 주문표 자르기

				for (int j = 0; j < ingredientsArray.length; j++, x += 10) {
					Ingredient = new LinkedList<Object>();

					// 햄버거인 경우
					if (Arrays.stream(burger).anyMatch(ingredientsArray[j]::equals)) {
						// DB로 주문 레시피 재료 가져오기
						String array[] = db.recipes(ingredientsArray[j]);

						for (int a = 0; a < array.length; a++) {
							System.out.println(array[a]);
						}

						burgerIngredient.add(array); // 단품으로 햄버거가 여러개일 경우
														// 햄버거별 재료 목록 저장

						for(int z=0; z<burgerIngredient.size(); z++) {
							Ingredient = new LinkedList<Object>();
							Ingredient.add(hamMap.get(burgerIngredient.get(z)));
							Ingredient.add(x);
							Ingredient.add(y);
							orderBurger.add((List<Object>) Ingredient);
							y -= 10;							
						}
						
						for (String ing : (String[]) burgerIngredient.get(burgerIngredient.size() - 1)) {
							Ingredient = new LinkedList<Object>();
							Ingredient.add(hamMap.get(ing));
							Ingredient.add(x);
							Ingredient.add(y);
							orderBurger.add((List<Object>) Ingredient);
							y -= 10;
						}
					} else { // 햄버거가 아니면 그냥 추가
						System.out.println(hamMap.get(ingredientsArray[j]));
						Ingredient.add(hamMap.get(ingredientsArray[j]));
						Ingredient.add(x);
						Ingredient.add(y);
						orderBurger.add((List<Object>) Ingredient);
					}
				}
			} else { // 단품일 때
				String ingredients = orderSheet.get(i)[0];
				Ingredient = new LinkedList<Object>();

				// 햄버거인 경우
				if (Arrays.stream(burger).anyMatch(ingredients::equals)) {
					// DB로 주문 레시피 재료 가져오기
					String array[] = db.recipes(ingredients);

					burgerIngredient.add(array); // 단품으로 햄버거가 여러개일 경우
													// 햄버거별 재료 목록 저장

					for (String ing : (String[]) burgerIngredient.get(burgerIngredient.size() - 1)) {
						Ingredient = new LinkedList<Object>();
						Ingredient.add(hamMap.get(ing));
						Ingredient.add(x);
						Ingredient.add(y);
						orderBurger.add((List<Object>) Ingredient);
						y -= 10;
					}
				} else { // 햄버거가 아니면 그냥 추가
					System.out.println(hamMap.get(orderSheet.get(i)[0]));
					Ingredient.add(hamMap.get(orderSheet.get(i)[0]));
					Ingredient.add(x);
					Ingredient.add(y);
					orderBurger.add((List<Object>) Ingredient);
				}

			}
		}

		for (int i = 0; i < burgerIngredient.size(); i++) {
			System.out.println("burger");
			for (int j = 0; j < burgerIngredient.get(i).length; j++) {
				System.out.println(burgerIngredient.get(i)[j]);

			}
		}
	}

	class Guest extends Thread {
		public Guest() {
			who = (int) (Math.random() * 6); // 손님 랜덤

			thisGuest = guestArray[who];
			y = 100; // 손님 y좌표

			order(); // 주문 랜덤 메소드 호출
		}

		public void order() {
			LinkedList<String[]> menu; // 임시 주문 LinkedList

			orderSheet = db.RandomOrder(1); // 주문 랜덤

			if (orderSheet.get(0)[3].equals("단품")) { // 단품일 때
				int cnt = (int) (Math.random() * 2) + 1; // 주문 갯수
				// 단품 중 주문 갯수만큼 랜덤
				System.out.println("주문 갯수 : " + cnt);
				if (cnt != 1) {

					do {
						menu = db.RandomOrder(cnt - 1);
					} while (menu.get(0)[3].equals("세트"));

//					if (menu.get(0)[3].equals("세트")) {
//						String[] kind = { "음료", "사이드 메뉴" };
//						LinkedList<String[]> menu2; 
//						for (int i = 0; i < 2; i++) {
//							menu2 = db.RandomOrder(1, kind[i]);
//							String changeMenu = (menu.get(0)[1]).replace(kind[i], ((String[]) menu2.get(0))[0]);
//							String[] change = new String[4];
//							change[0] = menu.get(0)[0];
//							change[1] = changeMenu;
//							change[2] = menu.get(0)[2];
//							change[3] = menu.get(0)[3];
//							orderSheet.set(0, change);
//						}
//					}
					String[] m = null;
					for (int i = 0; i < cnt - 1; i++) {
						m = (String[]) menu.get(i);
						orderSheet.add(m);
					}
				}
				for (int i = 0; i < orderSheet.size(); i++) {
					price += Integer.parseInt(orderSheet.get(i)[2]);
				}
			} else { // 세트일 때
				// 음료, 사이드메뉴 랜덤
				price += Integer.parseInt(orderSheet.get(0)[2]);
				String[] kind = { "음료", "사이드 메뉴" };
				for (int i = 0; i < 2; i++) {
					menu = db.RandomOrder(1, kind[i]);
					String changeMenu = (orderSheet.get(0)[1]).replace(kind[i], ((String[]) menu.get(0))[0]);
					String[] change = new String[4];
					change[0] = orderSheet.get(0)[0];
					change[1] = changeMenu;
					change[2] = orderSheet.get(0)[2];
					change[3] = orderSheet.get(0)[3];
					orderSheet.set(0, change);
				}

			}
			System.out.print("총 주문은 : ");
			for (int i = 0; i < orderSheet.size(); i++) {
				for (int j = 0; j < 4; j++) {
					System.out.print(orderSheet.get(i)[j] + "    ");
				}
			}
			System.out.println("가격 : " + price);
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