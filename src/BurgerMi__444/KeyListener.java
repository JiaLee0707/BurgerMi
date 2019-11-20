package BurgerMi__444;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class KeyListener extends KeyAdapter {
	@Override
	public void keyPressed(KeyEvent e) {
         int keyCode = e.getKeyCode();
         switch(keyCode) {
         case KeyEvent.VK_S:
        	 BurgerMi.game.order.Make(keyCode);
        	 BurgerMi.game.dropBurger("belowBread"); break;
         case KeyEvent.VK_W:
        	 BurgerMi.game.order.Make(keyCode);
        	 BurgerMi.game.dropBurger("topBread"); break;
         case KeyEvent.VK_A:
        	 BurgerMi.game.order.Make(keyCode);
        	 BurgerMi.game.dropBurger("patty"); break;
         case KeyEvent.VK_D:
        	 BurgerMi.game.order.Make(keyCode);
        	 BurgerMi.game.dropBurger("lettuce"); break;
         case KeyEvent.VK_Q:
        	 BurgerMi.game.order.Make(keyCode);
        	 BurgerMi.game.dropBurger("tomato"); break;
         case KeyEvent.VK_E:
        	 BurgerMi.game.order.Make(keyCode);
        	 BurgerMi.game.dropBurger("cheese"); break;
//         case KeyEvent.VK_SPACE:
//        	 order.Make(keyCode);
//        	 BurgerMi.game.dropBurger(); break;
         case KeyEvent.VK_ENTER:
//        	 System.out.println(keyCode);
        	 BurgerMi.game.order.Make(keyCode); break;
//        	 BurgerMi.game.dropBurger(); break;
         }
    }
}
