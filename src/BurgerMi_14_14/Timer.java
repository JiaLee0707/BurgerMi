package BurgerMi_14_14;

import java.awt.Font;

import javax.swing.JLabel;

public class Timer extends Thread {
//	int[] Time = { 0, 5 };
	int[] Time = { 0, 30 } ;
//	int[] Time = { 1, 40 };

	public JLabel time = new JLabel(Time[0] + ":" + Time[1]);
	public boolean pause = false;

	Timer() {
		time.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.ITALIC, 50)); // 폰트 설정
		time.setSize(500, 500); // 크키 설정
		time.setLocation(1140, -200); // 위치 설정

		Main.burgermi.game.add(time);

		this.start();
	}
	
	public void run() {
		try {
			while (true) {
				System.out.println(Time[0] + ":" + Time[1]);
				if(!pause) {
					time.setText(Time[0] + ":" + Time[1]);
					Time[1] -= 1;
					if (Time[1] == 0) {
						if (Time[0] == 0) break;
						Time[0] -= 1;
						Time[1] = 60;
					}
					Thread.sleep(1000);
				}
			}
//			BurgerMi.game.setFocusable(true);
			new End(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
