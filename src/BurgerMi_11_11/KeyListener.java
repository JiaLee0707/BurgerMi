package BurgerMi_11_11;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;

public class KeyListener extends KeyAdapter{
	public Burger burger;
	
	public void keyReleased(KeyEvent e) {
		int KeyCode = e.getKeyCode();
		
		switch(KeyCode) {
		case KeyEvent.VK_S :
			System.out.println("�ػ�");
			burger = new Burger(5);
			break;
		case KeyEvent.VK_W :
			System.out.println("����");
			burger = new Burger(4);
			break;
		case KeyEvent.VK_A: // ��Ƽ
			System.out.print("��Ƽ");
			burger = new Burger(1);
			break;
		case KeyEvent.VK_D: // ����
			System.out.print("����");
			burger = new Burger(3);
			break;
		case KeyEvent.VK_Q: // �丶��
			System.out.print("�丶��");
			burger = new Burger(2);
			break;
		case KeyEvent.VK_E: // ġ��
			System.out.print("ġ��");
			burger = new Burger(0);
			break;
//		case KeyEvent.VK_SPACE:
//        	 order.Make(keyCode);
//        	 BurgerMi.game.dropBurger(); 
//			break;
		case KeyEvent.VK_ENTER:
			System.out.println("\n����");
			break;
		case KeyEvent.VK_ESCAPE:
			System.out.println("ESC");
		}
	}
}
