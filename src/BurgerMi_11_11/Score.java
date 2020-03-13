package BurgerMi_11_11;

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

	Score(Order order) {
		this.order = order;
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
			if(order.guest.who == 4) {
				score += scoreArray[1];
			} else score += scoreArray[0];
		} else {
			musicOX = new Music("��-��-��.mp3", false);
			if(order.guest.who == 4) {
				score += scoreArray[2];
			}
		}
		musicOX.start();
		
		scoreLabel.setText(score + "��");
		
		Main.burgermi.game.keyListener.burger.MakeBurgerArray = new LinkedList<Integer>();
		Main.burgermi.game.order = new Order();
//		Main.burgermi.game.revalidate();
//		Main.burgermi.game.repaint();
//		Main.burgermi.game.getParent().repaint();
	}

	public boolean Discriminate() {
		boolean OX = true;
		
		int orderSize = order.orderBurgerArray.length;
		int makeSize = burger.MakeBurgerArray.size();

		// ���� ������ ��
		if (orderSize != makeSize) {
			OX = false;
		} else {
			// ���� ��� ��
			for (int i = 0; i < orderSize; i++) {
				// ���� ��ᰡ �ٸ���
				if (order.orderBurgerArray[i] != burger.MakeBurgerArray.get(i)) {
					OX = false;
					break;
				}
			}
		}
		
		return OX;
	}

}
