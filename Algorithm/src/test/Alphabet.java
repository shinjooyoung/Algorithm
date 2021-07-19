package test;

import java.util.Arrays;
import java.util.Scanner;

public class Alphabet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next();
		
		String result = "";
		int sum = 0;
		for(int i = 0; i < n.length(); i++) {
			int num = n.charAt(i) - '0';
			
			if(0 <= num && num <=9) {
				sum += num;
			} else {
				result += n.charAt(i);
			}
		}
		char[] chs = result.toCharArray();
		
		Arrays.sort(chs);
		
		System.out.print(chs);
		System.out.print(sum);
	}

}
