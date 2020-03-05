package BurgerMi_11_11;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Order{
	Random random = new Random();
	Guest guest = new Guest();
	
	// 손님
	private ImageIcon guest1 = new ImageIcon("src/images/11.png");
	private ImageIcon guest2 = new ImageIcon("src/images/22.png");
	private ImageIcon guest3 = new ImageIcon("src/images/33.png");
	private ImageIcon guest4 = new ImageIcon("src/images/44.png");
	private ImageIcon guest5 = new ImageIcon("src/images/55.png");
	private ImageIcon guest6 = new ImageIcon("src/images/66.png");
	public ImageIcon[] guestArray = { guest1, guest2, guest3, guest4, guest5, guest6 };

	// 주문받은 버거
	private ImageIcon orderbelowBreadImage = new ImageIcon("src/images/Order아래빵.png");	// 5
	private ImageIcon ordertopBreadImage = new ImageIcon("src/images/Order윗빵.png");		// 4
	private ImageIcon orderlettuceImage = new ImageIcon("src/images/Order채소.png");		// 3
	private ImageIcon ordertomatoImage = new ImageIcon("src/images/Order토마토.png");		// 2
	private ImageIcon orderpattyImage = new ImageIcon("src/images/Order패티.png");			// 1
	private ImageIcon ordercheeseImage = new ImageIcon("src/images/Order치즈.png");			// 0
	public ImageIcon[] orderBurgerImageArray = { ordercheeseImage, 
			orderpattyImage, ordertomatoImage, orderlettuceImage, ordertopBreadImage, orderbelowBreadImage};
	
	int[] orderBurgerArray = new int[5];
	
	public Order() {
		int orderBurger = 0, i = 0, random = 6;	// 주문 버거

		// 주문받은 버거
		if(guest.who != 4) {	//진상 손님이 아니라면
			System.out.println("진상X");
			i = 1;
			random = 4;
			orderBurgerArray[0] = 5;
			orderBurgerArray[4] = 4;
		}
		
		// 주문 랜덤
		for(int j = i; j < 5-i; j++) {
			orderBurger = (int)(Math.random() * random);
			orderBurgerArray[j] = orderBurger;
		}
	}
	
	public void Order(JLabel BurgerJLabel, int i) {
		// 햄버거 재료 위치 조정
		int y = 160-25*(i+1);
		switch(orderBurgerArray[i]) {
		case 0:	// 치즈
			BurgerJLabel.setBounds(135, y+10, 400, 300);
			System.out.println("치즈");
			break;
		case 1:	// 패티
			BurgerJLabel.setBounds(140, y+13, 400, 300);
			System.out.println("패티");
			break;
		case 2:	// 토마토
			BurgerJLabel.setBounds(140, y+8, 400, 300);
			System.out.println("토마토");
			break;
		case 3: // 채소
			BurgerJLabel.setBounds(138, y-3, 400, 300);
			System.out.println("채소");
			break;
		case 4: // 윗빵
			BurgerJLabel.setBounds(135, y-10, 400, 300);
			System.out.println("윗빵");
			break;
		case 5: // 아랫빵
			BurgerJLabel.setBounds(135, y, 400, 300);
			System.out.println("아랫빵");
			break;
		}
	}
	
	//손님 클래스(쓰레드)
	class Guest extends Thread {		
		int who = (int)(Math.random() * 6);	// 손님 랜덤
		int y = 100; // 손님 y좌표
		JLabel guestJLabel;
		
		public void Guest(JLabel guestJLabel) {
			this.guestJLabel = guestJLabel;

			// 손님
			guestJLabel.setBounds(553, 100, 175, 300);
			this.start();
			
			System.out.println("guest");
		}
			
		public void run() {
			try {
				while (y != 136) {
					y += 1;
					guestJLabel.setLocation(553, y);;
//					Main.burgermi.game.getParent().repaint();
					Main.burgermi.game.revalidate();
					Thread.sleep(10);
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
}