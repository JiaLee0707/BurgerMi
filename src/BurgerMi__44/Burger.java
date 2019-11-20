package BurgerMi__44;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Burger extends Thread{
	private Image TrayImage = new ImageIcon("src/images/쟁반111.png").getImage();
	private Image belowBreadImage = new ImageIcon("src/images/아래빵.png").getImage();
	private Image topBreadImage = new ImageIcon("src/images/윗빵.png").getImage();
	private Image lettuceImage = new ImageIcon("src/images/채소.png").getImage();
	private Image tomatoImage = new ImageIcon("src/images/토마토.png").getImage();
	private Image pattyImage = new ImageIcon("src/images/패티.png").getImage();
	private Image cheeseImage = new ImageIcon("src/images/치즈.png").getImage();
	
	int x, y;
	Image ingredients;
	
	Burger(int x, int y, String ingredients) {
		this.x=x;
		this.y=y;
//		System.out.println(x+","+y);
		
		switch(ingredients) {
		case "belowBread":
			this.ingredients=belowBreadImage; break;
		case "topBread":
			this.ingredients=topBreadImage; break;
		case "lettuce":
			this.ingredients=lettuceImage; break;
		case "tomato":
			this.ingredients=tomatoImage; break;
		case "patty":
			this.ingredients=pattyImage; break;
		case "cheese":
			this.ingredients=cheeseImage; break;
		}
	}
	public void run() {
//		System.out.println("run : "+x+","+y);
		int i=0;
		boolean bool = true;
		try {
			//i가 x가 아닐때까지 스레드 실행
			while(i!=y) {
				i=i+1;
//				System.out.println(i);
				BurgerMi.game.Thread(ingredients, x, i, bool);
//				System.out.println(ingredients);
				BurgerMi.game.repaint();
				Thread.sleep(1);
			}
		
			//BurgerArray에 추가
			List<Object> Array = new ArrayList<Object>(); //하나의 햄버거 이미지, 위치 List
			Array.add(this.ingredients);
			Array.add(this.x);
			Array.add(this.y);
			BurgerMi.game.BurgerArray.add((List<Object>) Array);
			for(i=0; i<BurgerMi.game.BurgerArray.size(); i++) {
				System.out.println(BurgerMi.game.BurgerArray.get(i));
			}
			System.out.println("");
			bool = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void orderBurger(int orderSheet) {
//		List<Object> OrderArray = new ArrayList<Object>();
//		OrderArray.add();
//		OrderArray.add();
//		OrderArray.add();
		System.out.println("orderBurger");
		
		//햄버거 재료 위치 초기화
		int orderX=0, orderY=50;
				
		//햄버거 재료 x좌표
		switch(orderSheet) {
		case 83: //밑빵
			orderX=500; break;
		case 87: //윗빵
			orderX=480; break;
		case 68: //상추
			orderX=475; break;
		case 81: //토마토
			orderX=490; break;
		case 65: //패티
			orderX=480; break;
		case 69: //치즈
			orderX=475; break;
		}
				
		//재료 순서에 따른 y좌표
		if(BurgerMi.game.OrderBurger.size()+1>1) {
			orderY = orderY - (20*(BurgerMi.game.OrderBurger.size()+1));
			//토마토 또는 패티면 30 더 밑으로
			if(ingredients.equals("tomato") || ingredients.equals("patty")) {
				orderY = orderY + 30;
			}
			//윗빵이면 50 더 위로
			else if(ingredients.equals("topBread")) {
				orderY = orderY - 50;
			}
		}
		
		switch(orderSheet) {
		case 65: //패티
			BurgerMi.game.OrderBurger.add(pattyImage);
			BurgerMi.game.OrderBurger.add(orderX);
			BurgerMi.game.OrderBurger.add(orderY); break;
		case 68: //상추
			BurgerMi.game.OrderBurger.add(lettuceImage);
			BurgerMi.game.OrderBurger.add(orderX);
			BurgerMi.game.OrderBurger.add(orderY); break;
		case 69: //치즈
			BurgerMi.game.OrderBurger.add(cheeseImage);
			BurgerMi.game.OrderBurger.add(orderX);
			BurgerMi.game.OrderBurger.add(orderY); break;
		case 81: //토마토
			BurgerMi.game.OrderBurger.add(tomatoImage);
			BurgerMi.game.OrderBurger.add(orderX);
			BurgerMi.game.OrderBurger.add(orderY); break;
		case 83: //밑빵
			BurgerMi.game.OrderBurger.add(belowBreadImage);
			BurgerMi.game.OrderBurger.add(orderX);
			BurgerMi.game.OrderBurger.add(orderY); break;
		case 87: //윗빵
			BurgerMi.game.OrderBurger.add(topBreadImage);
			BurgerMi.game.OrderBurger.add(orderX);
			BurgerMi.game.OrderBurger.add(orderY); break;
		}
	}

}
