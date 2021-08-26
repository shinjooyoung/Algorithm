package test;

import java.util.Scanner;

public class Operator {
	static int n, minResult, maxResult;
	static int[] nums, operators, changeOperators;
	static boolean[] check;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		nums = new int[n+1];
		check = new boolean[n-1];
		operators = new int[n-1];
		changeOperators = new int[n-1];
		minResult = Integer.MAX_VALUE;
		maxResult = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int index = 0;
		for (int j = 0; j < 4; j++) {
			int num = sc.nextInt();
			for (int i = 0; i < num; i++) {
				operators[index] = j;
				index++;
			}
		}

		per(0);

		System.out.println(maxResult);
		System.out.println(minResult);

	}

	private static void per(int cnt) {
		if (cnt == n - 1) {
			confirm();
			return;
		}
		for (int i = 0; i < n - 1; i++) {
			if (!check[i]) {
				check[i] = true;
				changeOperators[cnt] = operators[i];
				per(cnt + 1);
				check[i] = false;
			}
		}

	}

	private static void confirm() {
		int num = nums[0];
		for (int i = 0; i < n - 1; i++) {

			switch (changeOperators[i]) {
			case 0:
				num += nums[i + 1];
				break;
			case 1:
				num -= nums[i + 1];
				break;
			case 2:
				num *= nums[i + 1];
				break;
			case 3:
				num /= nums[i + 1];
				break;

			}
		}
		maxResult = Math.max(num, maxResult);
		minResult = Math.min(num, minResult);
	}

}
