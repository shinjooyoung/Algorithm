package study;

import java.util.Arrays;
import java.util.Scanner;

public class RiceCake {

	public static void main(String[] args) {
		// 4 6 
		// 19 15 10 17
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] riceCakes = new int[n];
		for(int i = 0; i < n; i++) {
			riceCakes[i] = sc.nextInt();
		}
		Arrays.sort(riceCakes);
		
		int result = binarySearch(riceCakes, 1, riceCakes[riceCakes.length-1],6);
		
		System.out.println(result);
	}

	private static int binarySearch(int[] riceCakes, int start, int end, int findNum) {
		int middle = (start + end) / 2;
		int middleSum = calculateNum(riceCakes,middle);
		if(middleSum == findNum) {
			return middle;
		} else {
			if(start < end) {
				if(calculateNum(riceCakes,middle) < findNum) {
					return binarySearch(riceCakes, start, middle-1, findNum);
				} else {
					return binarySearch(riceCakes, middle+1, end, findNum);
				}
			} else {
				return 9999;
			}
			
		}
	}

	private static int calculateNum(int[] riceCakesint, int middle) {
		int sum = 0;
		for(int i = 0; i < riceCakesint.length; i++) {
			int rice = riceCakesint[i]-middle;
			if(rice > 0) {
				sum += rice;
			}
		}
		return sum;
	}

}

