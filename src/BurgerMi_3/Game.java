package BurgerMi_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Game extends Thread {

	private Image TrayImage = new ImageIcon(Main.class.getResource("../images/쟁반.png")).getImage();
	private Image belowBreadImage = new ImageIcon(Main.class.getResource("../images/아래빵.png")).getImage();
	private Image topBreadImage = new ImageIcon(Main.class.getResource("../images/윗빵.png")).getImage();
	private Image lettuceImage = new ImageIcon(Main.class.getResource("../images/채소.png")).getImage();
	private Image tomatoImage = new ImageIcon(Main.class.getResource("../images/토마토.png")).getImage();
	private Image pattyImage = new ImageIcon(Main.class.getResource("../images/패티.png")).getImage();
	private Image cheeseImage = new ImageIcon(Main.class.getResource("../images/치즈.png")).getImage();

	public void screenDraw(Graphics g) {
		g.drawImage(TrayImage, 440, 570, null);
		g.drawImage(belowBreadImage, 595, 650, null);
		g.drawImage(lettuceImage, 569, 610, null);
		g.drawImage(pattyImage, 572, 632, null);
		g.drawImage(cheeseImage, 567, 587, null);
		g.drawImage(tomatoImage, 585, 600, null);
		g.drawImage(topBreadImage, 574, 514, null);
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

//	public void releaseS() {
//		
//	}
//	public void releaseW() {
//		
//	}
//	public void releaseA() {
//		
//	}
//	public void releaseD() {
//		
//	}
//	public void releaseQ() {
//		
//	}
//	public void releaseE() {
//		
//	}
//	public void releaseSPACE() {
//		
//	}
//	public void releaseENTER() {
//		
//	}
}