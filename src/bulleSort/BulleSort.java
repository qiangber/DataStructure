package bulleSort;

public class BulleSort {
	
	public void sort(int[] nums) {
		boolean flag = true;
		for (int i = nums.length; i > 0 && flag; i--) {
			flag = false;
			for (int j = 0; j < i - 1; j++) {
				if (nums[j] > nums[j+1]) {
					swap(nums, j, j+1);
					flag = true;
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
		int[] nums = new int[]{9,1,5,8,4,5};
		BulleSort b = new BulleSort();
		b.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}
}
