package study;

import java.util.Scanner;

public class NightOfKingdum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String location = sc.next();

		//시작시간
		long beforeTime = System.currentTimeMillis();
		

		int x = location.charAt(0) - 'a';
		int y = location.charAt(1) - '1';
		
		int num = 0;
		int[] xs = {2,2,-1,1,-2,-2,-1,1};
		int[] ys = {-1,1,2,2,-1,1,-2,-2};
		
		
		for(int i = 0; i < xs.length; i++) {
			int xr = xs[i]+x;
			int yr = ys[i]+y;
			
			if(xr >=0 && xr <=7 && yr >=0 && yr <=7) {
				num++;
			}
		}
		
		System.out.println(num);
		
		
		
		
		//종료 시간
		long afterTime = System.currentTimeMillis();
		//시간 차
		long secDiffTime = (afterTime - beforeTime)/1000;
		
		System.out.println("시작(s) : " + beforeTime);
		System.out.println("종료(s) : " + afterTime);
		System.out.println("시간차이(s) : " + secDiffTime);
	}

}
