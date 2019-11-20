package BurgerMi_4;

import java.awt.*;
import javax.swing.*;

public class burger extends Thread{
	
	private Image TrayImage = new ImageIcon(Main.class.getResource("../images/¿Ôπ›.png")).getImage();
	private Image belowBreadImage = new ImageIcon(Main.class.getResource("../images/æ∆∑°ªß.png")).getImage();
	private Image topBreadImage = new ImageIcon(Main.class.getResource("../images/¿≠ªß.png")).getImage();
	private Image lettuceImage = new ImageIcon(Main.class.getResource("../images/√§º“.png")).getImage();
	private Image tomatoImage = new ImageIcon(Main.class.getResource("../images/≈‰∏∂≈‰.png")).getImage();
	private Image pattyImage = new ImageIcon(Main.class.getResource("../images/∆–∆º.png")).getImage();
	private Image cheeseImage = new ImageIcon(Main.class.getResource("../images/ƒ°¡Ó.png")).getImage();

	private int x, y;
	private String burgerType;
	
	public burger(int x, int y, String burgerType) {
		this.x = x;
		this.y = y;
		this.burgerType = burgerType;
	}
	
	public void screenDraw(Graphics g) {
		System.out.println(burgerType);
		if(burgerType.equals("belowBread")) {
			g.drawImage(belowBreadImage, x, y, null);
		}
		else if(burgerType.equals("topBread")) {
			g.drawImage(topBreadImage, x, y, null);
		}
		else if(burgerType.equals("lettuce")) {
			g.drawImage(lettuceImage, x, y, null);
		}
		else if(burgerType.equals("tomato")) {
			g.drawImage(tomatoImage, x, y, null);
		}
		else if(burgerType.equals("patty")) {
			g.drawImage(pattyImage, x, y, null);
		}
		else if(burgerType.equals("cheese")) {
			g.drawImage(cheeseImage, x, y, null);
		}
	}
	
	public void drop() {
		y += Main.BURGER_SPEED;
//		System.out.println(y);
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				drop();	
				Thread.sleep(Main.SLEEP_TIME);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
