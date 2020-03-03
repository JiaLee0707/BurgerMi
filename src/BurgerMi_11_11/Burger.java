package BurgerMi_11_11;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Burger extends Thread{
	
	// 만들때 사용하는 버거
	private ImageIcon belowBreadImage = new ImageIcon("src/images/아래빵.png");
	private ImageIcon topBreadImage = new ImageIcon("src/images/윗빵.png");
	private ImageIcon lettuceImage = new ImageIcon("src/images/채소.png");
	private ImageIcon tomatoImage = new ImageIcon("src/images/토마토.png");
	private ImageIcon pattyImage = new ImageIcon("src/images/패티.png");
	private ImageIcon cheeseImage = new ImageIcon("src/images/치즈.png");
	public ImageIcon[] MakeBurgerImageArray = { cheeseImage, 
			pattyImage, tomatoImage, lettuceImage, topBreadImage, belowBreadImage};
	
	public LinkedList<Integer> MakeBurgerArray = new LinkedList<Integer>();
	public JLabel MakerBurgerJLabel;
	
	public Burger(int m) {
		MakeBurgerArray.add(m);
		
		int y = 450-25*(MakeBurgerArray.size());
		
		switch(MakeBurgerArray.get(MakeBurgerArray.size()-1)) {
		case 0:	// 치즈
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[0]);
			MakerBurgerJLabel.setBounds(450, y-40, 400, 300);
			System.out.println("치즈");
			break;
		case 1:	// 패티
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[1]);
			MakerBurgerJLabel.setBounds(450, y-40, 400, 300);
			System.out.println("패티");
			break;
		case 2:	// 토마토
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[2]);
			MakerBurgerJLabel.setBounds(450, y-25, 400, 300);
			System.out.println("토마토");
			break;
		case 3: // 채소
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[3]);
			MakerBurgerJLabel.setBounds(450, y-50, 400, 300);
			System.out.println("채소");
			break;
		case 4: // 윗빵
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[4]);
			MakerBurgerJLabel.setBounds(450, y-95, 400, 300);
			System.out.println("윗빵");
			break;
		case 5: // 아랫빵
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[5]);
			MakerBurgerJLabel.setBounds(450, y, 400, 300);
			System.out.println("아랫빵");
			break;
		}
		Main.burgermi.game.add(MakerBurgerJLabel);
		Main.burgermi.game.setComponentZOrder(MakerBurgerJLabel, MakeBurgerArray.size()-1);	// JLabel의 앞뒤 위치를 설정할 수 있음
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
