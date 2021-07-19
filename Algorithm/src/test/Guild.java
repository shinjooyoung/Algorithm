package test;

import java.util.Arrays;
import java.util.Scanner;

public class Guild {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		int team = 0;
		int check = 0;
		for(int i = 0; i < n; i++) {
			int num = nums[i];
			check += 1;
			if(num == check) {
				team++;
				check = 0;
			}
		}
		System.out.println(team);
	}

}
