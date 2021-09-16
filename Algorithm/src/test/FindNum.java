package test;

import java.util.Scanner;

public class FindNum {
	static int[] nums;
	static int N,x;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		x= sc.nextInt();
		
		nums = new int[N]; 
		
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		int under = underSearch(0, N);
		int upper = upperSearch(0, N);
		
		int result = upper - under; 
		if(result == 0) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}
	
	
	
	private static int underSearch(int low, int hight) {
		
		while(low < hight) {
			int mid = (low+hight) / 2;
			if(nums[mid] >= x) hight = mid;
			else low++;
		}
		
		return hight;
	}


	private static int upperSearch(int low, int hight) {
		while(low < hight) {
			int mid = (low+hight) / 2;
			if(nums[mid] > x ) hight = mid;
			else low++;
		}
		
		return hight;
	}

}
