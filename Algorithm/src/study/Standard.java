package study;

import java.util.Scanner;

public class Standard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// codeUp 1032
//		int num = sc.nextInt();
//		System.out.println(Integer.toHexString(num));
		
		// codeUp 1034
//		String oct = sc.next();
//		System.out.println(Integer.valueOf(oct,8));
		
		// codeUP 1035
//		String hex = sc.next();
//		System.out.println(Integer.toOctalString(Integer.valueOf(hex,16)));
		
		// codeUP 1036
//		char a = sc.next().charAt(0);
//		System.out.println((int)a);
//		sc.close();
		
		// codeUP 1036
//		int a = sc.nextInt();
//		System.out.println((char)a);
//		sc.close();
		
		// codeUP 1037
//		int a = sc.nextInt();
//		System.out.println((char)a);
//		sc.close();
		
		// codeUP 1038
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		System.out.println(a + b);
		
		// codeUP 1039
//		long a = sc.nextLong();
//		long b = sc.nextLong();
//		System.out.println(a + b);
		
		// codeUP 1040
//		int a = sc.nextInt();
//		System.out.println(-a);
		
		// codeUP 1041
//		String a = sc.next();
//		System.out.println((char)((int)a.charAt(0) + 1));
		
		// codeUP 1042
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		System.out.println(a/b);
		
		// codeUP 1099
		int[][] nums = new int [10][10];
		
		for(int i = 0; i< nums.length; i++) {
			for(int j =0; j < nums.length; j++) {
				nums[j][i] = sc.nextInt();
			}
		}
		int first = 1;
		int second = 1;
		boolean load = true;
		nums[first][second] = 9;
		while(load) {
			if(nums[first+1][second] == 0) {
				nums[first+1][second] = 9;
				first++;	
			} else if(nums[first][second+1] == 0) {
				nums[first][second+1] = 9;
				second++;
			} else if(nums[first+1][second]==2) {
				nums[first+1][second] = 9;
				load =false;
			} else if(nums[first][second+1]==2) {
				nums[first][second+1] = 9;
				load =false;
			} else {
				load =false;
			}

		}
		System.out.println();
		for(int i = 0; i< nums.length; i++) {
			for(int j =0; j < nums.length; j++) {
				System.out.print(nums[j][i]);
			}
			System.out.println();
		}
		
		
	
	}

}
