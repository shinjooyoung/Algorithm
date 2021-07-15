package study;

import java.util.Scanner;

public class UpDownLeftRight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		sc.nextLine();
		String loads = sc.nextLine();
		
		long beforeTime = System.currentTimeMillis();
		
		String[] plans = {"L","R","U","D"};
		int[] n = {0,0,-1,1};
		int[] m = {-1,1,0,0};
		int x = 1;
		int y = 1;
		String[] steps = loads.split(" ");
		
		for(int i =0; i < steps.length; i++) {
			String step = steps[i];
			for(int j = 0; j < plans.length; j++) {
				if(step.equals(plans[j])) {
					if(x + n[j] <= num && x + n[j] >= 1 && y + m[j] <= num && y + m[j] >= 1) {
						x += n[j];
						y += m[j];
					}
				}
			}
		}
		
		System.out.println(x +" "+ y);
		
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime)/1000;
		
		System.out.println("시작(s) : " + beforeTime);
		System.out.println("종료(s) : " + afterTime);
		System.out.println("시간차이(s) : " + secDiffTime);
	}

}
