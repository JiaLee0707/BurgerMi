package BurgerMi__11;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class burger extends Thread {

	private Image TrayImage = new ImageIcon(Main.class.getResource("../images/쟁반111.png")).getImage();
	private Image belowBreadImage = new ImageIcon(Main.class.getResource("../images/아래빵.png")).getImage();
	private Image topBreadImage = new ImageIcon(Main.class.getResource("../images/윗빵.png")).getImage();
	private Image lettuceImage = new ImageIcon(Main.class.getResource("../images/채소.png")).getImage();
	private Image tomatoImage = new ImageIcon(Main.class.getResource("../images/토마토.png")).getImage();
	private Image pattyImage = new ImageIcon(Main.class.getResource("../images/패티.png")).getImage();
	private Image cheeseImage = new ImageIcon(Main.class.getResource("../images/치즈.png")).getImage();

	public int Threadx = 0;
	public int Thready = 0;
	private String burgerType;
	private Image TypeImage;
	private boolean flag = false;

	public void burger(int x, int y, String burgerType) {
		this.Threadx = x;
		this.Thready = y;
		this.burgerType = burgerType;
//		System.out.println("burger : "+this.Thready);

//		switch (burgerType) {
//		case "belowBread":
//			TypeImage = belowBreadImage; break;
//		case "topBread":
//			TypeImage = topBreadImage; break;
//		case "lettuce":
//			TypeImage = lettuceImage; break;
//		case "tomato":
//			TypeImage = tomatoImage; break;
//		case "patty":
//			TypeImage = pattyImage; break;
//		case "cheese":
//			TypeImage = cheeseImage; break;
//		default:
//			break;
//		}
	}

	public void drop() {
		if (Thready != 500) {
//			System.out.println(Thready);
			Thready += 1;

		}
//		BurgerMi.game.burger.interrupt();
	}

	@Override
	public void run() {
//		System.out.println("run1 : " + Thready);
		try {
			while (true) {
				drop();
				Thread.sleep(7);
//					if(flag == true)
//						return; 
			}
		} catch (InterruptedException e) {
//	             System.out.println("Thread generates an error.");
			e.printStackTrace();
		}
	}

	public void screenDraw(Graphics g) {
		g.drawImage(TrayImage, 420, 455, null);
		g.drawImage(belowBreadImage, this.Threadx, this.Thready, null);
//		screenDraw1(g);
		// g.drawImage(topBreadImage, this.Threadx, this.Thready, null);
//		g.drawImage(lettuceImage, this.Threadx, this.Thready,null);
	}

}