package boj.p10k.p10900;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P10942 {
	static int N, M;
	static int[] numbers;
	static int[][] d;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		N = Integer.valueOf(in.readLine());
		numbers = new int[N + 1];
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			numbers[i] = Integer.valueOf(st.nextToken());
		}
		d = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			d[i][i] = 1;
		}

		for (int i = 1; i < N; i++) {
			if (numbers[i] == numbers[i + 1]) {
				d[i][i + 1] = 1;
				d[i + 1][i] = 1;
			}
		}

		for (int k = 2; k < N; k++) { // 가중치
			for (int i = 1; i <= N - k; i++) {
				if (d[i + 1][i + k - 1] == 1 && numbers[i] == numbers[i + k]) {
					d[i][i + k] = 1;
					d[i + k][i] = 1;
				}
			}
		}

		M = Integer.valueOf(in.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.valueOf(st.nextToken());
			int end = Integer.valueOf(st.nextToken());
			out.write(d[start][end] + "\n");
		}
		out.flush();

	}

}
