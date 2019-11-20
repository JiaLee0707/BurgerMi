package BurgerMi__44;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Burger extends Thread{
	private Image TrayImage = new ImageIcon("src/images/���111.png").getImage();
	private Image belowBreadImage = new ImageIcon("src/images/�Ʒ���.png").getImage();
	private Image topBreadImage = new ImageIcon("src/images/����.png").getImage();
	private Image lettuceImage = new ImageIcon("src/images/ä��.png").getImage();
	private Image tomatoImage = new ImageIcon("src/images/�丶��.png").getImage();
	private Image pattyImage = new ImageIcon("src/images/��Ƽ.png").getImage();
	private Image cheeseImage = new ImageIcon("src/images/ġ��.png").getImage();
	
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
			//i�� x�� �ƴҶ����� ������ ����
			while(i!=y) {
				i=i+1;
//				System.out.println(i);
				BurgerMi.game.Thread(ingredients, x, i, bool);
//				System.out.println(ingredients);
				BurgerMi.game.repaint();
				Thread.sleep(1);
			}
		
			//BurgerArray�� �߰�
			List<Object> Array = new ArrayList<Object>(); //�ϳ��� �ܹ��� �̹���, ��ġ List
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
		
		//�ܹ��� ��� ��ġ �ʱ�ȭ
		int orderX=0, orderY=50;
				
		//�ܹ��� ��� x��ǥ
		switch(orderSheet) {
		case 83: //�ػ�
			orderX=500; break;
		case 87: //����
			orderX=480; break;
		case 68: //����
			orderX=475; break;
		case 81: //�丶��
			orderX=490; break;
		case 65: //��Ƽ
			orderX=480; break;
		case 69: //ġ��
			orderX=475; break;
		}
				
		//��� ������ ���� y��ǥ
		if(BurgerMi.game.OrderBurger.size()+1>1) {
			orderY = orderY - (20*(BurgerMi.game.OrderBurger.size()+1));
			//�丶�� �Ǵ� ��Ƽ�� 30 �� ������
			if(ingredients.equals("tomato") || ingredients.equals("patty")) {
				orderY = orderY + 30;
			}
			//�����̸� 50 �� ����
			else if(ingredients.equals("topBread")) {
				orderY = orderY - 50;
			}
		}
		
		switch(orderSheet) {
		case 65: //��Ƽ
			BurgerMi.game.OrderBurger.add(pattyImage);
			BurgerMi.game.OrderBurger.add(orderX);
			BurgerMi.game.OrderBurger.add(orderY); break;
		case 68: //����
			BurgerMi.game.OrderBurger.add(lettuceImage);
			BurgerMi.game.OrderBurger.add(orderX);
			BurgerMi.game.OrderBurger.add(orderY); break;
		case 69: //ġ��
			BurgerMi.game.OrderBurger.add(cheeseImage);
			BurgerMi.game.OrderBurger.add(orderX);
			BurgerMi.game.OrderBurger.add(orderY); break;
		case 81: //�丶��
			BurgerMi.game.OrderBurger.add(tomatoImage);
			BurgerMi.game.OrderBurger.add(orderX);
			BurgerMi.game.OrderBurger.add(orderY); break;
		case 83: //�ػ�
			BurgerMi.game.OrderBurger.add(belowBreadImage);
			BurgerMi.game.OrderBurger.add(orderX);
			BurgerMi.game.OrderBurger.add(orderY); break;
		case 87: //����
			BurgerMi.game.OrderBurger.add(topBreadImage);
			BurgerMi.game.OrderBurger.add(orderX);
			BurgerMi.game.OrderBurger.add(orderY); break;
		}
	}

}
