package study;

import java.util.Scanner;

public class Time {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();

	
		
		//시작시간
		long beforeTime = System.currentTimeMillis();
		

		int count = 0;
		int result = 0;
		for(int i = 1; i < 60; i++) {
			String num = Integer.toString(i);
			if(num.indexOf("3") != -1) {
				count++;
			}
		}
		for(int i = 0; i <= hour; i++) {
			if(Integer.toString(i).indexOf("3") != -1) {
				result += 60*60;
			} else {
				result += count*60;
				result +=(60-count)*count;
			}
		}
		System.out.println(result);
		
		//종료 시간
		long afterTime = System.currentTimeMillis();
		//시간 차
		long secDiffTime = (afterTime - beforeTime)/1000;
		
		System.out.println("시작(s) : " + beforeTime);
		System.out.println("종료(s) : " + afterTime);
		System.out.println("시간차이(s) : " + secDiffTime);
	}

}
