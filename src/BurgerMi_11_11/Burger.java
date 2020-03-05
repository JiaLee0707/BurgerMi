package BurgerMi_11_11;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Burger{
	
	// ���鶧 ����ϴ� ����
	private ImageIcon belowBreadImage = new ImageIcon("src/images/�Ʒ���.png");
	private ImageIcon topBreadImage = new ImageIcon("src/images/����.png");
	private ImageIcon lettuceImage = new ImageIcon("src/images/ä��.png");
	private ImageIcon tomatoImage = new ImageIcon("src/images/�丶��.png");
	private ImageIcon pattyImage = new ImageIcon("src/images/��Ƽ.png");
	private ImageIcon cheeseImage = new ImageIcon("src/images/ġ��.png");
	public ImageIcon[] MakeBurgerImageArray = { cheeseImage, 
			pattyImage, tomatoImage, lettuceImage, topBreadImage, belowBreadImage};
	
	public LinkedList<Integer> MakeBurgerArray = new LinkedList<Integer>();
	public JLabel MakerBurgerJLabel;
	int x, y; // �ܹ��� x, y ��ǥ
	
//	public Burger() {}

	public void Burger(int m) {
		MakeBurgerArray.add(m);
	
		y = 495-25*(MakeBurgerArray.size());
		
		switch(MakeBurgerArray.get(MakeBurgerArray.size()-1)) {
		case 0:	// ġ��
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[0]);
			MakerBurgerJLabel.setBounds(445, 0, 400, 300);
			x = 445;
			y -= 10;
			System.out.println("ġ��");
			break;
		case 1:	// ��Ƽ
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[1]);
			MakerBurgerJLabel.setBounds(448, 0, 400, 300);
			x = 448;
			y -= 10;
			System.out.println("��Ƽ");
			break;
		case 2:	// �丶��
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[2]);
			MakerBurgerJLabel.setBounds(448, 0, 400, 300);
			x = 448;
			y -= 22;
			System.out.println("�丶��");
			break;
		case 3: // ä��
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[3]);
			MakerBurgerJLabel.setBounds(450, 0, 400, 300);
			x = 450;
			y -= 30;
			System.out.println("ä��");
			break;
		case 4: // ����
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[4]);
			MakerBurgerJLabel.setBounds(443, 0, 400, 300);
			x = 443;
			y -= 43;
			System.out.println("����");
			break;
		case 5: // �Ʒ���
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[5]);
			MakerBurgerJLabel.setBounds(444, 0, 400, 300);
			x = 444;
			y -= 20;
			System.out.println("�ػ�");
			break;
		}
		Main.burgermi.game.add(MakerBurgerJLabel);
		System.out.println(MakeBurgerArray.size());
		Main.burgermi.game.setComponentZOrder(MakerBurgerJLabel, (MakeBurgerArray.size()+1)-MakeBurgerArray.size());	// JLabel�� �յ� ��ġ�� ������ �� ����
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
