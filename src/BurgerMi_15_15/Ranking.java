package BurgerMi_15_15;

import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JLabel;

public class Ranking {

	public Font font1 = new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 40);
	public Font font2 = new Font("나눔스퀘어라운드 Light", Font.PLAIN, 40);
	
	LinkedList<String[]> ranking;
	int i=0;
	
	Ranking(JLabel[][] rankLable) {
		// DB 점수 추가
		DB db = new DB();
		db.Insert(Main.burgermi.game.score.score);
		ranking = db.Select();
		
		int y=-280;
		for(i=0; i<rankLable.length; i++) {
			int x=310;
//			System.out.println(ranking.get(i)[2]);
			if(i == ranking.size()) {
				break;
			}
			for(int j=0; j<rankLable[i].length; j++) {
				rankLable[i][j] = new JLabel(ranking.get(i)[j]);
				rankLable[i][j].setBounds(x, y, 1000, 1000);
				rankLable[i][j].setFont(font2);
				if(ranking.get(i)[1].equals(db.name) && ranking.get(i)[2].equals(Integer.toString(Main.burgermi.game.score.score))) {
					System.out.println("동일");
					rankLable[i][j].setFont(font1);				
				}
				Main.burgermi.game.add(rankLable[i][j]);
				x += 280;
			}
			y += 40;
		}
		
	}
	
	public void Button() {
		public ImageIcon
	}
}
