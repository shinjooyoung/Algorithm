package study;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class UpDown {

	public static void main(String[] args) {
		// 큰수에서 작은수로 내림차순 정렬
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		Integer[] arr = new Integer[num];
		
		for(int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int num2 : arr) {
			System.out.print(num2 + " ");			
		}
	}

}
