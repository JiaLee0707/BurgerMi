package BurgerMi_______;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Game extends Thread{
	Music Button = new Music("203.mp3", false);
	
//	ArrayList<burger> burgerList = new ArrayList<burger>();
//	burger burger = new burger(595, -20, "belowBread");
	int array[] = new int[5];
	int key[] = new int[5];

	int K=0;
	
	burger burger = new burger();
//	burger burger;
	
	Random random = new Random();
//	KeyListener keylistener = new KeyListener();
	public Game() {
//		System.out.println("Game"+burger.Thready);
//		pressS();
//		pressW();
//		pressA();
//		pressD();
//		pressQ();
//		pressE();
//		pressSPACE();
//		pressENTER();
//		for()

//		do {
			for(int j=0; j<80; j++) {
				System.out.println("");
			}
//			System.out.println("s:�ػ�    w:����    a:��Ƽ    d:����    q:�丶��    e:ġ��");
			
			dropburger();
		
			order();
//		}while(true);
	}
	
	public void dropburger() {
		burger.burger(520, -20, "belowBread");
//		burger = new burger(95, -20, "belowBread");
//		burgerList.add(burger);
//				burger.burger(595, -20, "belowBread");
//		for(int i=0; i<burgerList.size(); i++) {
//		burger.Threadx=520;
//		burger.Thready=-50;
		burger.start();
		
//		burger.burger(595, -20, "topBread");
//		burger.start();
//		
//		burger.burger(595, -20, "patty");
//		burger.start();
//		
//		burger.burger(595, -20, "lettuce");
//		burger.start();
//		
//		burger.burger(595, -20, "tomato");
//		burger.start();
//		
//		burger.burger(595, -20, "cheese");
//		burger.start();
		
		
	}
	public void order() {
		array[0] = 83;
		array[4] = 87;

		System.out.println("s:�ػ�    w:����    a:��Ƽ    d:����    q:�丶��    e:ġ��");
		System.out.println("0 : �ػ�");
		
		int intValue=0;
		int i=1;
		
		while(true) {
				intValue = (int)((Math.random() * 86) + 65);
				if(intValue == 65 || intValue == 68 || intValue == 69 || intValue == 81) {
					array[i] = intValue;
					System.out.print(i+" : ");
					i++;
				}
				
				
				switch (intValue) {
				case 65:
					System.out.println("��Ƽ"); break;
				case 68:
					System.out.println("����"); break;
				case 69:
					System.out.println("ġ��"); break;
				case 81:
					System.out.println("�丶��"); break;
//				case 83:
//					System.out.println("�ػ�"); break;
//				case 87:
//					System.out.println("����"); break;
				}		
				if(i==4) {
					break;
				}
		}
		System.out.println("4 : ����\n");
		
	}
	public void pressS() {	//�ػ�
//		burger = new burger(595, -20, "belowBread");
//		System.out.println("burgerS"+burger.Thready);
		
//		Game();
//		dropburger();
//		Button.start();
		key[K] = 83;
		System.out.println("�ػ�");
		K++;
	}
	public void pressW() {	//����
//		burger = new burger(595, -20, "topBread");
//		burger.burger(595, -20, "topBread");
//		Button.start();
//		dropburger();
		key[K] = 87;
		System.out.println("����");
		K++;
	}
	public void pressA() {	//��Ƽ
//		burger = new burger(595, -20, "patty");
//		burger.burger(595, -20, "patty");
//		Button.start();
//		dropburger();
		key[K] = 65;
		System.out.println("��Ƽ");
		K++;
	}
	public void pressD() {	//����
//		burger = new burger(595, -20, "lettuce");
//		burger.burger(595, -20, "lettuce");
//		Button.start();
//		dropburger();
		key[K] = 68;
		System.out.println("����");
		K++;
	}
	public void pressQ() {	//�丶��
//		burger = new burger(595, -20, "tomato");
//		burger.burger(595, -20, "tomato");
//		Button.start();
//		dropburger();
		key[K] = 81;
		System.out.println("�丶��");
		K++;
	}
	public void pressE() {	//ġ��
//		burger = new burger(595, -20, "cheese");
//		burger.burger(595, -20, "cheese");
//		Button.start();
//		dropburger();
		key[K] = 69;
		System.out.println("ġ��");
		K++;
	}
	public void pressSPACE() {	
//		Button.start();	
	}
	public void pressENTER() {
		int count=0;
		for(int i=0; i<5; i++) {
			if(array[i]!=key[i]) {
				System.out.println("�˼��մϴ� �մ�;;;;");
				break;
			}
			else {
				count++;
//				System.out.println(count);
			}
		}
		if(count==5) {
			System.out.println("�����մϴ� ���ְԵ弼��!"); 
		}
		for(int j=0; j<4; j++) {
			array[j] = 0;
			key[j] = 0;
		}
		System.out.println("");
//		System.out.println("hghfdsa");
		
		order();
	}

	public void screenDraw(Graphics g) {
		burger.screenDraw(g);
//		System.out.println("Draw"+burger.Thready);
//		System.out.println("GameScreenDraw");
	}

	
}
