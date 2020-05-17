package BurgerMi_15_15;

import java.util.LinkedList;

import javax.swing.JLabel;

public class Ranking {
//	LinkedList<String[]> ranking = new LinkedList<String[]>();
	JLabel[] rankLable = new JLabel[5];
	public void Ranking(LinkedList<String[]> rankList) {
		int y=-250;
//		ranking.add(rankList);
		for(int i=0; i<rankLable.length; i++) {
			rankLable[i].setText(rankList.get(i)[0] + rankList.get(i)[1] + rankList.get(i)[2]);
			rankLable[i].setBounds(290, y, 1000, 1000);
			Main.burgermi.game.add(rankLable[i]);
			y -= 20;
		}
		
		
	}
}
