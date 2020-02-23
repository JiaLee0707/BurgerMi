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
	
	// �մ�
	private ImageIcon guest1 = new ImageIcon("src/images/11.png");
	private ImageIcon guest2 = new ImageIcon("src/images/22.png");
	private ImageIcon guest3 = new ImageIcon("src/images/33.png");
	private ImageIcon guest4 = new ImageIcon("src/images/44.png");
	private ImageIcon guest5 = new ImageIcon("src/images/55.png");
	private ImageIcon guest6 = new ImageIcon("src/images/66.png");
	public ImageIcon[] guestArray = { guest1, guest2, guest3, guest4, guest5, guest6 };
	
	// ���鶧 ����ϴ� ����
//	private ImageIcon belowBreadImage = new ImageIcon("src/images/�Ʒ���.png");
//	private ImageIcon topBreadImage = new ImageIcon("src/images/����.png");
//	private ImageIcon lettuceImage = new ImageIcon("src/images/ä��.png");
//	private ImageIcon tomatoImage = new ImageIcon("src/images/�丶��.png");
//	private ImageIcon pattyImage = new ImageIcon("src/images/��Ƽ.png");
//	private ImageIcon cheeseImage = new ImageIcon("src/images/ġ��.png");

	// �ֹ����� ����
	private ImageIcon orderbelowBreadImage = new ImageIcon("src/images/Order�Ʒ���.png");	// 5
	private ImageIcon ordertopBreadImage = new ImageIcon("src/images/Order����.png");		// 4
	private ImageIcon orderlettuceImage = new ImageIcon("src/images/Orderä��.png");		// 3
	private ImageIcon ordertomatoImage = new ImageIcon("src/images/Order�丶��.png");		// 2
	private ImageIcon orderpattyImage = new ImageIcon("src/images/Order��Ƽ.png");			// 1
	private ImageIcon ordercheeseImage = new ImageIcon("src/images/Orderġ��.png");			// 0
	public ImageIcon[] orderBurgerImageArray = { ordercheeseImage, 
			orderpattyImage, ordertomatoImage, orderlettuceImage, ordertopBreadImage, orderbelowBreadImage};
	
	int[] orderBurgerArray = new int[5];
	JLabel BurgerJLabel;
	
	public void Order(JLabel BurgerJLabel) {
		int orderBurger, i = 0;	// �ֹ� ����
		
		// �ֹ����� ����
		if(guest.who != 4) {	//���� �մ��� �ƴ϶��
			orderBurger = -2;
			i = 1;
			orderBurgerArray[0] = 0;
			orderBurgerArray[4] = 1;
		} else {
			orderBurger = 0;
		}
		
		// �ֹ� ����
		for(i = i; i < 5-orderBurger; i++) {
				orderBurger += (int)(Math.random() * 6); 
				orderBurgerArray[i] = orderBurger;
		}
		
		// �ܹ��� ��� ��ġ ����
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
	
	//�մ� Ŭ����(������)
	class Guest extends Thread {		
		int who = (int)(Math.random() * 6);	// �մ� ����
		int y = 100; // �մ� y��ǥ
		JLabel guestJLabel;
		
		public void Guest(JLabel guestJLabel) {
			this.guestJLabel = guestJLabel;

			// �մ�
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