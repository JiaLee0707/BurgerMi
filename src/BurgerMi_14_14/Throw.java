package BurgerMi_14_14;

public class Throw extends Thread {
	public void run() {
		try {
			Main.burgermi.game.ThrowBurger = true;
			int i = 0;
			while (i < 3) {
				// 쟁반 이미지
				Main.burgermi.game.TrayBasicImage = Main.burgermi.game.ImageTrayArray[i];
				// 햄버거 이미지
				if (i != 2) {
					Main.burgermi.game.ThrowImage = Main.burgermi.game.ImageThrow[i];
				}

				if (!Main.burgermi.game.ThrowImage.equals(Main.burgermi.game.ImageTrayArray[2])) {
					Main.burgermi.game.TrayY = 450;
				}

				Main.burgermi.game.repaint();

				Thread.sleep(250);
//				Thread.sleep(1000);
				i++;
			}
			Main.burgermi.game.ThrowBurger = false;
			Main.burgermi.game.order = new Order();
			Main.burgermi.game.ReGame();
			Main.burgermi.game.getParent().repaint();
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
