package BurgerMi__1010;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class KeyListener extends KeyAdapter {

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_S: // πÿªß
			System.out.print("πÿªß");
			BurgerMi.game.order.Make("belowBread");
			break;
		case KeyEvent.VK_W: // ¿≠ªß
			System.out.print("¿≠ªß");
			BurgerMi.game.order.Make("topBread");
			break;
		case KeyEvent.VK_A: // ∆–∆º
			System.out.print("∆–∆º");
			BurgerMi.game.order.Make("patty");
			break;
		case KeyEvent.VK_D: // ªÛ√ﬂ
			System.out.print("ªÛ√ﬂ");
			BurgerMi.game.order.Make("lettuce");
			break;
		case KeyEvent.VK_Q: // ≈‰∏∂≈‰
			System.out.print("≈‰∏∂≈‰");
			BurgerMi.game.order.Make("tomato");
			break;
		case KeyEvent.VK_E: // ƒ°¡Ó
			System.out.print("ƒ°¡Ó");
			BurgerMi.game.order.Make("cheese");
			break;
//		case KeyEvent.VK_SPACE:
//        	 order.Make(keyCode);
//        	 BurgerMi.game.dropBurger(); 
//			break;
		case KeyEvent.VK_ENTER:
			System.out.println("\nø£≈Õ");
			BurgerMi.game.ingredients = null;
			BurgerMi.game.burger.interrupt();
			BurgerMi.game.score.Score();
			break;
		}
	}
}
