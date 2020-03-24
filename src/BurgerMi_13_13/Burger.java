package BurgerMi_13_13;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Burger {

	// ¸¸µé¶§ »ç¿ëÇÏ´Â ¹ö°Å
	private Image belowBreadImage = new ImageIcon("src/images/¾Æ·¡»§.png").getImage();
	private Image topBreadImage = new ImageIcon("src/images/À­»§.png").getImage();
	private Image lettuceImage = new ImageIcon("src/images/Ã¤¼Ò.png").getImage();
	private Image tomatoImage = new ImageIcon("src/images/Åä¸¶Åä.png").getImage();
	private Image pattyImage = new ImageIcon("src/images/ÆÐÆ¼.png").getImage();
	private Image cheeseImage = new ImageIcon("src/images/Ä¡Áî.png").getImage();
	public Image[] MakeBurgerImageArray = { cheeseImage, pattyImage, tomatoImage, lettuceImage, topBreadImage,
			belowBreadImage };
	
	public LinkedList<Integer> MakeBurgerIntArray = new LinkedList<Integer>();
	public LinkedList<Object> MakeBurgerObjectArray = new LinkedList<Object>();
	public List<Object> burgerIngredient;
	int x, y, i = 0; // ÇÜ¹ö°Å x, y, i ÁÂÇ¥
	
	boolean key = false;
	
	public void Burger(int m) {
		key = true;
		
		burgerIngredient = new LinkedList<Object>();
		burgerIngredient.add(MakeBurgerImageArray[m]);
		MakeBurgerIntArray.add(m);
	
		y = 550-25*(MakeBurgerIntArray.size());
		
		switch(m) {
		case 0:	// Ä¡Áî
			x = 485;
			y -= 30;
//			System.out.println("Ä¡Áî");
			break;
		case 1:	// ÆÐÆ¼
			x = 490;
//			y -= 5;
//			System.out.println("ÆÐÆ¼");
			break;
		case 2:	// Åä¸¶Åä
			x = 503;
//			y -= 5;
//			System.out.println("Åä¸¶Åä");
			break;
		case 3: // Ã¤¼Ò
			x = 485;
			y -= 40;
//			System.out.println("Ã¤¼Ò");
			break;
		case 4: // À­»§
			x = 495;
			y -= 60;
//			System.out.println("À­»§");
			break;
		case 5: // ¾Æ·§»§
			x = 510;
			y -= 20;
//			System.out.println("¹Ø»§");
			break;
		}
		burgerIngredient.add(x);
		burgerIngredient.add(y);		
		BurgerThread thread = new BurgerThread();
		thread.start();

		Main.burgermi.game.getParent().repaint();
	}
	
	class BurgerThread extends Thread {
		public void run() {
			i = 0;
			try {
				while (i != y) {
					i += 1;
					Main.burgermi.game.getParent().repaint();
					Thread.sleep(1);
				}

				MakeBurgerObjectArray.add(burgerIngredient);
			} catch (Exception e) {
				e.getMessage();
			}
		}		
	}
}

