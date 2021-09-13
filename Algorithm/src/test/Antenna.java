package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Antenna {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> house = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			house.add(num);
		}

		Collections.sort(house);
		int result = (N-1) / 2;

		System.out.println(house.get(result));

	}

}
