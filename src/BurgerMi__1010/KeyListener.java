package BurgerMi__1010;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class KeyListener extends KeyAdapter {

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_S: // �ػ�
			System.out.print("�ػ�");
			BurgerMi.game.order.Make("belowBread");
			break;
		case KeyEvent.VK_W: // ����
			System.out.print("����");
			BurgerMi.game.order.Make("topBread");
			break;
		case KeyEvent.VK_A: // ��Ƽ
			System.out.print("��Ƽ");
			BurgerMi.game.order.Make("patty");
			break;
		case KeyEvent.VK_D: // ����
			System.out.print("����");
			BurgerMi.game.order.Make("lettuce");
			break;
		case KeyEvent.VK_Q: // �丶��
			System.out.print("�丶��");
			BurgerMi.game.order.Make("tomato");
			break;
		case KeyEvent.VK_E: // ġ��
			System.out.print("ġ��");
			BurgerMi.game.order.Make("cheese");
			break;
//		case KeyEvent.VK_SPACE:
//        	 order.Make(keyCode);
//        	 BurgerMi.game.dropBurger(); 
//			break;
		case KeyEvent.VK_ENTER:
			System.out.println("\n����");
			BurgerMi.game.ingredients = null;
			BurgerMi.game.burger.interrupt();
			BurgerMi.game.score.Score();
			break;
		}
	}
}
