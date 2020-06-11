package BurgerMi_ITShow;

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
	private Image CheeseStick = new ImageIcon("src/images/CheeseStick.png").getImage();
	private Image ChickenNuggets = new ImageIcon("src/images/ChickenNuggets.png").getImage();
	private Image FrenchFries = new ImageIcon("src/images/FrenchFries.png").getImage();
	private Image Icecream = new ImageIcon("src/images/Icecream.png").getImage();
	

	// 재료대 음식
	public Image[] IngredientsImage;
	// 빵
	private Image smallTopBreadSesameImage = new ImageIcon("src/images/smallBreadTopSesame.png").getImage();
	private Image smallBelowBreadSesameImage = new ImageIcon("src/images/smallBreadBelowSesame.png").getImage();
	private Image smallTopBreadImage = new ImageIcon("src/images/smallBreadTop.png").getImage();
	private Image smallBelowBreadImage = new ImageIcon("src/images/smallBreadBelow.png").getImage();
	private Image smallMorinTopBreadImage = new ImageIcon("src/images/smallMoringBreadTop.png").getImage();
	private Image smallMorinBelowBreadImage = new ImageIcon("src/images/smallMoringBreadBelow.png").getImage();
	public Image[] ingrdientsBreadImageArray = { smallTopBreadSesameImage, smallTopBreadImage,
			smallMorinTopBreadImage, smallBelowBreadSesameImage, smallBelowBreadImage, smallMorinBelowBreadImage };
	// 속재료
	private Image smalllettuceImage = new ImageIcon("src/images/smalllettuce.png").getImage();
	private Image smalltomatoImage = new ImageIcon("src/images/smalltomato.png").getImage();
	private Image smallpattyImage = new ImageIcon("src/images/smallpatty.png").getImage();
	private Image smallcheeseImage = new ImageIcon("src/images/smallcheese.png").getImage();
	private Image smalleggImage = new ImageIcon("src/images/smallegg.png").getImage();
	private Image smallonionImage = new ImageIcon("src/images/smallonion.png").getImage();
	public Image[] IngredientImageArray = { smalllettuceImage, smalltomatoImage, smallpattyImage, smallcheeseImage,
			smalleggImage, smallonionImage };
	
	public HashMap<String, Image> hamMap = new HashMap<String, Image>();

	public LinkedList<Integer> MakeBurgerIntArray = new LinkedList<Integer>(); // 만드는 버거 int
	public LinkedList<Object> burgerIngredient = new LinkedList<Object>(); // 내려오는 버거
	public LinkedList<Object> Ingredient;
	public LinkedList<Integer> i = new LinkedList<Integer>();
	int x, y; // 햄버거 x, y, i 좌표

	boolean key = false;

	public Make() {
		hamMap.put("깨윗빵", topBreadSesameImage);
		hamMap.put("깨아래빵", belowBreadSesameImage);
		hamMap.put("기본윗빵", topBreadImage);
		hamMap.put("기본아래빵", belowBreadImage);
		hamMap.put("모닝윗빵", MoringTopBreadImage);
		hamMap.put("모닝아래빵", MoringBelowBreadImage);
		
		hamMap.put("치즈", cheeseImage);
		hamMap.put("패티", pattyImage);
		hamMap.put("토마토", tomatoImage);
		hamMap.put("양상추", lettuceImage);
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
	
	public void Ingredients(int ingr) {
		key = true;
		switch (ingr) {
		case 1:
			// for(int i=0; i<RImageArray.length; i++) {
			makeBurgerArray = makeBreadImageArray;
			IngredientsImage = ingrdientsBreadImageArray;
			// }
			break;
		case 2:
			// for(int i=0; i<RImageArray.length; i++) {
			makeBurgerArray = makeIngredientImageArray;
			IngredientsImage = IngredientImageArray;
			// }
			break;
		default:
			break;
		}
		
		Main.burgermi.game.getParent().repaint();
	}

	public void Make() {
		Ingredient = new LinkedList<Object>();
	}
	
//	public void Burger(int m) {
//		Ingredient = new LinkedList<Object>();
//		Ingredient.add(makeBurgerArray[m]);
//		MakeBurgerIntArray.add(m);
//		for (int i = 0; i < MakeBurgerIntArray.size(); i++) {
//			System.out.println(MakeBurgerIntArray.get(i));
//		}
//
//		y = 540 - 25 * (MakeBurgerIntArray.size());
//
//		switch (m) {
//		case 0:
//			x = 485;
//			y -= 30;
//			break;
//		case 1:
//			x = 490;
//			break;
//		case 2:
//			x = 503;
//			break;
//		case 3:
//			x = 485;
//			y -= 40;
//			break;
//		case 4:
//			x = 495;
//			y -= 60;
//			break;
//		case 5:
//			x = 510;
//			y -= 20;
//			break;
//		}
//		Ingredient.add(x);
//		Ingredient.add(y);
//		burgerIngredient.add(Ingredient);
//		i.add(0);
//		BurgerThread thread = new BurgerThread(Ingredient, i.size());
//		thread.start();
//
//		Main.burgermi.game.getParent().repaint();
//	}

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