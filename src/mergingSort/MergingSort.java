package mergingSort;

public class MergingSort {
	public void MSort(int[] SR, int[] TR1, int s, int t) {
		int[] TR2 = new int[SR.length];
		if (s == t) {
			TR1[s] = SR[s];
		} else {
			int m = (s + t) / 2;
			MSort(SR, TR2, s, m);
			MSort(SR, TR2, m + 1, t);
			Merge(TR2, TR1, s, m, t);
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
		MergingSort s = new MergingSort();
		int[] nums = new int[]{9,1,5,10,8,4,5};
		s.MSort(nums, nums, 0, nums.length - 1);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
	}
}
