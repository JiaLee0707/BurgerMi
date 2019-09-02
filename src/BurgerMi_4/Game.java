package BurgerMi_4;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class Game extends Thread{

//	private Image TrayImage = new ImageIcon(Main.class.getResource("../images/¿Ôπ›.png")).getImage();
//	private Image belowBreadImage = new ImageIcon(Main.class.getResource("../images/æ∆∑°ªß.png")).getImage();
//	private Image topBreadImage = new ImageIcon(Main.class.getResource("../images/¿≠ªß.png")).getImage();
//	private Image lettuceImage = new ImageIcon(Main.class.getResource("../images/√§º“.png")).getImage();
//	private Image tomatoImage = new ImageIcon(Main.class.getResource("../images/≈‰∏∂≈‰.png")).getImage();
//	private Image pattyImage = new ImageIcon(Main.class.getResource("../images/∆–∆º.png")).getImage();
//	private Image cheeseImage = new ImageIcon(Main.class.getResource("../images/ƒ°¡Ó.png")).getImage();
	
	ArrayList<burger> burgerList = new ArrayList<burger>();
	
	public void screenDraw(Graphics g) {
//		g.drawImage(TrayImage, 440, 570, null);
//		g.drawImage(belowBreadImage, 595, 650, null);
//		g.drawImage(lettuceImage, 569, 610, null);
//		g.drawImage(pattyImage, 572, 632, null);
//		g.drawImage(cheeseImage, 567, 587, null);
//		g.drawImage(tomatoImage, 585, 600, null);
//		g.drawImage(topBreadImage, 574, 514, null);
	}
	public void pressS() {
		new Music("203.mp3", false).start();
	}
	public void pressW() {
		new Music("203.mp3", false).start();
	}
	public void pressA() {
		new Music("203.mp3", false).start();
	}
	public void pressD() {
		new Music("203.mp3", false).start();
	}
	public void pressQ() {
		new Music("203.mp3", false).start();
	}
	public void pressE() {
		new Music("203.mp3", false).start();
	}
	public void pressSPACE() {
		new Music("203.mp3", false).start();
	}
	public void pressENTER() {
		new Music("203.mp3", false).start();
	}
	
	public void dropburger() {
		
	}
	

}
