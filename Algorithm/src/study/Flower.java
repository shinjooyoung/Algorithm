package study;

import java.util.Scanner;

public class Flower {

	public static void main(String[] args) {
		//세로가 왼쪽 2 * n  sum()
		// 타일이 다 차있을때 n = (n -1) + (n-2 *2)
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] tiles = new int[n+1];
		tiles[1] = 1;
		tiles[2] = 3;
		for(int i =3; i <=n;i++) {
			tiles[i] = (tiles[i-1] + tiles[i-2]*2) % 796796;
		}
		System.out.println(tiles[n]);
	}

}