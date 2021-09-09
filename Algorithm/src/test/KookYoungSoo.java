package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class KookYoungSoo {
	static class Score implements Comparable<Score> {
		private String name;
		private int korean;
		private int english;
		private int math;

		Score(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		@Override
		public int compareTo(Score others) {
			if (this.korean == others.korean && this.english == others.english && this.math == others.math) {
				return this.name.compareTo(others.name);
			}
			if (this.korean == others.korean && this.english == others.english) {
				return Integer.compare(others.math, this.math);
			}
			if (this.korean == others.korean) {
				return Integer.compare(this.english, others.english);
			}
			return Integer.compare(others.korean, this.korean);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Score> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String name = sc.next();
			int korean = sc.nextInt();
			int english = sc.nextInt();
			int math = sc.nextInt();
			System.out.println(name + " " + korean + " " + english + " " + math);
			list.add(new Score(name, korean, english, math));
		}
		Collections.sort(list);
		for (Score score : list) {
			System.out.println(score.name);
		}
	}
}
