package BurgerMi_13_13;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Burger {

	// ���鶧 ����ϴ� ����
	private Image belowBreadImage = new ImageIcon("src/images/�Ʒ���.png").getImage();
	private Image topBreadImage = new ImageIcon("src/images/����.png").getImage();
	private Image lettuceImage = new ImageIcon("src/images/ä��.png").getImage();
	private Image tomatoImage = new ImageIcon("src/images/�丶��.png").getImage();
	private Image pattyImage = new ImageIcon("src/images/��Ƽ.png").getImage();
	private Image cheeseImage = new ImageIcon("src/images/ġ��.png").getImage();
	public Image[] MakeBurgerImageArray = { cheeseImage, pattyImage, tomatoImage, lettuceImage, topBreadImage,
			belowBreadImage };
	
	public LinkedList<Integer> MakeBurgerIntArray = new LinkedList<Integer>();
	public LinkedList<Object> MakeBurgerObjectArray = new LinkedList<Object>();
	public List<Object> burgerIngredient;
	int x, y, i = 0; // �ܹ��� x, y, i ��ǥ
	
	boolean key = false;
	
	public void Burger(int m) {
		key = true;
		
		burgerIngredient = new LinkedList<Object>();
		burgerIngredient.add(MakeBurgerImageArray[m]);
		MakeBurgerIntArray.add(m);
	
		y = 550-25*(MakeBurgerIntArray.size());
		
		switch(m) {
		case 0:	// ġ��
			x = 485;
			y -= 30;
//			System.out.println("ġ��");
			break;
		case 1:	// ��Ƽ
			x = 490;
//			y -= 5;
//			System.out.println("��Ƽ");
			break;
		case 2:	// �丶��
			x = 503;
//			y -= 5;
//			System.out.println("�丶��");
			break;
		case 3: // ä��
			x = 485;
			y -= 40;
//			System.out.println("ä��");
			break;
		case 4: // ����
			x = 495;
			y -= 60;
//			System.out.println("����");
			break;
		case 5: // �Ʒ���
			x = 510;
			y -= 20;
//			System.out.println("�ػ�");
			break;
		}
		burgerIngredient.add(x);
		burgerIngredient.add(y);		
		BurgerThread thread = new BurgerThread();
		thread.start();

		Main.burgermi.game.getParent().repaint();
	}
	
	class BurgerThread extends Thread {
		public void run() {
			i = 0;
			try {
				while (i != y) {
					i += 1;
					Main.burgermi.game.getParent().repaint();
					Thread.sleep(1);
				}

				MakeBurgerObjectArray.add(burgerIngredient);
			} catch (Exception e) {
				e.getMessage();
			}
		}		
	}
}

