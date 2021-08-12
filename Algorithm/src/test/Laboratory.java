package test;

import java.util.Scanner;

public class Laboratory {

	static int limit = 3;
	static int n, m;
	static int[][] map;
	static int result = 0;
	static int[][] cloneMap;
	static int[] nx = { 1, -1, 0, 0 };
	static int[] ny = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		cloneMap = new int[n][m];

		//맵 셋팅
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		per(0);

		System.out.println(result);

	}

	private static void per(int cnt) {
		if (cnt == limit) {
			checkMap();
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					per(cnt + 1);
					map[i][j] = 0;
				}

			}
		}

	}

	private static void checkMap() {
		// 맵 복사
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cloneMap[i][j] = map[i][j];

			}
		}
		// 좀비 감염
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (cloneMap[i][j] == 2) {
					setPoison(i, j);
				}
			}
		}
		int normal = 0;
		// 생존자 확인
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (cloneMap[i][j] == 0) {
					normal++;
				}
			}
		}

		result = Math.max(result, normal);

	}

	private static void setPoison(int i, int j) {

		for (int k = 0; k < 4; k++) {
			int x = i + nx[k];
			int y = j + ny[k];
			if (x >= 0 && y >= 00 && x < n && y < m) {
				if (cloneMap[x][y] == 0) {
					cloneMap[x][y] = 2;
					setPoison(x, y);
				}
			}

		}
	}

}