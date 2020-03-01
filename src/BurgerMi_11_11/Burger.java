package BurgerMi_11_11;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Burger extends Thread{
	
	// ¸¸µé¶§ »ç¿ëÇÏ´Â ¹ö°Å
	private ImageIcon belowBreadImage = new ImageIcon("src/images/¾Æ·¡»§.png");
	private ImageIcon topBreadImage = new ImageIcon("src/images/À­»§.png");
	private ImageIcon lettuceImage = new ImageIcon("src/images/Ã¤¼Ò.png");
	private ImageIcon tomatoImage = new ImageIcon("src/images/Åä¸¶Åä.png");
	private ImageIcon pattyImage = new ImageIcon("src/images/ÆÐÆ¼.png");
	private ImageIcon cheeseImage = new ImageIcon("src/images/Ä¡Áî.png");
	public ImageIcon[] MakeBurgerImageArray = { cheeseImage, 
			pattyImage, tomatoImage, lettuceImage, topBreadImage, belowBreadImage};
	
	public LinkedList<Integer> MakeBurgerArray = new LinkedList<Integer>();
	public JLabel MakerBurgerJLabel;
	
	public Burger(int m) {
		MakeBurgerArray.add(m);
		
		int y = 450-25*(MakeBurgerArray.size());
		
		switch(MakeBurgerArray.get(MakeBurgerArray.size()-1)) {
		case 0:	// Ä¡Áî
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[0]);
			MakerBurgerJLabel.setBounds(450, y+10, 400, 300);
			System.out.println("Ä¡Áî");
			break;
		case 1:	// ÆÐÆ¼
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[1]);
			MakerBurgerJLabel.setBounds(450, y+13, 400, 300);
			System.out.println("ÆÐÆ¼");
			break;
		case 2:	// Åä¸¶Åä
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[2]);
			MakerBurgerJLabel.setBounds(450, y+8, 400, 300);
			System.out.println("Åä¸¶Åä");
			break;
		case 3: // Ã¤¼Ò
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[3]);
			MakerBurgerJLabel.setBounds(450, y-3, 400, 300);
			System.out.println("Ã¤¼Ò");
			break;
		case 4: // À­»§
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[4]);
			MakerBurgerJLabel.setBounds(450, y-10, 400, 300);
			System.out.println("À­»§");
			break;
		case 5: // ¾Æ·§»§
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[5]);
			MakerBurgerJLabel.setBounds(450, y, 400, 300);
			System.out.println("¾Æ·§»§");
			break;
		}
		Main.burgermi.game.add(MakerBurgerJLabel);
		Main.burgermi.game.getParent().repaint();
	}
	
	public void run() {
		try {
			Thread.sleep(1);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
