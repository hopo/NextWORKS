package test0723;

import java.util.Random;

public class exam02 {

	public static void main(String[] args) {

		Random random = new Random();
		int[] nums = new int[20];

		for (int i = 0; i < 20; i++) {
			nums[i] = random.nextInt(100);
			System.out.print(nums[i] + " ");
		}

		findMinValue(nums);

	}

	static int findMinValue(int[] nums) {

		int lnth = nums.length;
		int minValue = nums[0];

		for (int i = 0; i < lnth; i++) {
			if (nums[i] < minValue) {
				minValue = nums[i];
			}
		}

		System.out.println("\n" + minValue);

		return minValue;
	}
}
