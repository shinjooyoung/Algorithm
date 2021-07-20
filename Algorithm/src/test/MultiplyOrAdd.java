package test;

import java.util.Scanner;

public class MultiplyOrAdd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String numStr = sc.next();
		int limit = 2000000000;
		int result = 1;
		for(int i = 0; i < numStr.length(); i++) {
			int num = numStr.charAt(i) - '0';
			if(num == 0) {
				continue;
			}
			result = result*num <= limit ? result*num : result +num;
		}
		System.out.println(result);
	}
}
