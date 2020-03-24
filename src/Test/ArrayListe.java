package Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListe {
	public static void main(String ar[]) {
		List<Object> Array = new ArrayList<Object>();
		List<Object> Array2 = new ArrayList<Object>();
		Array2.add("arrayyyyyy");
		Array2.add(1);
		Array2.add(2);
		
		System.out.println("Array2");
		for(int i=0; i<Array2.size(); i++) {
			System.out.println(Array2.get(i));
		}
		
		System.out.println();
		
		System.out.println("Array");
		Array.add(Array2);
		Array.add(Array2);
		for (int i=0; i<Array.size(); i++) {
			System.out.println(Array.get(i));
		}
		
		Array2.clear();
		
		System.out.println("");
		
		System.out.println("Array2Clear");
		for (int i=0; i<Array2.size(); i++) {
			System.out.println(Array2.get(i));
		}
		
		System.out.println("");
		System.out.println("");
		
		Array2.add("aafasdfasdfsadfy");
		Array2.add(3);
		Array2.add(4);
		
		System.out.println("clear ÈÄ  add Array2");
		for(int i=0; i<Array2.size(); i++) {
			System.out.println((Array2.get(i)));
		}
		
		System.out.println("");
		System.out.println(Array.get(0));
//		System.out.println(Array.get(1));
		
		Array.add(Array2);
		
		
//		for (int i=0; i<Array.size(); i++) {
//			System.out.println(Array.get(0));
//			System.out.println(Array.get(1));
//		}
		System.out.println("");
		System.out.println("");

		System.out.println(((List<Object>) Array.get(0)).get(0));
		System.out.println(((List<Object>) Array.get(0)).get(1));
	
	}
}
