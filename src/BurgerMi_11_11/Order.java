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
	
	public Order() {
		int orderBurger = 0, i = 0, random = 6;	// �ֹ� ����

		// �ֹ����� ����
		if(guest.who != 4) {	//���� �մ��� �ƴ϶��
			System.out.println("����X");
			i = 1;
			random = 4;
			orderBurgerArray[0] = 5;
			orderBurgerArray[4] = 4;
		}
		
		// �ֹ� ����
		for(int j = i; j < 5-i; j++) {
			orderBurger = (int)(Math.random() * random);
			orderBurgerArray[j] = orderBurger;
		}
	}
	
	public void Order(JLabel BurgerJLabel, int i) {
		// �ܹ��� ��� ��ġ ����
		int y = 160-25*(i+1);
		switch(orderBurgerArray[i]) {
		case 0:	// ġ��
			BurgerJLabel.setBounds(135, y+10, 400, 300);
			System.out.println("ġ��");
			break;
		case 1:	// ��Ƽ
			BurgerJLabel.setBounds(140, y+13, 400, 300);
			System.out.println("��Ƽ");
			break;
		case 2:	// �丶��
			BurgerJLabel.setBounds(140, y+8, 400, 300);
			System.out.println("�丶��");
			break;
		case 3: // ä��
			BurgerJLabel.setBounds(138, y-3, 400, 300);
			System.out.println("ä��");
			break;
		case 4: // ����
			BurgerJLabel.setBounds(135, y-10, 400, 300);
			System.out.println("����");
			break;
		case 5: // �Ʒ���
			BurgerJLabel.setBounds(135, y, 400, 300);
			System.out.println("�Ʒ���");
			break;
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