package BurgerMi__88888;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Throw extends Thread{

	boolean Enter = false;
	public int i=0;
	public void run() {
//		System.out.println("asdf");
		Enter=true;
		try {
			i=0;
			while(Enter) {
				BurgerMi.game.TrayBasicImage = BurgerMi.game.TrayImage[i];
				if(i==0) {
					BurgerMi.game.throwburger=true;
				}
				BurgerMi.game.repaint();
				if(i==2) {
//					interrupt();
//					join(); 
//					break;
//					return;
					Enter=false;
				}
				Thread.sleep(250);
//				Thread.sleep(1000);
				i++;
				BurgerMi.game.throwburger=false;
			}
		} catch (Exception e) {
//			e.printStackTrace();
			e.getMessage();
		}
	}
}

//class MyLabel extends JLabel {
//	int barSize = 0; // ���� ũ��
//	int maxBarSize;
//	
//	MyLabel(int maxBarSize) { 
//		this.maxBarSize = maxBarSize;
//	}
//	
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		g.setColor(Color.MAGENTA);
//		int width = (int)(((double)(this.getWidth()))
//				/maxBarSize*barSize);
//		if(width==0) return; 
//		g.fillRect(0, 0, width, this.getHeight());
//	}
//	
//	synchronized void fill() {
//		if(barSize == maxBarSize) {
//			try {
//				wait(); 
//			} catch (InterruptedException e) { return; }
//		}
//		barSize++;
//		repaint(); // �� �ٽ� �׸���
//		notify(); 
//	}
//	synchronized void consume() {
//		if(barSize == 0) {
//			try {
//				wait(); 
//			} catch (InterruptedException e)
//				 { return; }
//		}
//		barSize--;
//		repaint(); // �� �ٽ� �׸���
//		notify(); 
//	}	
//}
//
//class ConsumerThread extends Thread {
//	MyLabel bar;
//	
//	ConsumerThread(MyLabel bar) {
//		this.bar = bar;
//	}
//	public void run() {
//		while(true) {
//			try {
//				sleep(1);
//				bar.consume(); 
//			} catch (InterruptedException e)
//			 { return; }
//		}
//	}
//}
