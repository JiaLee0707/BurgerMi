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
	
	// 만들때 사용하는 버거
//	private ImageIcon belowBreadImage = new ImageIcon("src/images/아래빵.png");
//	private ImageIcon topBreadImage = new ImageIcon("src/images/윗빵.png");
//	private ImageIcon lettuceImage = new ImageIcon("src/images/채소.png");
//	private ImageIcon tomatoImage = new ImageIcon("src/images/토마토.png");
//	private ImageIcon pattyImage = new ImageIcon("src/images/패티.png");
//	private ImageIcon cheeseImage = new ImageIcon("src/images/치즈.png");

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
	JLabel BurgerJLabel;
	
	public void Order(JLabel BurgerJLabel) {
		int orderBurger, i = 0;	// 주문 버거
		
		// 주문받은 버거
		if(guest.who != 4) {	//진상 손님이 아니라면
			orderBurger = -2;
			i = 1;
			orderBurgerArray[0] = 0;
			orderBurgerArray[4] = 1;
		} else {
			orderBurger = 0;
		}
		
		// 주문 랜덤
		for(i = i; i < 5-orderBurger; i++) {
				orderBurger += (int)(Math.random() * 6); 
				orderBurgerArray[i] = orderBurger;
		}
		
		// 햄버거 재료 위치 조정
		for(i = 0; i < 5; i++) {
			switch(orderBurgerArray[i]) {
			case 0:
				BurgerJLabel.setBounds(553, 100, 175, 300);
				break;
			case 1: break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			}
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
			guest.start();
			
			System.out.println("guest");
		}
			
		public void run() {
			try {
				while (y != 136) {
					y += 1;
					guestJLabel.setLocation(553, y);;
					Main.burgermi.game.getParent().repaint();
					Main.burgermi.game.revalidate();
					Thread.sleep(10);
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
}