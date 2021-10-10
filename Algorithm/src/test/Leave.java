package test;

import java.util.Scanner;

public class Leave {
	
	static int N;
	static int T[];
	static int P[];
	static int dp[];
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int N = sc.nextInt();
		 T = new int[15];
		 P = new int[15];
		 dp = new int[16];
		 int maxValue = 0;
		 for(int i = 0; i < N; i++) {
			 T[i] = sc.nextInt();
			 P[i] = sc.nextInt();
		 }
		 
		 for(int i = N-1; i >=0; i--) {
			 int time = i + T[i];
			 
			 if(time <= N) {
				 dp[i] = Math.max(P[i] + dp[time], maxValue);
				 maxValue = dp[i];
			 } else {
				 dp[i] = maxValue;
			 }
		 }
		 System.out.println(maxValue);
	}

}