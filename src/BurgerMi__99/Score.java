package BurgerMi__99;

import java.util.List;

public class Score {
//	boolean Enter = false;
	int score = 0;

	public void Score() {
		int count = 0;

		// ���� ���
		while (true) {
			// ���� size�� ������ (����)
			if (count == BurgerMi.game.order.orderBurger.size()) {
				Music OX = new Music("tpir-sdclock.mp3", false);
				OX.start();

				// ����մ��̸� ���� +20
				if (BurgerMi.game.order.obnoxious == 4) {
					score += 20;
				} 
				// �Ϲݼմ��̸� ���� +10
				else {
					score += 10;
				}
				BurgerMi.game.grade.setText(score + "��");
				System.out.println("����");
				break;
			} 
			// �ֹ� ���ſ� ���� ���Ű� �ٸ���
			// size, ���
			else if ((BurgerMi.game.order.MakeBurger.size() != BurgerMi.game.order.orderBurger.size())
					|| (((List<Object>) BurgerMi.game.order.orderBurger.get(count))
							.get(0) != ((List<Object>) BurgerMi.game.order.MakeBurger.get(count)).get(0))) {
				Music OX = new Music("��-��-��.mp3", false);
				OX.start();
				// ����մ��̸� ���� -5
				if(BurgerMi.game.order.obnoxious == 4) {
					score -= 5;
				}
				BurgerMi.game.grade.setText(score + "��");
				System.out.println("����");
				break;
			} 
			// ������� �ܹ��� ��ᰡ ������ count++
			else if (((List<Object>) BurgerMi.game.order.orderBurger.get(count))
					.get(0) == ((List<Object>) BurgerMi.game.order.MakeBurger.get(count)).get(0)) {
				count++;
			}
		}

		// �ֹ�����, ������� clear
		BurgerMi.game.order.orderBurger.clear();
		BurgerMi.game.order.MakeBurger.clear();

		System.out.println("");
		
		// ����մ��̸� �ܹ��� ������
		if(BurgerMi.game.order.obnoxious==4) {
			Throw th = new Throw();
			th.start();
		}
		// �Ϲݼմ��̸� ���ο� �մ� �θ���
		else {
			BurgerMi.game.order = new Order();
			BurgerMi.game.order.start();
		}
		
		// ȭ�� �ٽñ׸���
		BurgerMi.game.revalidate();
		BurgerMi.game.repaint();

//		System.out.println("Order");
//		for (int i = 0; i < BurgerMi.game.order.orderBurger.size(); i++) {
//			System.out.println(BurgerMi.game.order.orderBurger.get(i));
//		}
//		System.out.println("");
//
//		System.out.println("");

	}

}