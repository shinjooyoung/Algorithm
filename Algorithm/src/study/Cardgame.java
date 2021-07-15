package study;

import java.util.Scanner;

public class Cardgame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int result = 0;
		for(int i = 0; i < n; i++) {
			int min = 99999;
			for(int j = 0; j < m; j++) {
				min = Math.min(min, sc.nextInt());
			}

			result = Math.max(result, min);
		}
		
		System.out.println(result);
	}
}