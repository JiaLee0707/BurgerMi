package BurgerMi__1010;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Throw extends Thread {
	public void run() {
		try {
			int i = 0; // 쟁반, (던져지는)햄버거 배열 인덱스변수
			BurgerMi.game.throwburger = true; // 햄버거 던지기
			while (i < 3) {
				BurgerMi.game.TrayBasicImage = BurgerMi.game.ImageTrayArray[i]; // 쟁반 이미지
				if (i == 0) {
					BurgerMi.game.ThrowImage = BurgerMi.game.ImageThrow[i]; // 햄버거 이미지
				} else if (i == 1) {
					BurgerMi.game.ThrowImage = BurgerMi.game.ImageThrow[i]; // 햄버거 이미지
				}
				BurgerMi.game.repaint(); // 화면 다시그리기

				Thread.sleep(250);
//				Thread.sleep(1000);
				i++;
			}
			BurgerMi.game.TrayBasicImage = BurgerMi.game.ImageTrayArray[2]; // 쟁반 이미지 초기화
			BurgerMi.game.throwburger = false; // 햄버거 던지기 끝
			BurgerMi.game.order = new Order(); // 주문 다시받기
			BurgerMi.game.order.start(); // 손님 쓰레드
		} catch (Exception e) {
//			e.printStackTrace();
			e.getMessage();
		}
	}
}