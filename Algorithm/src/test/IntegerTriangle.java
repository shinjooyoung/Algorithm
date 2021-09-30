package test;

import java.util.Scanner;

public class IntegerTriangle {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] nums = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				nums[i][j] = sc.nextInt();
			}
		}
		int[][] dp = nums.clone();

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				int first = 0;
				int second = dp[i - 1][j];

				if (j > 0) {
					first = dp[i - 1][j - 1];
				}
				dp[i][j] = dp[i][j] + Math.max(first, second);

			}
		}
		int result = 0;

		for (int i = 0; i < n; i++) {
			result = Math.max(result, dp[n - 1][i]);
			;
		}
		System.out.println(result);
	}

}
