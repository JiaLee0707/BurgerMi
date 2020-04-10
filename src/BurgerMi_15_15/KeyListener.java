package BurgerMi_15_15;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	Burger burger = new Burger();
	Score score;
	Order order;

	public void KeyListener() {
		score = Main.burgermi.game.score;
		order = Main.burgermi.game.order;
	}

	public void keyReleased(KeyEvent e) {
		int KeyCode = e.getKeyCode();

		switch (KeyCode) {
		case KeyEvent.VK_S:
//			System.out.println("�ػ�");
			burger.Burger(5);
			break;
		case KeyEvent.VK_W:
//			System.out.println("����");
			burger.Burger(4);
			break;
		case KeyEvent.VK_A: // ��Ƽ
//			System.out.print("��Ƽ");
			burger.Burger(1);
			break;
		case KeyEvent.VK_D: // ����
//			System.out.print("����");
			burger.Burger(3);
			break;
		case KeyEvent.VK_Q: // �丶��
//			System.out.print("�丶��");
			burger.Burger(2);
			break;
		case KeyEvent.VK_E: // ġ��
//			System.out.print("ġ��");
			burger.Burger(0);
			break;
		case KeyEvent.VK_SPACE:
//        	 order.Make(keyCode);
//        	 BurgerMi.game.dropBurger(); 
			break;
		case KeyEvent.VK_ENTER:
			System.out.println("\n����");
			score.Score();
			break;
		case KeyEvent.VK_ESCAPE:
			System.out.println("ESC");
			break;
		}
	}
}
