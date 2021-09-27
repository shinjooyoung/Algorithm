package test;

import java.util.Scanner;

public class FixedPoint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		int result = findNum(0, N-1, nums);
		
		System.out.println(result);
	}

	private static int findNum(int left, int right, int[] nums) {
		int result = -1;
		if(left <= right) {
			int mid = (left + right) / 2;
			
			if(nums[mid] == mid) {
				return mid;
			} else if(nums[mid] > mid) {
				return findNum(left, mid-1, nums);
			} else {
				return findNum(mid+1, right, nums);
			}
		}
		return result;
	}

}
