package BurgerMi__444;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
	Random random = new Random();
	private List<Integer> orderIngredients = new ArrayList<Integer>();
	private List<Integer> orderMake = new ArrayList<Integer>();
	
	Order() {
//		BurgerMi.game.revalidate();
//		BurgerMi.game.repaint();
		
		System.out.println("order");
		while(orderIngredients.size()!=5) {
			int orderSheet = (int)((Math.random() * 86) + 65);
			
			//
			switch (orderSheet) {
			case 65: //∆–∆º
				orderIngredients.add(orderSheet);
				BurgerMi.game.burger.orderBurger(orderSheet);
				System.out.println("∆–∆º"); break;
			case 68: //ªÛ√ﬂ
				orderIngredients.add(orderSheet);
				BurgerMi.game.burger.orderBurger(orderSheet);
				System.out.println("ªÛ√ﬂ"); break;
			case 69: //ƒ°¡Ó
				orderIngredients.add(orderSheet);
				BurgerMi.game.burger.orderBurger(orderSheet);
				System.out.println("ƒ°¡Ó"); break;
			case 81: //≈‰∏∂≈‰
				orderIngredients.add(orderSheet);
				BurgerMi.game.burger.orderBurger(orderSheet);
				System.out.println("≈‰∏∂≈‰"); break;
			case 83: //πÿªß
				orderIngredients.add(orderSheet);
				BurgerMi.game.burger.orderBurger(orderSheet);
				System.out.println("πÿªß"); break;
			case 87: //¿≠ªß
				orderIngredients.add(orderSheet);
				BurgerMi.game.burger.orderBurger(orderSheet);
				System.out.println("¿≠ªß"); break;
			}
//			System.out.println(orderIngredients.get(i));
		}
	}
	public void Make(int make) {
		int size=0;
		if(make==10) {
			for(int i=0; i<orderIngredients.size(); i++) {
//				System.out.print(orderIngredients.get(i)+ " ");
//				System.out.println(orderMake.get(i)+ " ");
				System.out.println(orderMake.size());
				if(size==orderIngredients.size()) {
					System.out.println("º∫∞¯");
				}
				else if((orderMake.size() == 0) || (orderIngredients.get(i) != orderMake.get(i))){
					System.out.println("Ω«∆–");
					break;
				}
				else if(orderIngredients.get(i) == orderMake.get(i)) {
					size++;
					continue;
				}
			}
			
			BurgerMi.game.BurgerArray.clear();
			BurgerMi.game.ListImage.clear();
			BurgerMi.game.ListX.clear();
			BurgerMi.game.ListY.clear();
			orderIngredients.clear();
			orderMake.clear();
			
			System.out.println("");
			BurgerMi.game.revalidate();
//			BurgerMi.game.invalidate();
			BurgerMi.game.repaint();
			System.out.println("Order");
			for(int i=0; i<BurgerMi.game.BurgerArray.size(); i++) {
				System.out.println(BurgerMi.game.BurgerArray.get(i));
			}
			System.out.println("");
			
			BurgerMi.game.order = new Order();
		}
		else orderMake.add(make);
	}
}
