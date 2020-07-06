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
	private Image OderTopSesameBread = new ImageIcon("src/images/TopSesameBread.png").getImage();
	private Image OrderBelowSesamebread = new ImageIcon("src/images/BelowSesamebread.png").getImage();
	private Image OrderTopBread = new ImageIcon("src/images/TopBread.png").getImage();
	private Image OrderBelowBread = new ImageIcon("src/images/BelowBread.png").getImage();
	private Image OrderMoringTopBread = new ImageIcon("src/images/MoringTopBread.png").getImage();
	private Image OrderMoringBelowBread = new ImageIcon("src/images/MoringBelowBread.png").getImage();
	// 속재료
	private Image OrderCheese = new ImageIcon("src/images/Cheese.png").getImage();
	private Image OrderPatty = new ImageIcon("src/images/Patty.png").getImage();
	private Image OrderTomato = new ImageIcon("src/images/Tomato.png").getImage();
	private Image OrderLettuce = new ImageIcon("src/images/Lettuce.png").getImage();
	private Image OrderEgg = new ImageIcon("src/images/Egg.png").getImage();
	private Image OrderOnion = new ImageIcon("src/images/Onion.png").getImage();
	// 사이드메뉴
	private Image CheeseStick = new ImageIcon("src/images/CheeseStick.png").getImage();
	private Image ChickenNuggets = new ImageIcon("src/images/ChickenNuggets.png").getImage();
	private Image FrenchFries = new ImageIcon("src/images/FrenchFries.png").getImage();
	private Image Icecream = new ImageIcon("src/images/Icecream.png").getImage();
	private Image CheeseBall = new ImageIcon("src/images/CheeseBall.png").getImage();
	private Image Corn = new ImageIcon("src/images/Corn.png").getImage();
	// 음료
	private Image Coke = new ImageIcon("src/images/Coke.png").getImage();
	private Image Sprite = new ImageIcon("src/images/Sprite.png").getImage();
	private Image Fanta = new ImageIcon("src/images/Fanta.png").getImage();
	private Image Coffee = new ImageIcon("src/images/Coffee.png").getImage();
	private Image orangeJuice = new ImageIcon("src/images/OrangeJuice.png").getImage();
	private Image Lemonade = new ImageIcon("src/images/Lemonade.png").getImage();

	// 햄버거 배열
	public String[] burger = { "계란 머핀", "모닝 머핀", "토마토햄 머핀", "햄모닝 머핀", "계란치즈 버거", "더블치즈 버거", "디폴트 버거", "불고기 버거",
			"오버플로 버거", "채식 버거", "치즈 버거", "함박 버거", "채소없는 채식 버거" };

	public HashMap<String, Image> hamMap = new HashMap<String, Image>();
	private HashMap<String, Integer> xMap = new HashMap<String, Integer>();
	private HashMap<String, Integer> yMap = new HashMap<String, Integer>();

	public List<Object> orderBurger = new LinkedList<Object>(); // 주문 이미지, 좌표
	public List<Object> Ingredient; // 주문 재료별 임시 이미지, 좌표

	List<String[]> orderSheet = new LinkedList<String[]>(); // 주문표
	String[] burgerIngredient; // 햄버거 레시피

	public String ingredients;
	public String[] ingredientsArray = null;

	public int price = 0;

	int who, x, y;
	boolean badCustomer;

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
		hamMap.put("치즈볼",CheeseBall);
		hamMap.put("콘샐러드", Corn);

		hamMap.put("콜라", Coke);
		hamMap.put("사이다", Sprite);
		hamMap.put("환타", Fanta);
		hamMap.put("커피", Coffee);
		hamMap.put("오렌지 주스", orangeJuice);

		hamMap.put("탄산없는 콜라", Coke);
		hamMap.put("탄산없는 환타", Fanta);

		// x좌표
		xMap.put("깨윗빵", 17);
		xMap.put("깨아래빵", 23);
		xMap.put("기본윗빵", -15);
		xMap.put("기본아래빵", 3);
		xMap.put("모닝윗빵", -15);
		xMap.put("모닝아래빵", -3);
		xMap.put("치즈", 15);
		xMap.put("패티", 20);
		xMap.put("토마토", 20);
		xMap.put("양상추", 15);
		xMap.put("계란", 1);
		xMap.put("양파", 15);

		// y좌표
		yMap.put("깨윗빵", -43);
		yMap.put("깨아래빵", -5);
		yMap.put("기본윗빵", -43);
		yMap.put("기본아래빵", 0);
		yMap.put("모닝윗빵", -45);
		yMap.put("모닝아래빵", -10);
		yMap.put("치즈", -5);
		yMap.put("패티", 10);
		yMap.put("토마토", 7);
		yMap.put("양상추", -15);
		yMap.put("계란", -17);
		yMap.put("양파", -13);
	}

	public void Order() {
		x = 30;
		y = 160;

		// 세트일 때
		if (!orderSheet.get(0)[1].equals("")) {
			for (int i = 0; i < orderSheet.size(); i++) {
				ingredients = orderSheet.get(i)[1];
				ingredientsArray = ingredients.split(";"); // 주문표 자르기
			}
		}
		// 단품일 때
		else {
			ingredientsArray = new String[orderSheet.size()];
			for (int i = 0; i < orderSheet.size(); i++) {
				ingredientsArray[i] = orderSheet.get(i)[0];
			}

			// 단품일 때 주문 1개이면
			// 위치 가운데
			if (ingredientsArray.length == 1) {
				x = 100;
			}
		}

		// 재료 위치좌표
		for (int i = 0; i < ingredientsArray.length; i++) {
			Ingredient = new LinkedList<Object>();

			// 햄버거인 경우
			if (ingredientsArray[i].contains("버거") || ingredientsArray[i].contains("머핀")) {
				if(i!=0) x -= 20;
				// Arrays.stream(burger).anyMatch(ingredientsArray[i]::equals)) {
				// DB로 주문 레시피 재료 가져오기
				burgerIngredient = db.recipes(ingredientsArray[i]);

				for (int a = 0; a < burgerIngredient.length; a++) {
					System.out.println(burgerIngredient[a]);
				}

				// burgerIngredient.add(array); // 단품으로 햄버거가 여러개일 경우
				// 햄버거별 재료 목록 저장

				if (ingredientsArray[i].contains("오버플로")) {
					int yy = 180;
					for (int z = 0; z < burgerIngredient.length; z++) {
						if (z != 0 && burgerIngredient[z].equals("깨아래빵")) {
							yy -= 18;
						} else if(z<=7 && burgerIngredient[z].equals("패티")) {
							yy -= 13;
						}
						Ingredient = new LinkedList<Object>();
						Ingredient.add(hamMap.get(burgerIngredient[z]));
						Ingredient.add(x + xMap.get(burgerIngredient[z]));
						Ingredient.add(yy + yMap.get(burgerIngredient[z]));
						orderBurger.add((List<Object>) Ingredient);
						yy -= 13;
					}
					x += 185;
					continue;
				}
				
				for (int z = 0; z < burgerIngredient.length; z++) {
					if (z != 0 && burgerIngredient[z].equals("깨아래빵")) {
						y -= 18;
					}
					Ingredient = new LinkedList<Object>();
					Ingredient.add(hamMap.get(burgerIngredient[z]));
					Ingredient.add(x + xMap.get(burgerIngredient[z]));
					Ingredient.add(y + yMap.get(burgerIngredient[z]));
					orderBurger.add((List<Object>) Ingredient);
					y -= 13;
				}
			} else { // 햄버거가 아니면 그냥 추가
				System.out.println(ingredientsArray[i]);
				Ingredient.add(hamMap.get(ingredientsArray[i]));
				Ingredient.add(x);
				Ingredient.add(50);
				orderBurger.add((List<Object>) Ingredient);
			}
			if (!orderSheet.get(0)[1].equals("") && ingredientsArray.length > 2) {
				x += 120;
			} else x += 170;
		}

//		for (int i = 0; i < burgerIngredient.size(); i++) {
//			System.out.println("burger");
//			for (int j = 0; j < burgerIngredient.get(i).length; j++) {
//				System.out.println(burgerIngredient.get(i)[j]);
//
//			}
//		}
	}

	class Guest extends Thread {
		public Guest() {
			who = (int) (Math.random() * 6); // 손님 랜덤

			thisGuest = guestArray[who];
			y = 100; // 손님 y좌표

			order(); // 주문 랜덤 메소드 호출
			Guest();
		}

		public void order() {
			LinkedList<String[]> menu = null; // 임시 주문 LinkedList

			orderSheet = db.RandomOrder(1, "All"); // 주문 랜덤

			if (orderSheet.get(0)[3].contains("진상")) {
				badCustomer = true;
				System.out.println("진상");
			} else {
				badCustomer = false;
				System.out.println("진상X");
			}

			if (orderSheet.get(0)[3].contains("단품")) { // 단품일 때
				int cnt = (int) (Math.random() * 2) + 1; // 주문 갯수
				// 단품 중 주문 갯수만큼 랜덤
				System.out.println("주문 갯수 : " + cnt);
				if (cnt != 1) {
					boolean bool = false;
					do {
						if (badCustomer) {
							menu = db.RandomOrder(cnt - 1, "badCustomer");
						} else {
							menu = db.RandomOrder(cnt - 1, "X");
						}
						for (int i = 0; i < menu.size(); i++) {
							if (!menu.get(i)[0].contains("세트")) {
								bool = true;
							} else {
								bool = false;
								break;
							}
							if (orderSheet.get(0)[0].contains("버거") || orderSheet.get(0)[0].contains("머핀")) {
								if (menu.get(i)[0].contains("버거") || menu.get(i)[0].contains("머핀")) {
									bool = false;
									break;
								}
							}
						}
					} while (!bool);
				}

//					do {
//						menu = db.RandomOrder(cnt - 1);
//					} while (menu.get(0)[3].equals("세트") || Arrays.stream(burger).anyMatch(menu.get(0)[0]::equals));

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

			} else { // 세트일 때
				// 음료, 사이드메뉴 랜덤
				price += Integer.parseInt(orderSheet.get(0)[2]);
				String[] kind = { "음료", "사이드메뉴" };
				for (int i = 0; i < 2; i++) {
					if (badCustomer) {
						menu = db.SideRandomOrder(1, kind[i], "badCustomer");
					} else {
						menu = db.SideRandomOrder(1, kind[i], "X");
					}
					String changeMenu = (orderSheet.get(0)[1]).replace(kind[i], ((String[]) menu.get(0))[0]);
					String[] change = new String[4];
					change[0] = orderSheet.get(0)[0];
					change[1] = changeMenu;
					change[2] = orderSheet.get(0)[2];
					change[3] = orderSheet.get(0)[3];
					orderSheet.set(0, change);
				}

			}
			for (int i = 0; i < orderSheet.size(); i++) {
				price += Integer.parseInt(orderSheet.get(i)[2]);
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