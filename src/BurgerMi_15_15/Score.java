package BurgerMi_15_15;

import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JLabel;

public class Score {
	Order order;
	Burger burger;
	
	int score = 0;
	int scoreArray[] = { 10, 20, -5 };
	public JLabel scoreLabel = new JLabel(score + "��");
	Music musicOX;

	public Score() {
		scoreLabel.setFont(new Font("������������� ExtraBold", Font.ITALIC, 50)); // ��Ʈ ����
		scoreLabel.setSize(500, 500); // ũŰ ����
		scoreLabel.setLocation(1160, -150); // ��ġ ����
		Main.burgermi.game.add(scoreLabel);
	}
	public void Score() {
		order = Main.burgermi.game.order;
		burger = Main.burgermi.game.keyListener.burger;

		boolean OX = Discriminate();
		
		//���� ���
		if(OX == true) {
			musicOX = new Music("tpir-sdclock.mp3", false);
			if(order.who != 4) {
				score += scoreArray[0];
				System.out.println("����");
			} else { score += scoreArray[1]; 
			System.out.println("���� ����");}
		} else {
			musicOX = new Music("��-��-��.mp3", false);
			System.out.println("����");
			if(order.who == 4) {
				score += scoreArray[2];
				System.out.println("���� ����");
			}
		}
		musicOX.start();
		
		scoreLabel.setText(score + "��");
		
		this.burger.MakeBurgerObjectArray.clear();
		this.burger.MakeBurgerIntArray.clear();
		this.burger.burgerIngredient = new LinkedList<Object>();
		this.burger.burgerIngredient.add(null);
		this.burger.burgerIngredient.add(0);
		this.burger.burgerIngredient.add(0);
		order.orderBurgerArray = new int[5];;
		
		
		if (order.who == 4) {
			Throw th = new Throw();
			th.start();
		} else {
			Main.burgermi.game.order = new Order();			
			Main.burgermi.game.ReGame();
		}
//		Main.burgermi.game.revalidate();
//		Main.burgermi.game.repaint();
		Main.burgermi.game.getParent().repaint();
	}

	public boolean Discriminate() {
		boolean OX = true;
		
		int orderSize = Main.burgermi.game.order.orderBurgerArray.length;
		int makeSize = Main.burgermi.game.keyListener.burger.MakeBurgerIntArray.size();

		System.out.println("\n\n\n\n\n" + orderSize + " " + makeSize);

		// ���� ������ ��
		if (orderSize != makeSize) {
			OX = false;
		} else {
			// ���� ��� ��
			for (int i = 0; i < orderSize; i++) {
				System.out.println(Main.burgermi.game.order.orderBurgerArray[i] + "----" + Main.burgermi.game.keyListener.burger.MakeBurgerIntArray.get(i));
				// ���� ��ᰡ �ٸ���
				if (Main.burgermi.game.order.orderBurgerArray[i] != Main.burgermi.game.keyListener.burger.MakeBurgerIntArray.get(i)) {
					OX = false;
					break;
				}
			}
		}
		
		return OX;
	}

}
