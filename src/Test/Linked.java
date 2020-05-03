package Test;

import java.util.LinkedList;

public class Linked {
	public static void main(String[] args) {
		LinkedList<Integer> i = new LinkedList<Integer>();
		i.add(0);
		Integer ii = 10;
		for (int j = 0; j < i.size(); j++) {
			while (i.get(j) != ii) {
				i.set(0, i.get(j) + 1);
				System.out.println(i.get(j));
			}
		}
	}
}