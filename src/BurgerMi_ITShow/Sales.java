package BurgerMi_ITShow;

import java.awt.Font;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.JLabel;

public class Sales {
	Order order;
	Make make;
	DB db;

	int sales = 0;
//	int salesArray[] = { 10, 20, -5 };
	public JLabel salesLabel = new JLabel(sales + "점");
	Music musicOX;

	public Font font = new Font("나눔스퀘어라운드 ExtraBold", Font.ITALIC, 50);
	
	public Sales(DB db) {
		this.db = db;
		salesLabel.setFont(font); // 폰트 설정
		salesLabel.setSize(500, 500); // 크키 설정
		salesLabel.setLocation(1160, -150); // 위치 설정
		Main.burgermi.game.add(salesLabel);
	}

	public void Sales() {
		order = Main.burgermi.game.order;
		make = Main.burgermi.game.keyListener.make;
		
		boolean OX = Discriminate();

		// 점수 계산
		if (OX == true) {
			sales += order.price;
			musicOX = new Music("tpir-sdclock.mp3", false);
			if (order.who != 4) {
				System.out.println("성공");
			} else {
				sales += 1000;
				System.out.println("진상 성공");
			}
		} else {
			musicOX = new Music("띠-으-으.mp3", false);
			System.out.println("실패");
			if (order.who == 4) {
				sales -= 2000;
				System.out.println("진상 실패");
			}
		}
		musicOX.start();
		
		if(sales > 0 || sales < 0) {
			salesLabel.setLocation(1140, -150); // 위치 설정
		} else if(sales >= 100) {
			salesLabel.setLocation(1130, -150); // 위치 설정
		}
		salesLabel.setText(sales + "점");

		this.make.MakeInformation.clear();
		this.make.MakeOrderSheetArray.clear();
		this.make.MakeBurgerArray.clear();
		this.make.i.clear();
		Main.burgermi.game.order = new Order(Main.burgermi.game.db);
		Main.burgermi.game.ReGame();
		Main.burgermi.game.getParent().repaint();

		//		// this.burger.MakeBurgerObjectArray.clear();
//		this.make.MakeBurgerIntArray.clear();
//		this.make.burgerIngredient.clear(); // = new LinkedList<Object>();
//		this.make.i.clear();
////		this.burger.burgerIngredient.add(null);
////		this.burger.burgerIngredient.add(0);
////		this.burger.burgerIngredient.add(0);
//		order.orderBurgerArray = new int[5];
//
//		if (order.who == 4) {
//			Throw th = new Throw();
//			th.start();
//		} else {
////			Main.burgermi.game.order = new Order();
//			Main.burgermi.game.ReGame();
//		}
////		Main.burgermi.game.revalidate();
////		Main.burgermi.game.repaint();
//		Main.burgermi.game.getParent().repaint();
	}

	public boolean Discriminate() {
		boolean OX = true;
		
		String[] orderSeet = new String[order.orderSheet.size()];
		
		// 햄버거 배열
		String[] burger = { "계란 머핀", "모닝 머핀", "토마토햄 머핀", "햄모닝 머핀", "계란치즈 버거", "더블치즈 버거", "디폴트 버거", 
				"불고기 버거", "오버플로 버거", "채식 버거", "치즈 버거", "함박 버거" };
		
		int orderSize = Main.burgermi.game.order.orderSheet.size();
		int makeSize = Main.burgermi.game.keyListener.make.MakeOrderSheetArray.size();

		System.out.println("\n\n\n\n\n" + orderSize + " " + makeSize);

		// 버거 사이즈 비교
		if (orderSize != makeSize) {
			System.out.println("사이즈 실패");
			OX = false;
		} else {
			// 버거 재료 비교
			
			for(int i=0; i<order.orderSheet.size(); i++) {
				orderSeet[i] = order.orderSheet.get(i)[0];
			}
			
			for(int i=0; i<orderSize; i++) {
				if(orderSeet[i]!=make.MakeOrderSheetArray.get(i)) {	// 메뉴표가 다를 때
					// 버거일 경우
					if(Arrays.stream(burger).anyMatch(orderSeet[i]::equals) || make.MakeOrderSheetArray.equals("버거")) {
						int orderBurgerSize = 0;
						for(int j=0; j<order.burgerIngredient.size(); j++) {
							for(int z=0; z<order.burgerIngredient.get(j).length; z++) {
								orderBurgerSize++;
							}
						}
						if(orderBurgerSize != make.MakeBurgerArray.size()) {	// 버거 사이즈 비교
							
							System.out.println("버거사이즈 : " + orderBurgerSize + "           " + make.MakeBurgerArray.size());
							System.out.println("버거 사이즈 실패");
							OX = false;
							break;
						} else {	// 사이즈가 같으면
							// 버거 재료 비교
							int zz=0;
							for(int j=0; j<order.burgerIngredient.size(); j++) {
								for(int z=0; z<order.burgerIngredient.get(j).length; z++, zz++) {
									if(!order.burgerIngredient.get(j)[z].equals(make.MakeBurgerArray.get(zz))) {
										System.out.println(z + "       " + zz);
										System.out.println("버거 재료 : " + order.burgerIngredient.get(j)[z] + "        " + make.MakeBurgerArray.get(zz));
										System.out.println("버거 재료 실패");
										OX = false;
										break;
									}									
								}
							}
						}
					} else {
						System.out.println("메뉴 실패");
						OX = false;
						break;
					}
				}
			}
		}

		return OX;
	}

}