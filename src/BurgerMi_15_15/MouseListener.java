package BurgerMi_15_15;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MouseListener {
	ImageIcon StartBasicImage = new ImageIcon("src/images/startButtonBasic.png");
	ImageIcon StartEnteredImage = new ImageIcon("src/images/startButtonEntered.png");
	ImageIcon QuitBasicImage = new ImageIcon("src/images/quitButtonBasic.png");
	ImageIcon QuitEnteredImage = new ImageIcon("src/images/quitButtonEntered.png");
	ImageIcon ReplayBasicImage = new ImageIcon("src/images/replayButtonBasic.png");
	ImageIcon ReplayEnteredImage = new ImageIcon("src/images/replayButtonEntered.png");

	ImageIcon rightNextBasicImage = new ImageIcon("src/images/rightArrow.png");
	ImageIcon rightNextEnteredImage = new ImageIcon("src/images/rightArrow2.png");
	ImageIcon leftNextBasicImage = new ImageIcon("src/images/leftArrow.png");
	ImageIcon leftNextEnteredImage = new ImageIcon("src/images/leftArrow2.png");
	
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	
	int nextI;

	class Listener extends MouseAdapter {
		String panel;
		ImageIcon Basic;
		ImageIcon Entered;

		public Listener(String panel, ImageIcon BasicImageIcon, ImageIcon EnteredImageIcon) {
			this.panel = panel;
			Basic = BasicImageIcon;
			Entered = EnteredImageIcon;
		}

		// 기본버튼
		@Override
		public void mouseExited(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Basic);
		}

		// 클릭버튼
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Entered);

			Music Button = new Music("buttonPressedMusic.mp3", false);
			Button.start();

			if (Entered.equals(QuitEnteredImage)) { // 게임 끝
				System.exit(0);
			} else if (panel.equals("Background") && Entered.equals(StartEnteredImage)) { // 타이틀에서 게임 시작
				Main.burgermi.JPanelChange("game");
			} else if (panel.equals("Game") && Entered.equals(StartEnteredImage)) { // 게임방법 이후 게임 시작
				Main.burgermi.game.GameStart();
			} else if (panel.equals("End") && Entered.equals(ReplayEnteredImage)) {
				Main.burgermi.JPanelChange("replay");
			}
		}

		// 버튼 위에 올리면
		@Override
		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Entered);
			button.setCursor(cursor);

			Music Button = new Music("buttonEnteredMusic.mp3", false);
			Button.start();

		}
	}
	
	class rightNextButton extends MouseAdapter {
//		String panel;
		Ranking ranking;
		ImageIcon Basic;
		ImageIcon Entered;
		
		public rightNextButton(Ranking ranking, ImageIcon BasicImageIcon, ImageIcon EnteredImageIcon) {
			this.ranking = ranking;
			Basic = BasicImageIcon;
			Entered = EnteredImageIcon;
			
			nextI = ranking.getI();
		}
		
		// 기본버튼
		@Override
		public void mouseExited(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Basic);
		}
		
		// 클릭버튼
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Entered);
			
//			if (Entered.equals(rightNextEnteredImage)) {
//				nextI++;
				for (int i = 0; i < ranking.n; i++, nextI++) {
					int x = 320;
//					System.out.println(ranking.get(i)[2]);
					
					// 데이터 갯수(rankingList) 갯수 화면에 나타낼 갯수보다 적을 때
					// 이번에 화면 출력하는 갯수와 데이터 사이즈와 같으면 break; 
					if (i == ranking.rankingList.size() || nextI == ranking.rankingList.size()) {
						for (i = i; i < ranking.n; i++) {
							for (int j = 0; j < ranking.rankLable[i].length; j++) {
								ranking.rankLable[i][j].setText("");
							}
						}
						break;
					}
					
					for (int j = 0; j < ranking.rankLable[i].length; j++) {
						ranking.rankLable[i][j].setText(ranking.rankingList.get(nextI)[j]);
						ranking.rankLable[i][j].setFont(ranking.font2);
						if (ranking.rankingList.get(i)[1].equals(ranking.db.name)
								&& ranking.rankingList.get(i)[2].equals(Integer.toString(Main.burgermi.game.score.score))) {
							System.out.println("동일");
							ranking.rankLable[i][j].setFont(ranking.font1);
						}
					}
				}
