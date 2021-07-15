package study;

import java.util.Scanner;

public class IceCase {
	
	static int n,m,result;
	
	static int[][] iceCase, check;

	public static void main(String[] args) {
		
		/*
			15 14
			00000111100000
			11111101111110
			11011101101110
			11011101000000
			11011111111111
			11011111111100
			11000000011111
			01111111111111
			00000000011111
			01111111111000
			00011111111000
			00000001111000
			11111111110011
			11100011111111
			11100011111111

		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		result = 0;
		iceCase = new int[n][m]; 
		check = new int[n][m];
		
		
		for(int i = 0; i < n; i++) {
			
			String nums = sc.next();
			sc.nextLine();
			for(int j = 0; j < m; j++) {
				int num = nums.charAt(j) - '0';
				iceCase[i][j] = num;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(check[i][j] == 0 && iceCase[i][j] == 0) {
					setIce(i, j);
					result++;
				}
			}
		}
		System.out.println(result);
		
	}

	private static void setIce(int i, int j) {
		if(i >= 0 && j >= 0 && i <n && j <m && iceCase[i][j] == 0 && check[i][j]==0) {
			check[i][j] =1;
			
			setIce(i-1,j);
			setIce(i+1,j);
			setIce(i,j+1);
			setIce(i,j-1);
		}
	}

}
