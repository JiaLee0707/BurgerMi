package BurgerMi__77;

public class Throw extends Thread {

	boolean Enter = false;

	public void run() {
//		System.out.println("asdf");
		Enter = true;
		try {
			int i = 0;
			while (Enter) {
				BurgerMi.game.TrayBasicImage = BurgerMi.game.TrayImage[i];
				BurgerMi.game.repaint();
				if (i == 2) {
//					interrupt();
//					join(); 
//					break;
//					return;
					Enter = false;
				}
				Thread.sleep(250);
//				Thread.sleep(1000);
				i++;
			}
		} catch (Exception e) {
//			e.printStackTrace();
			e.getMessage();
		}
	}
}