//			}
//			else if (Entered.equals(leftNextEnteredImage)) {
//				nextI = nextI - 5;
//				for (int i = 0; i < ranking.n; i++, nextI++) {
//					int x = 320;
////					System.out.println(ranking.get(i)[2]);
//					
//					// 데이터 갯수(rankingList) 갯수 화면에 나타낼 갯수보다 적을 때
//					// 이번에 화면 출력하는 갯수와 데이터 사이즈와 같으면 break; 
//					if (i == ranking.rankingList.size() || nextI == ranking.rankingList.size()) {
//						for (i = i; i < ranking.n; i++) {
//							for (int j = 0; j < ranking.rankLable[i].length; j++) {
//								ranking.rankLable[i][j].setText("");
//							}
//						}
//						break;
//					}
//					
//					for (int j = 0; j < ranking.rankLable[i].length; j++) {
//						ranking.rankLable[i][j].setText(ranking.rankingList.get(nextI)[j]);
//						ranking.rankLable[i][j].setFont(ranking.font2);
//						if (ranking.rankingList.get(i)[1].equals(ranking.db.name)
//								&& ranking.rankingList.get(i)[2].equals(Integer.toString(Main.burgermi.game.score.score))) {
//							System.out.println("동일");
//							ranking.rankLable[i][j].setFont(ranking.font1);
//						}
//					}
//				}
//			}
			
			
			Music Button = new Music("buttonPressedMusic.mp3", false);
			Button.start();			
			if(nextI > 5) {
				ranking.leftNextBut.setVisible(true);
			} else {
				ranking.leftNextBut.setVisible(false);
			}
			
			Main.burgermi.game.getParent().repaint();
		}
		
		// 버튼 위에 올리면
		@Override
		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Entered);
			button.setCursor(cursor);
			
			Music Button = new Music("buttonEnteredMusic.mp3", false);
			Button.start();
			
		}
	}
	
	class leftNextButton extends MouseAdapter {
//		String panel;
		Ranking ranking;
		ImageIcon Basic;
		ImageIcon Entered;
		
		public leftNextButton(Ranking ranking, ImageIcon BasicImageIcon, ImageIcon EnteredImageIcon) {
			this.ranking = ranking;
			Basic = BasicImageIcon;
			Entered = EnteredImageIcon;
			
			nextI = ranking.getI();
			ranking.setI(nextI);
		}
		
		// 기본버튼
		@Override
		public void mouseExited(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Basic);
		}
		
		// 클릭버튼
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Entered);
			
//			if (Entered.equals(leftNextEnteredImage)) {
				nextI = nextI - 10;
				for (int i = 0; i < ranking.n; i++, nextI++) {
					int x = 320;
//					System.out.println(ranking.get(i)[2]);
					
					// 데이터 갯수(rankingList) 갯수 화면에 나타낼 갯수보다 적을 때
					// 이번에 화면 출력하는 갯수와 데이터 사이즈와 같으면 break; 
					if (i == ranking.rankingList.size() || nextI == ranking.rankingList.size()) {
						for (i = i; i < ranking.n; i++) {
							for (int j = 0; j < ranking.rankLable[i].length; j++) {
								ranking.rankLable[i][j].setText("");
							}
						}
						break;
					}
					
					for (int j = 0; j < ranking.rankLable[i].length; j++) {
						ranking.rankLable[i][j].setText(ranking.rankingList.get(nextI)[j]);
						ranking.rankLable[i][j].setFont(ranking.font2);
						if (ranking.rankingList.get(i)[1].equals(ranking.db.name)
								&& ranking.rankingList.get(i)[2].equals(Integer.toString(Main.burgermi.game.score.score))) {
							System.out.println("동일");
							ranking.rankLable[i][j].setFont(ranking.font1);
						}
					}
				}
//			}
			
			
			Music Button = new Music("buttonPressedMusic.mp3", false);
			Button.start();			
			if(nextI > 5) {
				ranking.leftNextBut.setVisible(true);
			} else {
				ranking.leftNextBut.setVisible(false);
			}
			if(nextI == ranking.rankingList.size()) {
				ranking.rightNextBut.setVisible(false);
			} else {
				ranking.rightNextBut.setVisible(true);
			}
			
			Main.burgermi.game.getParent().repaint();
		}
		
		// 버튼 위에 올리면
		@Override
		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Entered);
			button.setCursor(cursor);
			
			Music Button = new Music("buttonEnteredMusic.mp3", false);
			Button.start();
			
		}
	}
}