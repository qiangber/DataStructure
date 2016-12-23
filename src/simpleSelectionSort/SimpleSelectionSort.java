package simpleSelectionSort;

import bulleSort.BulleSort;

public class SimpleSelectionSort {
	
	public void sort(int[] nums) {
		int min;
		for (int i = 0; i < nums.length; i++) {
			min = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < min) {
					min = nums[j];
				}
				if (min != nums[i]) {
					swap(nums, i, j);
				}
			}
		}
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		SimpleSelectionSort s = new SimpleSelectionSort();
		int[] nums = new int[]{9,1,5,10,8,4,5};
		s.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
	}

}
