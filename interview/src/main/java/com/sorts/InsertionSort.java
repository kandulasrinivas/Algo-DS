package com.sorts;
//Insertion Sort
public class InsertionSort {
	public static void main(String args[]) {
		int arr[] = {10,2,4,3,12,90,8};
		for (int i=1;i<arr.length;i++) {
			for (int j=i;j>0;j--) {
				if (arr[j]<arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
		for (int k=0;k<arr.length;k++) {
			System.out.println(arr[k]);
		} 
	}

}
