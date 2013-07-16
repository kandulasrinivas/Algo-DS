package com.algo.sol;
import java.util.ArrayList;
import java.util.List;

// This program finds the Pythagorean Triples
public class PythTriplets {

	public static void main(String args[]) {
		/*List<int[]> tripplets = new ArrayList<int[]>();
		pythagoreanTripletGenerator(500, tripplets);
		printList(tripplets);
		*/
		//Tripplet Finder Method
		List<Integer> array = new ArrayList<Integer>();
		for (int i=0;i<20;i++) {
			array.add(i);
		}
		pythagoreanTripletFinder(array);
		
	}

	public static void pythagoreanTripletGenerator(int max,
			List<int[]> tripplets) {
		for (int a = 1; a <= max; a++) {
			for (int b = a; b <= max; b++) {
				int cSquared = a * a + b * b;
				int c = (int) Math.sqrt(cSquared);
				if (c > max)
					break;
				boolean perfectSqr = (c * c == cSquared);
				if (perfectSqr) {
					tripplets.add(new int[] { a, b, c });
				}
			}
		}
	}
	
	public static void printList(List<int[]> tripplets) {
		for (int[] i: tripplets) {
			System.out.println(i[0] + "*" + i[0]  + " + " + i[1]+ "*" + i[1] + "=" + i[2] + "*" + i[2] );

		}
	}
	public static void pythagoreanTripletFinder(List<Integer> array) {
		for (int i=1; i<array.size(); i++) {
			for (int j=i; j<array.size();j++) {
				int cSquare = array.get(i) * array.get(i) + array.get(j)*array.get(j);
				int c =  (int)Math.floor(Math.sqrt(cSquare));
				boolean perfectSqr = (c*c == cSquare);
				if (perfectSqr && array.contains(c)){
					System.out.println(i + "*" + i  + " + " + j + "*" + j + " = " + c + "*" + c );
				}
			}
		}
	}
}
