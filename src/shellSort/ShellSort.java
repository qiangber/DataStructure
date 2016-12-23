package shellSort;

public class ShellSort {
	public static void sort(int[] nums) {
		int j;
		int temp = 0;		
		int increment = nums.length;
		while(increment > 1) {
			increment = increment / 3 + 1;
			for (int i = increment; i < nums.length; i++) {
				if (nums[i - increment] > nums[i]) {
					temp = nums[i];
					for (j = i - increment; j >= 0 && nums[j] > temp; j -= increment) {
						nums[j + increment] = nums[j];
					}
					nums[j + increment] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{9,1,5,10,8,4,5};
		ShellSort.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
	}
}
