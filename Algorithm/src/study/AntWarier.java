package study;

import java.util.Scanner;

public class AntWarier {

	public static void main(String[] args) {
		// 4
		// 1 3 1 5
		// a =a + max( a-1 a -2+a)
		
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] foods = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			int food = sc.nextInt();
			if(i > 2) {
				foods[i] = Math.max(foods[i-1], food+foods[i-2]);
			} else {
				foods[i] = food;
			}
		}
		
		System.out.println(foods[n]);
		
	}

}
