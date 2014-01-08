package labone.insertionsort;

import java.util.Scanner;

public class InsertionSort {
	
	public static void linearSearch(int[] array, int key) {
		insertionSort(array);
		boolean foundFlag = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				System.out.println(Integer.toString(key) + " is at index " 
						+ Integer.toString(i) + ".");
				foundFlag = true;
			}
		}
		if (!foundFlag) System.out.println("The entered value was not found.");
		return;
	}
	
	public static void binarySearch(int[] array) {
		insertionSort(array);
	}
	
	private static int[] insertionSort(int[] array) {
		int key = 0;
		int i = 0;
		for (int j = 1; j < array.length; j++) {
			key = array[j];
			i = j - 1;
			while(i > 0 && array[i] > key) {
				array[i + 1] = array[i];
				i = i - 1;
			}
			array[i + 1] = key;
		}
		return array;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		int[] array = new int[n];
		int key = Integer.parseInt(scan.next());
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * n + 1);
			if (i < array.length - 1) {
				System.out.print(array[i] + ", ");
			}
			else System.out.println(i);
		}
		linearSearch(array, key);
		scan.close();
	}
}
	
