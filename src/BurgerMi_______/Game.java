package BurgerMi_______;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Game extends Thread {
	Music Button = new Music("203.mp3", false);

//	ArrayList<burger> burgerList = new ArrayList<burger>();
//	burger burger = new burger(595, -20, "belowBread");
	int array[] = new int[5];
	int key[] = new int[5];

	int K = 0;

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
		for (int j = 0; j < 80; j++) {
			System.out.println("");
		}
//			System.out.println("s:밑빵    w:윗빵    a:패티    d:상추    q:토마토    e:치즈");

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

		System.out.println("s:밑빵    w:윗빵    a:패티    d:상추    q:토마토    e:치즈");
		System.out.println("0 : 밑빵");

		int intValue = 0;
		int i = 1;

		while (true) {
			intValue = (int) ((Math.random() * 86) + 65);
			if (intValue == 65 || intValue == 68 || intValue == 69 || intValue == 81) {
				array[i] = intValue;
				System.out.print(i + " : ");
				i++;
			}

			switch (intValue) {
			case 65:
				System.out.println("패티");
				break;
			case 68:
				System.out.println("상추");
				break;
			case 69:
				System.out.println("치즈");
				break;
			case 81:
				System.out.println("토마토");
				break;
//				case 83:
//					System.out.println("밑빵"); break;
//				case 87:
//					System.out.println("윗빵"); break;
			}
			if (i == 4) {
				break;
			}
		}
		System.out.println("4 : 윗빵\n");

	}

	public void pressS() { // 밑빵
//		burger = new burger(595, -20, "belowBread");
//		System.out.println("burgerS"+burger.Thready);

//		Game();
//		dropburger();
//		Button.start();
		key[K] = 83;
		System.out.println("밑빵");
		K++;
	}

	public void pressW() { // 윗빵
//		burger = new burger(595, -20, "topBread");
//		burger.burger(595, -20, "topBread");
//		Button.start();
//		dropburger();
		key[K] = 87;
		System.out.println("윗빵");
		K++;
	}

	public void pressA() { // 패티
//		burger = new burger(595, -20, "patty");
//		burger.burger(595, -20, "patty");
//		Button.start();
//		dropburger();
		key[K] = 65;
		System.out.println("패티");
		K++;
	}

	public void pressD() { // 상추
//		burger = new burger(595, -20, "lettuce");
//		burger.burger(595, -20, "lettuce");
//		Button.start();
//		dropburger();
		key[K] = 68;
		System.out.println("상추");
		K++;
	}

	public void pressQ() { // 토마토
//		burger = new burger(595, -20, "tomato");
//		burger.burger(595, -20, "tomato");
//		Button.start();
//		dropburger();
		key[K] = 81;
		System.out.println("토마토");
		K++;
	}

	public void pressE() { // 치즈
//		burger = new burger(595, -20, "cheese");
//		burger.burger(595, -20, "cheese");
//		Button.start();
//		dropburger();
		key[K] = 69;
		System.out.println("치즈");
		K++;
	}

	public void pressSPACE() {
//		Button.start();	
	}

	public void pressENTER() {
		int count = 0;
		for (int i = 0; i < 5; i++) {
			if (array[i] != key[i]) {
				System.out.println("죄송합니다 손님;;;;");
				break;
			} else {
				count++;
//				System.out.println(count);
			}
		}
		if (count == 5) {
			System.out.println("감사합니다 맛있게드세요!");
		}
		for (int j = 0; j < 4; j++) {
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