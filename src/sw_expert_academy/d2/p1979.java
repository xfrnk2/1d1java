package sw_expert_academy.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class p1979 {
	static int[][] array;
	static int n, k;

	private static boolean checkIsValidRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}

	private static boolean checkIsRowAvailable(int x, int y) {
		for (int i = 0; i < k; i++) {
			if (!checkIsValidRange(x, y + i)) {
				return false;
			}
			if (array[x][y + i] == 0) {
				return false;
			}
		}
		return (!checkIsValidRange(x, y - 1) || array[x][y - 1] == 0) && (!checkIsValidRange(x, y + k)
			|| array[x][y + k] == 0);
	}

	private static boolean checkIsColAvailable(int x, int y) {

		for (int i = 0; i < k; i++) {
			if (!checkIsValidRange(x + i, y)) {
				return false;
			}
			if (array[x + i][y] == 0) {
				return false;
			}
		}
		return (!checkIsValidRange(x - 1, y) || array[x - 1][y] == 0) && (!checkIsValidRange(x + k, y)
			|| array[x + k][y] == 0);
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		for (int c = 0; c < t; c++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			int answer;
			answer = 0;

			array = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {

					if (array[i][j] == 0) {
						continue;
					}

					if (checkIsRowAvailable(i, j)) {
						answer += 1;
					}
					if (checkIsColAvailable(i, j)) {
						answer += 1;
					}
				}
			}
			System.out.println(String.format("#%d %d", c + 1, answer));
		}

	}
}