package BurgerMi11111111111111;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.RepaintManager;

public class burger extends Thread{
	
	private Image belowBreadImage = new ImageIcon(Main.class.getResource("../images/�Ʒ���.png")).getImage();
	private Image topBreadImage = new ImageIcon(Main.class.getResource("../images/����.png")).getImage();
	private Image lettuceImage = new ImageIcon(Main.class.getResource("../images/ä��.png")).getImage();
	private Image tomatoImage = new ImageIcon(Main.class.getResource("../images/�丶��.png")).getImage();
	private Image pattyImage = new ImageIcon(Main.class.getResource("../images/��Ƽ.png")).getImage();
	private Image cheeseImage = new ImageIcon(Main.class.getResource("../images/ġ��.png")).getImage();
	
	private Graphics graphics;
	
	public int Threadx;
	public int Thready;
	private String burgerType;
	private Image TypeImage;

	public void burger(int x, int y, String burgerType) {
		this.Threadx=x;
		this.Thready=y;
		this.burgerType=burgerType;
		System.out.println("burger : "+this.Thready);
		
		switch (burgerType) {
		case "belowBread":
			TypeImage = belowBreadImage; break;
		case "topBread":
			TypeImage = topBreadImage; break;
		case "lettuce":
			TypeImage = lettuceImage; break;
		case "tomato":
			TypeImage = tomatoImage; break;
		case "patty":
			TypeImage = pattyImage; break;
		case "cheese":
			TypeImage = cheeseImage; break;
		default:
			break;
		}
	}
	@Override
	public void run() {
		System.out.println("run1 : " + Thready);
		while(true){
//	    	System.out.println("adfadf");
			Thready+=1;
			if(Thready== 500) break;
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
//	             System.out.println("Thread generates an error.");
				e.printStackTrace();
			}
		}
	}
	public void paint(Graphics g) {
		graphics = belowBreadImage.getGraphics();
		screenDraw(graphics);
		g.drawImage(belowBreadImage, Threadx, Thready, null);	
	}
	public void screenDraw(Graphics g) {
//		System.out.println("burgerScreenDraw");
//		System.out.println(Thready);
//		System.out.println(this.TypeImage+" "+ this.Threadx+" "+ this.Thready);
		
//		g.drawImage(this.TypeImage, this.Threadx, this.Thready, null);
		g.drawImage(belowBreadImage, Threadx, Thready, null);
		paint(g);
	}
	
}
