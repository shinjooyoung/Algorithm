package study;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BigNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		
		Integer[] arr = new Integer[num];
		
		for(int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		int first = arr[0];
		int second = arr[1];
		
		int result = 0;
		
		result += ((k / m) * m) * first;
		result += (k % m) * second;
		System.out.println(result);
		
		
		

	}

}
