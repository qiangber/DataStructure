package mergingSort;

// 非递归的实现

public class MergingSort2 {
	public void MSort(int[] nums) {
		int[] TR = new int[nums.length];
		int k = 1;
		while (k < nums.length) {
			MergePass(nums, TR, k, nums.length - 1);
			k *= 2;
			MergePass(TR, nums, k, nums.length - 1);
			k *= 2;
		}
	}
	
	public void MergePass(int[] SR, int[] TR, int s, int n) {
		int i = 0;
		while (i <= n - 2*s + 1) {
			Merge(SR, TR, i, i + s - 1, i - 1 + 2*s);
			i = i + 2*s;
		}
		if (i < n - s + 1) {
			Merge(SR, TR, i, i + s - 1, n);
		} else {
			for (int j = i; j <= n; j++) {
				TR[j] = SR[j];
			}
		}
	}
	
	public void Merge(int[] SR, int[] TR, int i, int m, int n) {
		int k,j;
		for (k = i, j = m + 1; i <= m && j <= n; k++) {
			if (SR[i] < SR[j]) {
				TR[k] = SR[i++];
			} else {
				TR[k] = SR[j++];
			}
		}
		if (i <= m) {
			for (int l = 0; l <= m - i; l++) {
				TR[k + l] = SR[i + l];
			}
		}
		if (j <= n) {
			for (int l = 0; l <= n - j; l++) {
				TR[k + l] = SR[j + l];
			}
		}
	}
	
	public static void main(String[] args) {
		MergingSort2 s = new MergingSort2();
		int[] nums = new int[]{9,1,5,10,8,4,5};
		s.MSort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
	}
}
