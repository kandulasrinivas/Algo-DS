package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class Febionacci {
	public static void main(String args[]) {
		System.out.println("Febionacii " + febionacciRecursiveMethod(10));
		febionacciArray(10);
		
	}
	//Method 1
	public static int febionacciRecursiveMethod(int n) {
		if (n<=0) {
			throw new IllegalArgumentException("Invalid value");
		}
		if (n == 1 || n ==2) {
			return 1;
		} 
		return febionacciRecursiveMethod(n-2) + febionacciRecursiveMethod(n-1);
	}
	
	//Method 2
	public static void febionacciArray(int n) {
		List<Integer> febionacciList = new ArrayList<Integer>();
		febionacciList.add(0,0); 
		febionacciList.add(1,1);
		for (int i=2; i<=n; i++) {
			febionacciList.add(i,febionacciList.get(i-2)+febionacciList.get(i-1));
		}
		for (int j=0;j<=n;j++) {
			System.out.print(" " + febionacciList.get(j));
		}
	}
	
	//Method 3
	public static int febionacci(int n) {
		int febi = 0;
		int febi1 = 1;
		for (int i=2;i<=n;i++) {
			febi = febi + febi1;
		}
		return febi;
	}
}
