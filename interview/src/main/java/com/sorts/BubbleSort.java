package com.sorts;

public class BubbleSort {
	public static void main(String args[]) {
		int arr[] = {10,2,4,3,12,90,8};
		boolean swap = true;
		while(swap) {
			swap = false;
			for(int j=0; j<arr.length-1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swap = true;
				}
			}
		}
		for (int k=0;k<arr.length;k++) {
			System.out.println(arr[k]);
		}
	}
}
