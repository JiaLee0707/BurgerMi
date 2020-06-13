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
	LinkedList menu; // 임시 주문 LinkedList
	String[] burgerIngredient;	// 햄버거 레시피
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
		x = 20;
		y = 20;
		for (int i = 0; i < orderSheet.size(); i++) {
			String ingredients = orderSheet.get(i)[1];
			String[] array = ingredients.split(";");	// 주문표 자르기

//			System.out.println(orderSheet.size());
			for (int j = 0; j < array.length; j++, x += 10) {
				Ingredient = new LinkedList<Object>();
//				System.out.println(array[j]);
				
				// 주문표에 햄버거가 있을 경우
				if (Arrays.stream(burger).anyMatch(array[j]::equals)) {
					// DB로 주문 레시피 재료 가져오기
					burgerIngredient = db.recipes(array[j]);
					for (String ing : burgerIngredient) {
						Ingredient = new LinkedList<Object>();
//						System.out.println(ing);
//						System.out.println(hamMap.get(ing));
						Ingredient.add(hamMap.get(ing));
						Ingredient.add(x);
						Ingredient.add(y);
						orderBurger.add((List<Object>) Ingredient);
						x += 10;
					}
				} else {	// 햄버거가 아니면 그냥 추가
					System.out.println(hamMap.get(array[j]));
					Ingredient.add(hamMap.get(array[j]));
					Ingredient.add(x);
					Ingredient.add(y);
					orderBurger.add((List<Object>) Ingredient);
				}
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
			menu = db.RandomOrder(1); // 주문 랜덤
			orderSheet = menu;

			if (orderSheet.get(0)[3].equals("단품")) { // 단품일 때
				int cnt = (int) (Math.random() * 2) + 1; // 주문 갯수
				// 단품 중 주문 갯수만큼 랜덤
				System.out.println("주문 갯수 : " + cnt);
				if (cnt != 1) {
					menu = db.RandomOrder(cnt - 1);
					String[] m = null;
					for (int i = 0; i < cnt - 1; i++) {
//						System.out.println((String[]) menu.get(i));
//						for(int j=0; j<5; j++) {
						m = (String[]) menu.get(i);
//						}
						orderSheet.add(m);
					}
				}
			} else { // 세트일 때
				// 1.음료 2.사이드메뉴
				// 음료, 사이드메뉴 랜덤
				String[] kind = { "음료", "사이드 메뉴" };
				for (int i = 0; i < 2; i++) {
					menu = db.RandomOrder(1, kind[i]);
//					if(((String[])menu.get(i))[4].equals("음료")) {
//					System.out.println("바꾸기 전 " + orderSheet.get(i)[1]);
					String changeMenu = (orderSheet.get(0)[1]).replace(kind[i], ((String[]) menu.get(0))[0]);
//					System.out.println(changeMenu);
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