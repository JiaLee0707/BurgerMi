package BurgerMi_11_11;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{
	public void keyReleased(KeyEvent e) {
		int KeyCode = e.getKeyCode();
		System.out.println(KeyCode);
		switch(KeyCode) {
		case KeyEvent.VK_S :
			System.out.println("关户");
			break;
		case KeyEvent.VK_W :
			System.out.println("拉户");
			break;
		}
	}
}
