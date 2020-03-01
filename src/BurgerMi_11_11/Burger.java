package BurgerMi_11_11;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Burger extends Thread{
	
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
	
	public Burger(int m) {
		MakeBurgerArray.add(m);
		
		int y = 450-25*(MakeBurgerArray.size());
		
		switch(MakeBurgerArray.get(MakeBurgerArray.size()-1)) {
		case 0:	// ġ��
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[0]);
			MakerBurgerJLabel.setBounds(450, y+10, 400, 300);
			System.out.println("ġ��");
			break;
		case 1:	// ��Ƽ
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[1]);
			MakerBurgerJLabel.setBounds(450, y+13, 400, 300);
			System.out.println("��Ƽ");
			break;
		case 2:	// �丶��
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[2]);
			MakerBurgerJLabel.setBounds(450, y+8, 400, 300);
			System.out.println("�丶��");
			break;
		case 3: // ä��
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[3]);
			MakerBurgerJLabel.setBounds(450, y-3, 400, 300);
			System.out.println("ä��");
			break;
		case 4: // ����
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[4]);
			MakerBurgerJLabel.setBounds(450, y-10, 400, 300);
			System.out.println("����");
			break;
		case 5: // �Ʒ���
			MakerBurgerJLabel = new JLabel(MakeBurgerImageArray[5]);
			MakerBurgerJLabel.setBounds(450, y, 400, 300);
			System.out.println("�Ʒ���");
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
