package com.sorts;

public class SelectionSort {
	public static void main(String args[]) {
		int arr[] = {10,2,4,3,12,90,8};
		for (int i=0;i<arr.length;i++) {
			for (int j=i+1;j<arr.length;j++) {
				if (arr[j]<arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		for (int k=0;k<arr.length;k++) {
			System.out.println(arr[k]);
		}
	}
}
