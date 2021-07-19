package test;

import java.util.Scanner;

public class luckyStrate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		String numStr = num + "";
		
		int first = 0;
		int second = 0;
		
		int standard = numStr.length() / 2;
		
		for(int i = 0; i < numStr.length(); i++) {
			
			if(i < standard) {
				first += numStr.charAt(i) + '0';
			} else {
				second += numStr.charAt(i) + '0';
			}
		}

		
		if(first == second) {
			System.out.println("LUCKY");
		} else {
			System.out.println("READY");
		}
		
	}

}