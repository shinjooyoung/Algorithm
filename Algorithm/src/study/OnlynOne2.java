package study;

import java.util.Scanner;

public class OnlynOne2 {

	public static void main(String[] args) {
		// X가 5으로 나누어 떨어지면, 5으로 나눈다.
		// X가 3으로 나누어 떨어지면, 3으로 나눈다.
		// X가 2로 나누어 떨어지면, 2로 나눈다.
		// X에서 1을 뺀다.
		// 26 = 3
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] nums = new int[n+1];

		
		for(int i = 2; i <= n; i++ ) {
			
			int num = nums[i-1] +1;
			
			if(i % 2 == 0) {
				num = Math.min(num, nums[i / 2] +1);  
			}
			if(i % 3 == 0) {
				num = Math.min(num, nums[i / 3] +1);  
			}
			
			if(i % 5 == 0) {
				num = Math.min(num, nums[i / 5] +1);  
			}
			
			nums[i] = num;
		}
		
		System.out.println(nums[n]);
	
	}

}
