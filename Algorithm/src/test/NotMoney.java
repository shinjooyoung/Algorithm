package test;

import java.util.Arrays;
import java.util.Scanner;

public class NotMoney {

	public static void main(String[] args) {
		//실패함...1
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		
		
		for(int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		
		int result = 1;

		for(int i = 0; i < n; i++) {
			if(result < nums[i]) {
				break;
			}
			result += nums[i];
		}
		System.out.println(result);
	}
}