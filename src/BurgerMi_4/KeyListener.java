package BurgerMi_4;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(BurgerMi.game == null) {
			return;
		}	
		if(e.getKeyCode() == KeyEvent.VK_S) {
			BurgerMi.game.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_W) {
			BurgerMi.game.pressW();
		}
		else if(e.getKeyCode() == KeyEvent.VK_A) {
			BurgerMi.game.pressA();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			BurgerMi.game.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_Q) {
			BurgerMi.game.pressQ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_E) {
			BurgerMi.game.pressE();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			BurgerMi.game.pressSPACE();
		}
		else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			BurgerMi.game.pressENTER();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(BurgerMi.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			BurgerMi.game.releaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_W) {
			BurgerMi.game.releaseW();
		}
		else if(e.getKeyCode() == KeyEvent.VK_A) {
			BurgerMi.game.releaseA();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			BurgerMi.game.releaseD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_Q) {
			BurgerMi.game.releaseQ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_E) {
			BurgerMi.game.releaseE();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			BurgerMi.game.releaseSPACE();
		}
		else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			BurgerMi.game.releaseENTER();
		}
	}

}
