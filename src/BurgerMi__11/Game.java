package BurgerMi__11;

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
	public Game() {

		for(int j=0; j<80; j++) {
			System.out.println("");
		}
		
		dropburger();
		
//	order();
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
		
	}

	public void pressS() {	//¹Ø»§
//		burger = new burger(595, -20, "belowBread");
//		System.out.println("burgerS"+burger.Thready);
		
//		Game();
//		dropburger();
//		Button.start();
		key[K] = 83;
		System.out.println("¹Ø»§");
		K++;
	}
	public void pressW() {	//À­»§
//		burger = new burger(595, -20, "topBread");
//		burger.burger(595, -20, "topBread");
//		Button.start();
//		dropburger();
		key[K] = 87;
		System.out.println("À­»§");
		K++;
	}
	public void pressA() {	//ÆÐÆ¼
//		burger = new burger(595, -20, "patty");
//		burger.burger(595, -20, "patty");
//		Button.start();
//		dropburger();
		key[K] = 65;
		System.out.println("ÆÐÆ¼");
		K++;
	}
	public void pressD() {	//»óÃß
//		burger = new burger(595, -20, "lettuce");
//		burger.burger(595, -20, "lettuce");
//		Button.start();
//		dropburger();
		key[K] = 68;
		System.out.println("»óÃß");
		K++;
	}
	public void pressQ() {	//Åä¸¶Åä
//		burger = new burger(595, -20, "tomato");
//		burger.burger(595, -20, "tomato");
//		Button.start();
//		dropburger();
		key[K] = 81;
		System.out.println("Åä¸¶Åä");
		K++;
	}
	public void pressE() {	//Ä¡Áî
//		burger = new burger(595, -20, "cheese");
//		burger.burger(595, -20, "cheese");
//		Button.start();
//		dropburger();
		key[K] = 69;
		System.out.println("Ä¡Áî");
		K++;
	}
	public void pressSPACE() {	
//		Button.start();	
	}
	public void pressENTER() {
		int count=0;
		for(int i=0; i<5; i++) {
			if(array[i]!=key[i]) {
				System.out.println("ÁË¼ÛÇÕ´Ï´Ù ¼Õ´Ô;;;;");
				break;
			}
			else {
				count++;
//				System.out.println(count);
			}
		}
		if(count==5) {
			System.out.println("°¨»çÇÕ´Ï´Ù ¸ÀÀÖ°Ôµå¼¼¿ä!"); 
		}
		for(int j=0; j<4; j++) {
			array[j] = 0;
			key[j] = 0;
		}
		System.out.println("");
		
//		order();
	}

	public void screenDraw(Graphics g) {
		burger.screenDraw(g);
//		System.out.println("Draw"+burger.Thready);
//		System.out.println("GameScreenDraw");
	}

	
}
