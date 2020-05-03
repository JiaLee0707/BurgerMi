package Test;

import java.util.ArrayList;
import java.util.List;

public class vector {
	Random random = new Random();

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();

//		System.out.println(a.size());
		int i = (int) (Math.random() * 6);
		for (int ii = 0; ii < 5; ii++) {
			a.add(0);
		}
		System.out.println("0초기화");
		for (int ii = 0; ii < a.size(); ii++) {
			System.out.println(a.get(ii));
		}
		System.out.println("\n\n\n");
		if (i != 4) {
			a.set(0, 4);
			a.set(4, 4);
			System.out.println("4나옴(4추가)");
			for (int ii = 0; ii < a.size(); ii++) {
				System.out.println(a.get(ii));
			}
			System.out.println("\n\n\n");

			System.out.println("나머지방 1추가");
			for (int ii = 1; ii < 4; ii++) {
				a.set(ii, 1);
			}
			System.out.println("\n\n\n");

			System.out.println("총 방");
			for (int ii = 0; ii < a.size(); ii++) {
				System.out.println(ii + "번째 방 : " + a.get(ii));
			}
		} else {
			for (int ii = 0; ii < 5; ii++) {
				a.add(ii);
			}
			System.out.println("4안나옴");
			for (int ii = 0; ii < a.size(); ii++) {
				System.out.println(a.get(ii));
			}
		}

//		for(int ii=0; ii<a.size(); ii++) {
//			System.out.println(a.get(ii));
//		}
	}
}