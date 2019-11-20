package BurgerMi__22;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.swing.ImageIcon;

public class Burger extends Thread{
	private Image TrayImage = new ImageIcon("src/images/¿Ôπ›111.png").getImage();
	private Image belowBreadImage = new ImageIcon("src/images/æ∆∑°ªß.png").getImage();
	private Image topBreadImage = new ImageIcon("src/images/¿≠ªß.png").getImage();
	private Image lettuceImage = new ImageIcon("src/images/√§º“.png").getImage();
	private Image tomatoImage = new ImageIcon("src/images/≈‰∏∂≈‰.png").getImage();
	private Image pattyImage = new ImageIcon("src/images/∆–∆º.png").getImage();
	private Image cheeseImage = new ImageIcon("src/images/ƒ°¡Ó.png").getImage();
	
	int x, y;
	Image ingredients;
	
	Burger(int x, int y, String ingredients) {
		this.x=x;
		this.y=y;
//		System.out.println(x+","+y);
		
		switch(ingredients) {
		case "belowBread":
			this.ingredients=belowBreadImage; break;
		case "topBread":
			this.ingredients=topBreadImage; break;
		case "lettuce":
			this.ingredients=lettuceImage; break;
		case "tomato":
			this.ingredients=tomatoImage; break;
		case "patty":
			this.ingredients=pattyImage; break;
		case "cheese":
			this.ingredients=cheeseImage; break;
		}
	}
	public void run() {
//		System.out.println("run : "+x+","+y);
//		i=0;
		boolean bool = true;
		try {
			while(y!=500) {
				y=y+1;
//				System.out.println(i);
				BurgerMi.game.Thread(ingredients, x, y, bool);
				BurgerMi.game.repaint();
				Thread.sleep(7);
			}
			bool = false;
			BurgerMi.game.x=x;
			BurgerMi.game.y=y;
			List<Object> Array = new ArrayList<Object>();
			Array.add(this.ingredients);
			Array.add(this.x);
			Array.add(this.y);
			BurgerMi.game.BurgerArray.add((List<Object>) Array);
			for(int i=0; i<BurgerMi.game.BurgerArray.size(); i++) {
				System.out.println(BurgerMi.game.BurgerArray.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
