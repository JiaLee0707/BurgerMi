package BurgerMi_4;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class Game extends Thread{

	private Image TrayImage = new ImageIcon(Main.class.getResource("../images/���.png")).getImage();
//	private Image belowBreadImage = new ImageIcon(Main.class.getResource("../images/�Ʒ���.png")).getImage();
//	private Image topBreadImage = new ImageIcon(Main.class.getResource("../images/����.png")).getImage();
//	private Image lettuceImage = new ImageIcon(Main.class.getResource("../images/ä��.png")).getImage();
//	private Image tomatoImage = new ImageIcon(Main.class.getResource("../images/�丶��.png")).getImage();
//	private Image pattyImage = new ImageIcon(Main.class.getResource("../images/��Ƽ.png")).getImage();
//	private Image cheeseImage = new ImageIcon(Main.class.getResource("../images/ġ��.png")).getImage();
	
	ArrayList<burger> burgerList = new ArrayList<burger>();
	public Game() {
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(TrayImage, 440, 570, null);
//		g.drawImage(belowBreadImage, 595, 650, null);
//		g.drawImage(lettuceImage, 569, 610, null);
//		g.drawImage(pattyImage, 572, 632, null);
//		g.drawImage(cheeseImage, 567, 587, null);
//		g.drawImage(tomatoImage, 585, 600, null);
//		g.drawImage(topBreadImage, 574, 514, null);
		
		for(int i=0; i<burgerList.size(); i++){
			burger burger = burgerList.get(i);
			burger.screenDraw(g);
		}
	}
	public void pressS() {
		dropburger();
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
//		burgerList.add(new burger(595, 650, "belowBread"));
//		burgerList.add(new burger(569, 610, "lettuce"));
//		burgerList.add(new burger(572, 632, "patty"));
//		burgerList.add(new burger(567, 587, "cheese"));
//		burgerList.add(new burger(585, 600, "tomato"));
//		burgerList.add(new burger(574, 514, "topBread"));
		
		burger burger = new burger(595, 0, "belowBread");
		burger.start();
		burgerList.add(burger);
	}
	

}
