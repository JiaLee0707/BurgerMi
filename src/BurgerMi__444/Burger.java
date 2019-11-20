package BurgerMi__444;

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

	public List<Image> ImageorderIngredients = new ArrayList<Image>();
	
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
			List<Object> Array = new ArrayList<Object>();
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

	public void orderBurger(int IntOrderIngredients) {
		switch (IntOrderIngredients) {
		case 65: //��Ƽ
			ImageorderIngredients.add(pattyImage); break;
		case 68: //����
			ImageorderIngredients.add(lettuceImage); break;
		case 69: //ġ��
			ImageorderIngredients.add(cheeseImage); break;
		case 81: //�丶��
			ImageorderIngredients.add(tomatoImage); break;
		case 83: //�ػ�
			ImageorderIngredients.add(belowBreadImage); break;
		case 87: //����
			ImageorderIngredients.add(tomatoImage); break;
		}
	}
}
