package Test;

import java.util.Arrays;

public class If {
	public static void main(String[] ars) {
		String[] array = { "a", "b", "c", "d" };
		String s="d";
		if(Arrays.stream(array).anyMatch(s::equals)) {
			System.out.println("포함");
		} else {
			System.out.println("아님");
		}
	}
}
