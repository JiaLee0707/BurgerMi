package BurgerMi__77;

import java.awt.Font;

import javax.swing.JLabel;

public class Timer extends Thread {
	int[] Time = { 1, 5 };

	public JLabel time = new JLabel(Time[0] + ":" + Time[1]);

	Timer() {
		time.setFont(new Font("������������� ExtraBold", Font.ITALIC, 50)); // ��Ʈ ����
		time.setSize(500, 500); // ũŰ ����
		time.setLocation(1140, -200); // ��ġ ����
		
//		BurgerMi.game.add(time);
		this.start();
	}

	public void run() {
		try {
			while(true) {
				Time[1]-=1;					
				time.setText(Time[0]+":"+Time[1]);
				if(Time[1]==0) {
					if(Time[0]==0) break;
					Time[0]-=1;
					Time[1]=60;
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
