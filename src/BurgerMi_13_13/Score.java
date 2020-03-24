package BurgerMi_13_13;

import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JLabel;

public class Score {
	Order order;
	Burger burger;
	private Order.Guest guest;

	int score = 0;
	int scoreArray[] = { 10, 20, -5 };
	public JLabel scoreLabel = new JLabel(score + "��");
	Music musicOX;

	Score(Order order) {
		this.order = order;
		guest  = order.new Guest();
		scoreLabel.setFont(new Font("������������� ExtraBold", Font.ITALIC, 50)); // ��Ʈ ����
		scoreLabel.setSize(500, 500); // ũŰ ����
		scoreLabel.setLocation(1160, -150); // ��ġ ����
		Main.burgermi.game.add(scoreLabel);
	}
	public void Score(Burger burger) {
		this.burger = burger;
		
		boolean OX = Discriminate();
		
		//���� ���
		if(OX == true) {
			musicOX = new Music("tpir-sdclock.mp3", false);
			if(order.who == 4) {
				score += scoreArray[1];
			} else score += scoreArray[0];
		} else {
			musicOX = new Music("��-��-��.mp3", false);
			if(order.who == 4) {
				score += scoreArray[2];
			}
		}
		musicOX.start();
		
		scoreLabel.setText(score + "��");
//		Main.burgermi.game.getParent().repaint();
		
		this.burger.MakeBurgerObjectArray.clear();
		this.burger.MakeBurgerIntArray.clear();
		this.burger.burgerIngredient = new LinkedList<Object>();
		this.burger.burgerIngredient.add(null);
		this.burger.burgerIngredient.add(0);
		this.burger.burgerIngredient.add(0);
		order.orderBurgerArray = new int[5];;
		
		Main.burgermi.game.order = new Order();
		Main.burgermi.game.ReGame();
//		Main.burgermi.game.revalidate();
//		Main.burgermi.game.repaint();
		Main.burgermi.game.getParent().repaint();
	}

	public boolean Discriminate() {
		boolean OX = true;
		
		int orderSize = order.orderBurgerArray.length;
		int makeSize = burger.MakeBurgerIntArray.size();

		System.out.println("\n\n\n\n\n" + orderSize + " " + makeSize);

		// ���� ������ ��
		if (orderSize != makeSize) {
			OX = false;
		} else {
			// ���� ��� ��
			for (int i = 0; i < orderSize; i++) {
				System.out.println(order.orderBurgerArray[i] + "----" + burger.MakeBurgerIntArray.get(i));
				// ���� ��ᰡ �ٸ���
				if (order.orderBurgerArray[i] != burger.MakeBurgerIntArray.get(i)) {
					OX = false;
					break;
				}
			}
		}
		
		return OX;
	}

}
