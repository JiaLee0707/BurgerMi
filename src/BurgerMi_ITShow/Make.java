package BurgerMi_ITShow;

import java.awt.Image;
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
	public Image[] makeBreadImageArray = { topBreadSesameImage, belowBreadSesameImage, topBreadImage, belowBreadImage };

	// 속재료
	private Image lettuceImage = new ImageIcon("src/images/lettuce.png").getImage();
	private Image tomatoImage = new ImageIcon("src/images/tomato.png").getImage();
	private Image pattyImage = new ImageIcon("src/images/patty.png").getImage();
	private Image cheeseImage = new ImageIcon("src/images/cheese.png").getImage();
	private Image eggImage = new ImageIcon("src/images/egg.png").getImage();
	private Image onionImage = new ImageIcon("src/images/onion.png").getImage();
	public Image[] makeIngredientImageArray = { lettuceImage, tomatoImage, pattyImage, cheeseImage, eggImage,
			onionImage };

	// 재료대 음식
	public Image[] IngredientsImage;
	// 빵
	private Image smalltopBreadSesameImage = new ImageIcon("src/images/smallbreadTopSesame.png").getImage();
	private Image smallbelowBreadSesameImage = new ImageIcon("src/images/smallbreadBelowSesame.png").getImage();
	private Image smalltopBreadImage = new ImageIcon("src/images/smallbreadTop.png").getImage();
	private Image smallbelowBreadImage = new ImageIcon("src/images/smallbreadBelow.png").getImage();
	public Image[] ingrdientsBreadImageArray = { smalltopBreadSesameImage, smallbelowBreadSesameImage,
			smalltopBreadImage, smallbelowBreadImage };

	// 속재료
	private Image smalllettuceImage = new ImageIcon("src/images/smalllettuce.png").getImage();
	private Image smalltomatoImage = new ImageIcon("src/images/smalltomato.png").getImage();
	private Image smallpattyImage = new ImageIcon("src/images/smallpatty.png").getImage();
	private Image smallcheeseImage = new ImageIcon("src/images/smallcheese.png").getImage();
	private Image smalleggImage = new ImageIcon("src/images/smallegg.png").getImage();
	private Image smallonionImage = new ImageIcon("src/images/smallonion.png").getImage();
	public Image[] IngredientImageArray = { smalllettuceImage, smalltomatoImage, smallpattyImage, smallcheeseImage,
			smalleggImage, smallonionImage };

	public LinkedList<Integer> MakeBurgerIntArray = new LinkedList<Integer>(); // 만드는 버거 int
	public LinkedList<Object> burgerIngredient = new LinkedList<Object>(); // 내려오는 버거
	public LinkedList<Object> Ingredient;
	public LinkedList<Integer> i = new LinkedList<Integer>();
	int x, y; // 햄버거 x, y, i 좌표

	boolean key = false;

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

	public void Burger(int m) {
		Ingredient = new LinkedList<Object>();
		Ingredient.add(makeBurgerArray[m]);
		MakeBurgerIntArray.add(m);
		for (int i = 0; i < MakeBurgerIntArray.size(); i++) {
			System.out.println(MakeBurgerIntArray.get(i));
		}

		y = 540 - 25 * (MakeBurgerIntArray.size());

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
		}
		Ingredient.add(x);
		Ingredient.add(y);
		burgerIngredient.add(Ingredient);
		i.add(0);
		BurgerThread thread = new BurgerThread(Ingredient, i.size());
		thread.start();

		Main.burgermi.game.getParent().repaint();
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