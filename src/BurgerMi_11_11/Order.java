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
	private ImageIcon orderTrayImage = new ImageIcon("src/images/Order�Ʒ���.png");
	private ImageIcon orderbelowBreadImage = new ImageIcon("src/images/Order�Ʒ���.png");
	private ImageIcon ordertopBreadImage = new ImageIcon("src/images/Order����.png");
	private ImageIcon orderlettuceImage = new ImageIcon("src/images/Orderä��.png");
	private ImageIcon ordertomatoImage = new ImageIcon("src/images/Order�丶��.png");
	private ImageIcon orderpattyImage = new ImageIcon("src/images/Order��Ƽ.png");
	private ImageIcon ordercheeseImage = new ImageIcon("src/images/Orderġ��.png");
	public ImageIcon[] orderBurgerArray = { orderTrayImage, orderbelowBreadImage, 
			ordertomatoImage, orderlettuceImage, ordertomatoImage, orderpattyImage, ordercheeseImage};
	
//	List<Object> orderBurger = new ArrayList<Object>(); // �ֹ����� ����
//	List<Object> MakeBurger = new ArrayList<Object>(); // ���� ����
	
	public void Order(JLabel guestJLabel) {
		// �մ�
		guestJLabel.setBounds(553, 100, 175, 300);
		guest.Guest(guestJLabel);
		guest.start();
		
		// �ֹ�
		int orderBurger = (int)(Math.random() * 7); // �ֹ� ����
		
	}
	
	//�մ� Ŭ����(������)
	class Guest extends Thread {
		int who = (int)(Math.random() * 6);	// �մ� ����
		int y = 100; // �մ� y��ǥ
		JLabel guestJLabel;
		
		public void Guest(JLabel guestJLabel) {
			this.guestJLabel = guestJLabel;
			System.out.println("guest");
			if(who != 4) {
				
			}
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