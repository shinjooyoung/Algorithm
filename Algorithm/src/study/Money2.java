package study;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Money2 {

	public static void main(String[] args) {
		// 2 15
		// 2
		// 3
		// an = min(an,an-m+1);
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int nums[] = new int[m+1];
		
		int[] moneys = new int[n]; 
		for(int i = 0; i < n; i++) {
			moneys[i] = sc.nextInt();
		}
		
		Arrays.fill(nums, 9999);
		
		nums[0] = 0;
		
		for(int i = 1; i <= m; i++) {
			for(int j = 0; j < n; j++) {
				if(i < moneys[j]) {
					continue;
				}
				nums[i] = Math.min(nums[i], nums[i - moneys[j]]+1);
			}
		}
		
		if(nums[m] == 9999) {
			System.out.println(-1);
		} else {
			System.out.println(nums[m]);			
		}
		
	}

}
