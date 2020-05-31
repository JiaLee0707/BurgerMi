package BurgerMi_ITShow;

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
//			System.out.println("밑빵");
			burger.Burger(5);
			break;
		case KeyEvent.VK_W:
//			System.out.println("윗빵");
			burger.Burger(4);
			break;
		case KeyEvent.VK_A: // 패티
//			System.out.print("패티");
			burger.Burger(1);
			break;
		case KeyEvent.VK_D: // 상추
//			System.out.print("상추");
			burger.Burger(3);
			break;
		case KeyEvent.VK_Q: // 토마토
//			System.out.print("토마토");
			burger.Burger(2);
			break;
		case KeyEvent.VK_E: // 치즈
//			System.out.print("치즈");
			burger.Burger(0);
			break;
		case KeyEvent.VK_SPACE:
//        	 order.Make(keyCode);
//        	 BurgerMi.game.dropBurger(); 
			break;
		case KeyEvent.VK_ENTER:
			System.out.println("\n엔터");
			score.Score();
			break;
		case KeyEvent.VK_ESCAPE:
			System.out.println("ESC");
			break;
		}
	}
}