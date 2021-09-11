package test;

import java.util.Arrays;
import java.util.Scanner;

public class Antenna {

	static int n;
	static int[] house;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		house = new int[n];

		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			house[i] = num;
		}

		Arrays.sort(house);
		int lastIndex = house.length - 1;
		int standard = (house[0] + house[lastIndex]) / 2;

		int total = Integer.MAX_VALUE;
		int index = 0;
		
		for (int i = 0; i < n; i++) {

			int num = Math.abs(house[i] - standard);
			if (total > num) {
				index = house[i];
				total = num;
			} else if (total == num) {
				index = Math.min(index, house[i]);
			}
		}
		
		System.out.println(index);

	}

}


