package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Soldiers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		List<Integer> soldiers  = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			soldiers.add(sc.nextInt());
		}
		
		Collections.reverse(soldiers);
	
		int[] dp = new int[N];
		
		Arrays.fill(dp, 1);
		
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(soldiers.get(i) > soldiers.get(j)) {
					dp[i] = Math.max(dp[i], dp[j] + 1);					
				}
			}
		}
		
		int maxValue = 0;
		
		for(int i = 0; i < N; i++) {
			maxValue = Math.max(maxValue, dp[i]);
		}
	}

}