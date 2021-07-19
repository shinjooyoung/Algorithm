package test;

import java.util.Scanner;

public class Bowling {

	public static void main(String[] args) {
		// 비효율적으로 품..1
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] nums = new int[11];
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			nums[x] +=1; 
		}
		
		for(int i = 1; i <= m; i++) {
			n -= nums[i];
			result += nums[i] * n;
		}
		
		System.out.println(result);
		
//		for(int i = 0; i < n; i++) {
//			nums[i] = sc.nextInt();
//		}
//		int cnt = 0;
//		for(int i = 0; i < n; i++) {
//			for(int j = i; j < n; j++) {
//				if(nums[i] != nums[j]) {
//					cnt ++;
//				}
//			}
//		}
//		System.out.println(cnt);
		
		
	}

}