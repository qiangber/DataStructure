package quickSort;

public class QuickSort4 {
	public void QSort(int[] nums, int low, int high) {
		int pivot;
		while (low < high) {
			pivot = Partition(nums, low, high);
			QSort(nums, low, pivot - 1);
			low = pivot + 1;
		}
	}
	
	public int Partition(int[] nums, int low, int high) {
		int m = low + (high - low) / 2;
		if (nums[low] > nums[high]) {
			swap(nums, low, high);
		}
		if (nums[m] > nums[high]) {
			swap(nums, m, high);
		}
		if (nums[m] > nums[low]) {
			swap(nums, low, m);
		}
		int pivotkey = nums[low];
		while (low < high) {
			while (low < high && nums[high] >= pivotkey) {
				high--;
			}
			nums[low] = nums[high];
			while (low < high && nums[low] <= pivotkey) {
				low++;
			}
			nums[high] = nums[low];
		}
		nums[low] = pivotkey;
		return low;
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		QuickSort4 q = new QuickSort4();
		int[] nums = new int[]{2,1,6,10,8,4,3};
		q.QSort(nums, 0, nums.length - 1);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
	}
}
