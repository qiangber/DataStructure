package straightInsertionSort;

public class StraightInsertionSort {

	public static void sort(int[] nums) {
		int temp;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				temp = nums[i + 1];
				while(i >= 0 && nums[i] > temp) {
					nums[i + 1] = nums[i];
					i--;
				}
				nums[i + 1] = temp;
			}
		}
	}
	
	public static void main(String[] args) {		
		int[] nums = new int[]{9,1,5,10,8,4,5};
		StraightInsertionSort.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
	}

}
