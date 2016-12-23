package heapSort;

public class HeapSort {
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
	
	public static void main(String[] args) {				
		int[] nums = new int[]{9,1,5,10,8,4,5};
		new HeapSort().heapSort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
	}
}
