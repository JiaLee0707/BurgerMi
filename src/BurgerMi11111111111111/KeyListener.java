package BurgerMi11111111111111;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import BurgerMi_4.BurgerMi;

public class KeyListener extends KeyAdapter {
	Game game = new Game();

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

//		System.out.println("Listener : " + keyCode);
		switch (keyCode) {
		case KeyEvent.VK_S:
			System.out.println("S");
			BurgerMi.game.pressS();
			game.pressS();
			break;
		case KeyEvent.VK_W:
//        		BurgerMi.game.pressW(); break; 
			game.pressW();
			break;
		case KeyEvent.VK_A:
//        		BurgerMi.game.pressA(); break; 
			game.pressS();
			break;
		case KeyEvent.VK_D:
//        		BurgerMi.game.pressD();; break; 
			game.pressD();
			break;
		case KeyEvent.VK_Q:
//        		BurgerMi.game.pressQ(); break; 
			game.pressQ();
			break;
		case KeyEvent.VK_E:
//        		BurgerMi.game.pressE(); break; 
			game.pressE();
			break;
		case KeyEvent.VK_SPACE:
//        		BurgerMi.game.pressSPACE(); break; 
			game.pressSPACE();
			break;
		case KeyEvent.VK_ENTER:
//        		BurgerMi.game.pressENTER(); break; 
			game.pressENTER();
			break;
		}
	}
}