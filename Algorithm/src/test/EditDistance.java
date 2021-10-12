package test;

import java.util.Scanner;

public class EditDistance {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = "0";
		a += sc.next();
		sc.nextLine();
		String b = "0";
		b += sc.next();
		
		int[][] dp = new int[a.length()+1][b.length()+1];
		
		//기본 값 셋팅
		dp[0][0] = 0;
		for(int i = 1; i < a.length(); i++) {
			dp[i][0] = i;
		}
		for(int i = 1; i < b.length(); i++) {
			dp[0][i] = i;
		}
		
		
		for(int i = 1; i < a.length(); i++) {
			for(int j = 1; j < b.length(); j++) {
				char charA = a.charAt(i);
				char charB = b.charAt(j);
				if(charA == charB) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
				}
			}	
		}
		
		System.out.println(dp[a.length()-1][b.length()-1]);
	}

}
