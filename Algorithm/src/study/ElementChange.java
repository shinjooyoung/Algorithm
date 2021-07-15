package study;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ElementChange {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long beforeTime = System.currentTimeMillis();

		int k = sc.nextInt();
		
		
		int[] a = new int[n];
		Integer[] b = new Integer[n];
		
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		Arrays.sort(a);
		Arrays.sort(b,Collections.reverseOrder());
		
		for(int i = 0; i < k; i++) {
			int temp = a[i];
			a[i] = b[i];
			b[i] = temp;
		}
		
		
		System.out.println(Arrays.stream(a).sum());
		

		
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime)/1000;
		
		System.out.println("시작(s) : " + beforeTime);
		System.out.println("종료(s) : " + afterTime);
		System.out.println("시간차이(s) : " + secDiffTime);

	}

}
