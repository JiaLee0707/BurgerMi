package BurgerMi_ITShow;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	Make make = new Make();
	Sales sales;
	Order order;
	public boolean Keyboolen = false;

	public void KeyListener() {
		sales = Main.burgermi.game.score;
		order = Main.burgermi.game.order;
		Keyboolen = true;
	}

	public void keyReleased(KeyEvent e) {
		int KeyCode = e.getKeyCode();

		//재료대 음식
		switch (KeyCode) {
		case KeyEvent.VK_1:
			make.Ingredients(1);
			break;
		case KeyEvent.VK_2:
			make.Ingredients(2);
			break;
		case KeyEvent.VK_3:
			make.Ingredients(3);
			break;
		case KeyEvent.VK_4:
			make.Ingredients(4);
			break;
		}
		
		// 만들기
		switch(KeyCode) {
		case KeyEvent.VK_Q:
			make.Make(0);
			break;
		case KeyEvent.VK_W:
			make.Make(1);
			break;
		case KeyEvent.VK_E:
			make.Make(2);
			break;
		case KeyEvent.VK_A:
			make.Make(3);
			break;
		case KeyEvent.VK_S:
			make.Make(4);
			break;
		case KeyEvent.VK_D:
			make.Make(5);
			break;
		
			
//		case KeyEvent.VK_SPACE:
//        	 order.Make(keyCode);
//        	 BurgerMi.game.dropBurger(); 
//			break;
		case KeyEvent.VK_ENTER:
			System.out.println("\n엔터");
			sales.Sales();
			break;
		}
	}
}