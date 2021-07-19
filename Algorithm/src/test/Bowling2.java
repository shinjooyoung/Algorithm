package test;

import java.util.Scanner;

public class Bowling2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] k = new int[11];
		for(int i = 0; i < n; i++) {
			k[sc.nextInt()] += 1;
		}
		
		int result = 0;
		for(int i = 1; i <= n; i++) {
			n -= k[i];
			result += k[i] * n;
		}
		System.out.println(result);
		
		
	}
	
}