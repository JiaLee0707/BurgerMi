package BurgerMi_15_15;

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

	public LinkedList<Integer> MakeBurgerIntArray = new LinkedList<Integer>(); // ����� ���� int
	public LinkedList<Object> MakeBurgerObjectArray = new LinkedList<Object>(); // ����� ���� �̹���, ��ġ
	public LinkedList<Object> burgerIngredient = new LinkedList<Object>(); // �������� ����
	public LinkedList<Object> Ingredient;
	public LinkedList<Integer> i = new LinkedList<Integer>();
	int x, y; // �ܹ��� x, y, i ��ǥ

	boolean key = false;

	public void Burger(int m) {
		key = true;

		Ingredient = new LinkedList<Object>();
		Ingredient.add(MakeBurgerImageArray[m]);
		MakeBurgerIntArray.add(m);
		for (int i = 0; i < MakeBurgerIntArray.size(); i++) {
			System.out.println(MakeBurgerIntArray.get(i));
		}

		y = 540 - 25 * (MakeBurgerIntArray.size());

		switch (m) {
		case 0: // ġ��
			x = 485;
			y -= 30;
//			System.out.println("ġ��");
			break;
		case 1: // ��Ƽ
			x = 490;
//			y -= 5;
//			System.out.println("��Ƽ");
			break;
		case 2: // �丶��
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
		Ingredient.add(x);
		Ingredient.add(y);
		burgerIngredient.add(Ingredient);
		BurgerThread thread = new BurgerThread();
		thread.start();

		Main.burgermi.game.getParent().repaint();
	}

	class BurgerThread extends Thread {
//		public BurgerThread() {
//			i = new LinkedList<Integer>();
//		}
		public void run() {
			try {
				i.add(0);
				for (int j = 0; j < i.size(); j++) {
					int ii = (Integer) ((LinkedList<Integer>) burgerIngredient.get(j)).get(2);
					while (i.get(j) != ii) {
						i.set(j, i.get(j) + 1);
						System.out.println(i.get(j));
						Main.burgermi.game.getParent().repaint();
						Thread.sleep(1);
					}
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
}
