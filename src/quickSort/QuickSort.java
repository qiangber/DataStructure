package quickSort;

public class QuickSort {
	public void QSort(int[] nums, int low, int high) {
		int pivot;
		if (low < high) {
			pivot = Partition(nums, low, high);
			QSort(nums, low, pivot - 1);
			QSort(nums, pivot + 1, high);
		}
	}
	
	public int Partition(int[] nums, int low, int high) {
		int pivotkey = nums[low];
		while (low < high) {
			while (low < high && nums[high] >= pivotkey) {
				high--;
			}
			swap(nums, low, high);
			while (low < high && nums[low] <= pivotkey) {
				low++;
			}
			swap(nums, low, high);
		}
		return low;
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		int[] nums = new int[]{5,1,6,10,8,4,3};
		q.QSort(nums, 0, nums.length - 1);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
	}
}
