package scanner;

import java.util.Scanner;

class HeapSort {
	public void heapSort(int[][] nums) {
		for (int i = nums.length / 2 - 1; i >= 0; i--) {
			HeapAdjust(nums, i, nums.length);
		}
		for (int i = nums.length - 1; i > 0; i--) {
			swap(nums, 0, i);
			HeapAdjust(nums, 0, i);
		}
	}
	
	public void swap(int[][] nums, int i, int j) {
		int[] temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public void HeapAdjust(int[][] nums, int s, int length) {
		int[] temp = nums[s];
		for (int j = s * 2 + 1; j < length; j = j * 2 + 1) {
			if (j < length - 1 && nums[j][1] < nums[j + 1][1]) {
				j++;
			}
			if (temp[1] > nums[j][1]) {
				break;
			}
			nums[s] = nums[j];
			s = j;
		}
		nums[s]	= temp;		
	}
}

class HeapSort2 {
	public void heapSort(int[] nums) {
		for (int i = nums.length / 2 - 1; i >= 0; i--) {
			HeapAdjust(nums, i, nums.length);
		}
		for (int i = nums.length - 1; i > 0; i--) {
			swap(nums, 0, i);
			HeapAdjust(nums, 0, i);
		}
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public void HeapAdjust(int[] nums, int s, int length) {
		int temp = nums[s];
		for (int j = s * 2 + 1; j < length; j = j * 2 + 1) {
			if (j < length - 1 && nums[j] < nums[j + 1]) {
				j++;
			}
			if (temp > nums[j]) {
				break;
			}
			nums[s] = nums[j];
			s = j;
		}
		nums[s]	= temp;		
	}
}

class Customer {
	int capacity = 0;
	int expense = 0;
}

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String msg = scanner.nextLine();
		int tableNum = Integer.parseInt(msg.split(" ")[0]);
		int customersNum = Integer.parseInt(msg.split(" ")[1]);
		int[] tableC = new int[tableNum];
		String[] tableMsg = scanner.nextLine().split(" ");
		for (int i = 0; i < tableNum; i++) {
			tableC[i] = Integer.parseInt(tableMsg[i]);
		}
		int[][] customers = new int[customersNum][2];
		for (int i = 0; i < customersNum; i++) {
			String[] customerMsg = scanner.nextLine().split(" ");
			customers[i][0] = Integer.parseInt(customerMsg[0]);
			customers[i][1] = Integer.parseInt(customerMsg[1]);
		}
		HeapSort sort = new HeapSort();
		sort.heapSort(customers);
		HeapSort2 sort2 = new HeapSort2();
		sort2.heapSort(tableC);
		System.out.println(getMaxExpense(tableC, customers));
	}
	
	public static int getMaxExpense(int[] tableC, int[][] customers) {		
		int Expenses = 0;
		for (int i = customers.length - 1; i >= 0; i--) {
			for (int j = 0; j < tableC.length; j++) {
				if (tableC[j] >= customers[i][0]) {
					Expenses += customers[i][1];
					tableC[j] = 0;
					break;
				}
			}
		}
		return Expenses;
	}
}