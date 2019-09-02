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
	
	public burger(int x, int y) {
		this.x = x;
		this.y = y;
		this.burgerType = burgerType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(burgerType.equals("belowBread")) {
			g.drawImage
		}
	}
}
