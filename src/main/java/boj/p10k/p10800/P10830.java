package boj.p10k.P10800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10830 {
	static int N;
	static long B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		B = Long.valueOf(st.nextToken());

		long[][] matrix = new long[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		long[][] ans = pow(matrix, B);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(ans[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

	public static long[][] pow(long[][] matrix, long p) {
		if (p == 0) {
			long[][] temp = new long[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(temp[i], 1);
			}
			return temp;
		}
		if (p == 1) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] %= 1000;
				}
			}
			return matrix;
		}
		long[][] half = pow(matrix, p / 2);
		if (p % 2 == 1) {
			return mul(mul(half, half), matrix);
		} else {
			return mul(half, half);
		}
	}

	public static long[][] mul(long[][] m1, long[][] m2) {
		long[][] m = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					m[i][j] += m1[i][k] * m2[k][j];
				} // (1,1)*(1,1) + (1,2)*(2,1) , (1,1)*(1,2)+(1,2)*(2,2)
			} // 11 21, 12 22
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				m[i][j] = m[i][j] % 1000;
			}
		}
		return m;
	}

}
