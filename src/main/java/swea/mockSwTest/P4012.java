package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Solution_4012_김범석 {
	static int N, R, answer;
	static int[] numbers;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			R = N / 2;
			numbers = new int[R];
			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					if (i > j) {
						arr[j][i] += Integer.parseInt(temp[j]);
					} else {
					arr[i][j] = Integer.parseInt(temp[j]);
					}
				}
			}

			answer = Integer.MAX_VALUE;

			combination(N, R);
			System.out.println("#" + tc + " " + answer);
		}

	}

	public static void combination(int cnt, int r) {
		if (r == 0) {
			calculate();
			return;
		}

		if (cnt < r)
			return;

		numbers[r - 1] = cnt - 1;
		combination(cnt - 1, r - 1);
		combination(cnt - 1, r);
	}

	public static void calculate() {
		boolean[] selected = new boolean[N];

		for (int num : numbers) {
			selected[num] = true;
		}

		int[] a = new int[R];
		int[] b = new int[R];

		int ai = 0, bi = 0;
		for (int i = 0; i < N; i++) {
			if (selected[i])
				a[ai++] = i;
			else
				b[bi++] = i;
		}
		answer = Math.min(answer, Math.abs(sum(a) - sum(b)));
	}

	public static int sum(int[] indices) {
		int result = 0;
		for (int i = 0; i < R - 1; i++) {
			for (int j = i + 1; j < R; j++) {
				result += arr[indices[i]][indices[j]];
			}
		}
		return result;
	}

}
