package Test;

public class Random {
	public static void main(String sr[]) {
		Random random = new Random();

		while (true) {
			int guest = (int) (Math.random() * 6);
			System.out.println(guest);
		}
	}
}
