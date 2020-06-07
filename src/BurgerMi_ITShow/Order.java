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
	
	public Image[] orderImageArray =
		{ OderTopSesameBread, OrderBelowSesamebread, OrderTopBread, 
		  OrderBelowBread, OrderMoringTopBread, OrderMoringBelowBread, // 빵
		  OrderCheese, OrderPatty, OrderTomato, OrderLettuce,	OrderEgg, OrderOnion, // 속재료
		  CheeseStick, ChickenNuggets, FrenchFries, Icecream, // 사이드 메뉴
		  Coke, Sprite, Fanta, Coffee, orangeJuice // 음료
		};

	
	public List<Object> orderBurger = new LinkedList<Object>(); //주문 버거 이미지, 좌표
	public List<Object> burgerIngredient; // 햄버거 재료별 임시 이미지, 좌표

	int[] orderBurgerArray; // 햄버거 재료 int형
	int who, y;
	LinkedList menu;
	int drink, side;
	int[] orderSheet = new int[3];

	public Order(DB db) {
		this.db = db;
	}
	
	public void Order(int i) {
		burgerIngredient = new LinkedList<Object>();
		// 햄버거 재료 위치 조정
		int y = 160 - 25 * i;
		burgerIngredient.add(orderImageArray[orderSheet[i]]);
		switch (orderSheet[i]) {
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
			menu = db.RandomOrder(1); // 주문 랜덤
			
			if(menu.get(3).equals("단품")) { // 단품일 때
				int cnt = (int) (Math.random() * 3); // 주문 갯수
				// 단품 중 주문 갯수만큼 랜덤
				LinkedList order = db.RandomOrder(cnt);
				orderSheet[i] = order;
			} else { // 세트일 때
				menu = 5; // 1.음료 2.사이드메뉴
				// 음료, 사이드메뉴 랜덤
				for(int i=0; i<2; i++, side--) {
					int order = (int) (Math.random() * menu);
					orderSheet[i] = order;
				}
			}
			
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