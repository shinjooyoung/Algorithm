package test;

import java.util.Arrays;
import java.util.Scanner;

public class Router {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int C  = sc.nextInt();
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		//이진 탐색을 위한 정렬
		Arrays.sort(nums);

		//최소 간격 거리
		int left = 1;
		//최대 간격 거리
		int right = nums[N-1] - nums[0];
		int result = 0;
		
		while(left <= right) {
			// 기준 간격
			int mid = (left+right) / 2;
			int cnt = 1;
			int preNum = nums[0];
			for(int i = 1; i < N; i++) {
				// 간격보다 크거나 같을 경우 공유기 설치
				if(nums[i] - preNum >= mid) {
					cnt++;
					preNum = nums[i];
				}
				 
			}
			if(cnt >= C) {
				// 공유기 갯수보다 많을 경우 간격을 넓혀줌
				result = mid;
				left = mid+1;
			} else {
				//공유기가 많을 경우 간격을 줄여줌
				right = mid -1;
			}
		}
		System.out.println(result);
	}

}
