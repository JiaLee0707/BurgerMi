package BurgerMi_11_11;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Burger{
	
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
	int x, y; // 햄버거 x, y 좌표
	
//	public Burger() {}

	public void Burger(int m) {
		MakeBurgerArray.add(m);
	
		y = 495-25*(MakeBurgerArray.size());
		
		switch(MakeBurgerArray.get(MakeBurgerArray.size()-1)) {
		case 0:	// 치즈
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[0]);
			MakerBurgerJLabel.setBounds(445, 0, 400, 300);
			x = 445;
			y -= 10;
			System.out.println("치즈");
			break;
		case 1:	// 패티
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[1]);
			MakerBurgerJLabel.setBounds(448, 0, 400, 300);
			x = 448;
			y -= 10;
			System.out.println("패티");
			break;
		case 2:	// 토마토
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[2]);
			MakerBurgerJLabel.setBounds(448, 0, 400, 300);
			x = 448;
			y -= 22;
			System.out.println("토마토");
			break;
		case 3: // 채소
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[3]);
			MakerBurgerJLabel.setBounds(450, 0, 400, 300);
			x = 450;
			y -= 30;
			System.out.println("채소");
			break;
		case 4: // 윗빵
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[4]);
			MakerBurgerJLabel.setBounds(443, 0, 400, 300);
			x = 443;
			y -= 43;
			System.out.println("윗빵");
			break;
		case 5: // 아랫빵
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[5]);
			MakerBurgerJLabel.setBounds(444, 0, 400, 300);
			x = 444;
			y -= 20;
			System.out.println("밑빵");
			break;
		}
		Main.burgermi.game.add(MakerBurgerJLabel);
		System.out.println(MakeBurgerArray.size());
		Main.burgermi.game.setComponentZOrder(MakerBurgerJLabel, (MakeBurgerArray.size()+1)-MakeBurgerArray.size());	// JLabel의 앞뒤 위치를 설정할 수 있음
//		Main.burgermi.game.getParent().repaint();
		BurgerThread thread = new BurgerThread();
		thread.start();
	}
	
	class BurgerThread extends Thread {
		public void run() {
			try {
				int i = 0;
				while (i != y) {
					i += 1;
					MakerBurgerJLabel.setLocation(x, i);;
//					Main.burgermi.game.getParent().repaint();
					Main.burgermi.game.revalidate();
					Thread.sleep(1);
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}		
	}
}
