package BurgerMi__1010;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Throw extends Thread {
	public void run() {
		try {
			int i = 0; // ���, (��������)�ܹ��� �迭 �ε�������
			BurgerMi.game.throwburger = true; // �ܹ��� ������
			while (i < 3) {
				BurgerMi.game.TrayBasicImage = BurgerMi.game.ImageTrayArray[i]; // ��� �̹���
				if (i == 0) {
					BurgerMi.game.ThrowImage = BurgerMi.game.ImageThrow[i]; // �ܹ��� �̹���
				} else if (i == 1) {
					BurgerMi.game.ThrowImage = BurgerMi.game.ImageThrow[i]; // �ܹ��� �̹���
				}
				BurgerMi.game.repaint(); // ȭ�� �ٽñ׸���

				Thread.sleep(250);
//				Thread.sleep(1000);
				i++;
			}
			BurgerMi.game.TrayBasicImage = BurgerMi.game.ImageTrayArray[2]; // ��� �̹��� �ʱ�ȭ
			BurgerMi.game.throwburger = false; // �ܹ��� ������ ��
			BurgerMi.game.order = new Order(); // �ֹ� �ٽùޱ�
			BurgerMi.game.order.start(); // �մ� ������
		} catch (Exception e) {
//			e.printStackTrace();
			e.getMessage();
		}
	}
}