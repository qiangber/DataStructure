package scanner;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = Integer.valueOf(scanner.nextLine());
		int[] nums = new int[num];
		int i = 0;
		while (i < num) {
			nums[i] = Integer.valueOf(scanner.nextLine());
			i++;
		}
		for (int j = 0; j < nums.length; j++) {
			System.out.println(ScannerTest.luckNum(nums[j]));			
		}
	}
	
	public static int luckNum(int n) {
		int result = 0;
		while (n > 0) {
			String binary = Integer.toBinaryString(n);
			int bi = 0;
			for (int i = 0; i < binary.length(); i++) {
				if (binary.charAt(i) == '1') {
					bi++;
				}
			}
			int decimal = 0;
			int temp = n;
			while (temp != 0) {
				decimal += temp % 10;
				temp = temp / 10;
			}
			if (bi == decimal) {
				result++;
			}
			n--;
		}
		return result;
	}
}
