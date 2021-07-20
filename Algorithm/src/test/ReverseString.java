package test;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String numStr = sc.next();
		
		String[] zero = numStr.split("1");
		String[] one = numStr.split("0");
		int zeroCnt = 0;
		for(int i = 0; i < zero.length; i++) {
			if(zero[i].equals("")) {
				continue;
			}
			zeroCnt++;
		}
		int oneCnt = 0;
		for(int i = 0; i < one.length; i++) {
			if(one[i].equals("")) {
				continue;
			}
			oneCnt++;
		}
		
		System.out.println(Math.min(zeroCnt, oneCnt));
	}

}
