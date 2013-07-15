package com.recursion;

//Finding sum of numbers recursively
public class SumOfNumbers {
	public static void main(String args[]) {
		System.out.println("The sum of numbers " + sumOfNumbers(1098765));
	}
	
	public static int sumOfNumbers(int num) {
		if (num/10 == 0) return 0;
		return num + sumOfNumbers(num%10);
	}
}
