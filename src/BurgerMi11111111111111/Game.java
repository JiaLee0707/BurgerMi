package BurgerMi11111111111111;

import java.awt.Graphics;
import java.util.ArrayList;

public class Game extends Thread {
	Music Button = new Music("203.mp3", false);

	ArrayList<burger> burgerList = new ArrayList<burger>();
//	burger burger = new burger(595, -20, "belowBread");
	burger burger = new burger();

	public Game() {
		System.out.println("Game" + burger.Thready);
//		pressS();
//		pressW();
//		pressA();
//		pressD();
//		pressQ();
//		pressE();
//		pressSPACE();
//		pressENTER();
//		dropburger();
	}

	public void dropburger() {
		System.out.println("drop" + burger.Thready);
	}

	public void pressS() { // 밑빵
//		burger = new burger(595, -20, "belowBread");
		burger.burger(595, -20, "belowBread");
		System.out.println("burgerS" + burger.Thready);
		dropburger();
//		Button.start();
	}

	public void pressW() { // 윗빵
//		burger = new burger(595, -20, "topBread");
		burger.burger(595, -20, "topBread");
//		Button.start();
		dropburger();
	}

	public void pressA() { // 패티
//		burger = new burger(595, -20, "patty");
		burger.burger(595, -20, "patty");
//		Button.start();
		dropburger();
	}

	public void pressD() { // 상추
//		burger = new burger(595, -20, "lettuce");
		burger.burger(595, -20, "lettuce");
//		Button.start();
		dropburger();
	}

	public void pressQ() { // 토마토
//		burger = new burger(595, -20, "tomato");
		burger.burger(595, -20, "tomato");
//		Button.start();
		dropburger();
	}

	public void pressE() { // 치즈
//		burger = new burger(595, -20, "cheese");
		burger.burger(595, -20, "cheese");
//		Button.start();
		dropburger();
	}

	public void pressSPACE() {
//		Button.start();	
	}

	public void pressENTER() {
//		Button.start();
	}

	public void screenDraw(Graphics g) {
		burger.screenDraw(g);
//		System.out.println("Draw"+burger.Thready);
//		System.out.println("GameScreenDraw");
	}

}