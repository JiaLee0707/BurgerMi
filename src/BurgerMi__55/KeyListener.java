package BurgerMi__55;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class KeyListener extends KeyAdapter {
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_S: // 밑빵
			System.out.print("밑빵");
			BurgerMi.game.order.Make("belowBread");
			break;
		case KeyEvent.VK_W: // 윗빵
			System.out.print("윗빵");
			BurgerMi.game.order.Make("topBread");
			break;
		case KeyEvent.VK_A: // 패티
			System.out.print("패티");
			BurgerMi.game.order.Make("patty");
			break;
		case KeyEvent.VK_D: // 상추
			System.out.print("상추");
			BurgerMi.game.order.Make("lettuce");
			break;
		case KeyEvent.VK_Q: // 토마토
			System.out.print("토마토");
			BurgerMi.game.order.Make("tomato");
			break;
		case KeyEvent.VK_E: // 치즈
			System.out.print("치즈");
			BurgerMi.game.order.Make("cheese");
			break;
		case KeyEvent.VK_SPACE:
//        	 order.Make(keyCode);
//        	 BurgerMi.game.dropBurger(); 
			break;
		case KeyEvent.VK_ENTER:
			System.out.println("\n엔터");
//        	 System.out.println(keyCode);
			BurgerMi.game.score.Score();
			break;
		}
	}
}