package BurgerMi_ITShow;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Make {

	// 만들때 사용하는 재료
	public Image[] makeBurgerArray;
	// 빵
	private Image topBreadSesameImage = new ImageIcon("src/images/breadTopSesame.png").getImage();
	private Image belowBreadSesameImage = new ImageIcon("src/images/breadBelowSesame.png").getImage();
	private Image topBreadImage = new ImageIcon("src/images/breadTop.png").getImage();
	private Image belowBreadImage = new ImageIcon("src/images/breadBelow.png").getImage();
	private Image MoringTopBreadImage = new ImageIcon("src/images/MoringTopBread.png").getImage();
	private Image MoringBelowBreadImage = new ImageIcon("src/images/MoringBelowBread.png").getImage();
	public Image[] makeBreadImageArray = { topBreadSesameImage, topBreadImage, MoringTopBreadImage,
			belowBreadSesameImage, belowBreadImage, MoringBelowBreadImage };
	// 속재료
	private Image lettuceImage = new ImageIcon("src/images/lettuce.png").getImage();
	private Image tomatoImage = new ImageIcon("src/images/tomato.png").getImage();
	private Image pattyImage = new ImageIcon("src/images/patty.png").getImage();
	private Image cheeseImage = new ImageIcon("src/images/cheese.png").getImage();
	private Image eggImage = new ImageIcon("src/images/egg.png").getImage();
	private Image onionImage = new ImageIcon("src/images/onion.png").getImage();
	public Image[] makeIngredientImageArray = { lettuceImage, tomatoImage, pattyImage, cheeseImage, eggImage,
			onionImage };
	// 사이드메뉴
	private Image CheeseStice = new ImageIcon("src/images/CheeseStick.png").getImage();
	private Image ChickenNuggets = new ImageIcon("src/images/ChickenNuggets.png").getImage();
	private Image FrenchFries = new ImageIcon("src/images/FrenchFries.png").getImage();
	private Image Icecream = new ImageIcon("src/images/Icecream.png").getImage();
	private Image CheeseBall = new ImageIcon("src/images/CheeseBall.png").getImage();
	private Image Corn = new ImageIcon("src/images/Corn.png").getImage();
	public Image[] makeSideImageArray = { CheeseStice, ChickenNuggets, FrenchFries, Icecream, CheeseBall, Corn };
	// 음료
	private Image Coke = new ImageIcon("src/images/Coke.png").getImage();
	private Image Sprite = new ImageIcon("src/images/Sprite.png").getImage();
	private Image Fanta = new ImageIcon("src/images/Fanta.png").getImage();
	private Image Coffee = new ImageIcon("src/images/Coffee.png").getImage();
	private Image orangeJuice = new ImageIcon("src/images/orangeJuice.png").getImage();
	private Image Lemonade = new ImageIcon("src/images/Lemonade.png").getImage();
	public Image[] makeDrinkImageArray = { Coke, Sprite, Fanta, Coffee, orangeJuice, Lemonade };

	// 재료대 음식
	public Image[] IngredientsImage;
	// 빵
	private Image smallTopBreadSesameImage = new ImageIcon("src/images/smallBreadTopSesame.png").getImage();
	private Image smallBelowBreadSesameImage = new ImageIcon("src/images/smallBreadBelowSesame.png").getImage();
	private Image smallTopBreadImage = new ImageIcon("src/images/smallBreadTop.png").getImage();
	private Image smallBelowBreadImage = new ImageIcon("src/images/smallBreadBelow.png").getImage();
	private Image smallMorinTopBreadImage = new ImageIcon("src/images/smallMoringBreadTop.png").getImage();
	private Image smallMorinBelowBreadImage = new ImageIcon("src/images/smallMoringBreadBelow.png").getImage();
	public Image[] ingrdientsBreadImageArray = { smallTopBreadSesameImage, smallTopBreadImage, smallMorinTopBreadImage,
			smallBelowBreadSesameImage, smallBelowBreadImage, smallMorinBelowBreadImage };
	// 속재료
	private Image smalllettuceImage = new ImageIcon("src/images/smalllettuce.png").getImage();
	private Image smalltomatoImage = new ImageIcon("src/images/smalltomato.png").getImage();
	private Image smallpattyImage = new ImageIcon("src/images/smallpatty.png").getImage();
	private Image smallcheeseImage = new ImageIcon("src/images/smallcheese.png").getImage();
	private Image smalleggImage = new ImageIcon("src/images/smallegg.png").getImage();
	private Image smallonionImage = new ImageIcon("src/images/smallonion.png").getImage();
	public Image[] IngredientImageArray = { smalllettuceImage, smalltomatoImage, smallpattyImage, smallcheeseImage,
			smalleggImage, smallonionImage };
	// 사이드메뉴
	private Image smallCheeseStick = new ImageIcon("src/images/smallCheeseStick.png").getImage();
	private Image smallChickenNuggets = new ImageIcon("src/images/smallChickenNuggets.png").getImage();
	private Image smallFrenchFries = new ImageIcon("src/images/smallFrenchFries.png").getImage();
	private Image smallIcecream = new ImageIcon("src/images/smallIcecream.png").getImage();
	private Image smallCheeseBall = new ImageIcon("src/images/smallCheeseBall.png").getImage();
	private Image smallCorn = new ImageIcon("src/images/smallCorn.png").getImage();
	public Image[] IngredientSideImageArray = { smallCheeseStick, smallChickenNuggets, smallFrenchFries, smallIcecream,
			smallCheeseBall, smallCorn };
	// 음료
	private Image smallCoke = new ImageIcon("src/images/smallCoke.png").getImage();
	private Image smallSprite = new ImageIcon("src/images/smallSprite.png").getImage();
	private Image smallFanta = new ImageIcon("src/images/smallFanta.png").getImage();
	private Image smallCoffee = new ImageIcon("src/images/smallCoffee.png").getImage();
	private Image smallorangeJuice = new ImageIcon("src/images/smallOrangeJuice.png").getImage();
	private Image smallLemonade = new ImageIcon("src/images/smallLemonade.png").getImage();
	public Image[] IngredientDrinkImageArray = { smallCoke, smallSprite, smallFanta, smallCoffee, smallorangeJuice,
			smallLemonade };

	public HashMap<Image, String> hamMap = new HashMap<Image, String>();

	public JLabel[] name = new JLabel[6];
	public Font font1 = new Font("HY얕은샘물M", Font.BOLD, 25);

	public LinkedList<Object> MakeInformation = new LinkedList<Object>(); // 만드는 재료의 이미지와 좌표 정보
	public LinkedList<String> MakeOrderSheetArray = new LinkedList<String>(); // 주문 리스트
	public LinkedList<String> MakeBurgerArray = new LinkedList<String>(); // 햄버거 재료 리스트
	public LinkedList<Object> Ingredient;
	public LinkedList<Integer> i = new LinkedList<Integer>();

	private HashMap<String, Integer> xMap = new HashMap<String, Integer>();
	private HashMap<String, Integer> yMap = new HashMap<String, Integer>();
	int x, y; // 햄버거 x, y, i 좌표

	int key = 0;
	int[] burgerCountArray = new int[2];
//	int burgerCo unt = 0;

	public Make() {
		for (int i = 0; i < name.length; i++) {
			name[i] = new JLabel();
		}

		hamMap.put(topBreadSesameImage, "깨윗빵");
		hamMap.put(belowBreadSesameImage, "깨아래빵");
		hamMap.put(topBreadImage, "기본윗빵");
		hamMap.put(belowBreadImage, "기본아래빵");
		hamMap.put(MoringTopBreadImage, "모닝윗빵");
		hamMap.put(MoringBelowBreadImage, "모닝아래빵");

		hamMap.put(cheeseImage, "치즈");
		hamMap.put(pattyImage, "패티");
		hamMap.put(tomatoImage, "토마토");
		hamMap.put(lettuceImage, "양상추");
		hamMap.put(eggImage, "계란");
		hamMap.put(onionImage, "양파");

		hamMap.put(CheeseStice, "치즈스틱");
		hamMap.put(ChickenNuggets, "치킨너겟");
		hamMap.put(FrenchFries, "감자튀김");
		hamMap.put(Icecream, "아이스크림");
		hamMap.put(CheeseBall, "치즈볼");
		hamMap.put(Corn, "콘샐러드");

		hamMap.put(Coke, "콜라");
		hamMap.put(Sprite, "사이다");
		hamMap.put(Fanta, "환타");
		hamMap.put(Coffee, "커피");
		hamMap.put(orangeJuice, "오렌지 주스");
		hamMap.put(Lemonade, "레모네이드");

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
		yMap.put("기본아래빵", -15);
		yMap.put("모닝윗빵", -45);
		yMap.put("모닝아래빵", -10);
		yMap.put("치즈", -5);
		yMap.put("패티", 10);
		yMap.put("토마토", 7);
		yMap.put("양상추", -15);
		yMap.put("계란", -17);
		yMap.put("양파", -13);
	}

	public void Ingredients(int ingr) {
		key = ingr;
		int xx = 60;
		int yy = 300;

		switch (key) {
		case 1: // 빵
			makeBurgerArray = makeBreadImageArray; // 만들 이미지
			IngredientsImage = ingrdientsBreadImageArray; // 재료대 이미지
			break;
		case 2: // 속재료
			makeBurgerArray = makeIngredientImageArray;
			IngredientsImage = IngredientImageArray;
			break;
		case 3: // 사이드 메뉴
			makeBurgerArray = makeSideImageArray;
			IngredientsImage = IngredientSideImageArray;
			break;
		case 4: // 음료
			makeBurgerArray = makeDrinkImageArray;
			IngredientsImage = IngredientDrinkImageArray;
			break;
		}

		for (int i = 0; i < IngredientsImage.length; i++, xx += 130) {
			if (i == 3) {
				xx = 60;
				yy += 100;
			}
			name[i].setText(hamMap.get(makeBurgerArray[i]));
			name[i].setBounds(xx, yy, 131, 330);
			name[i].setFont(font1);
			if (key == 4 && (i == 0 || i == 3)) {
				name[i].setForeground(Color.white);
			} else {
				name[i].setForeground(Color.black);
			}
			Main.burgermi.game.add(name[i]);
		}

		Main.burgermi.game.getParent().repaint();
	}

	public void Make(int m) {
		Ingredient = new LinkedList<Object>();
		Ingredient.add(makeBurgerArray[m]);
		if (key < 3) {
			MakeBurgerArray.add(hamMap.get(makeBurgerArray[m])); // 햄버거
			if (key < 2 && m >= 3) { // 밑빵
				burgerCountArray[0]++;
			} else if (key < 2) { // 윗빵
				burgerCountArray[1]++;
			}
		} else {
			MakeOrderSheetArray.add(hamMap.get(makeBurgerArray[m])); // 사이드메뉴 && 음료
		}

		if (burgerCountArray[0] >= 1 && burgerCountArray[1] >= 1) {
			System.out.println("add 버거");
			MakeOrderSheetArray.add("버거");
			burgerCountArray = new int[2];
		}

		
		
		
		/*y = 540 - 25 * (MakeInformation.size());

		switch (m) {
		case 0:
			x = 485;
			y -= 30;
			break;
		case 1:
			x = 490;
			break;
		case 2:
			x = 503;
			break;
		case 3:
			x = 485;
			y -= 40;
			break;
		case 4:
			x = 495;
			y -= 60;
			break;
		case 5:
			x = 510;
			y -= 20;
			break;
		}*/
		Ingredient.add(x);
		Ingredient.add(y);
		MakeInformation.add(Ingredient);

		i.add(0);
		BurgerThread thread = new BurgerThread(Ingredient, i.size());
		thread.start();
	}

	class BurgerThread extends Thread {
		LinkedList<Object> IngredientBurger;
		int j;

		public BurgerThread(LinkedList<Object> Ingredient, int i) {
			IngredientBurger = Ingredient;
			j = i - 1;
		}

		public void run() {
			try {
				int ii = (int) IngredientBurger.get(2);
				while (i.get(j) != ii) {
					i.set(j, i.get(j) + 1);
//					System.out.println(i.get(j));
					Main.burgermi.game.getParent().repaint();
					Thread.sleep(1);
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
}