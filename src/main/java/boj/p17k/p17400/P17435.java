package boj.p17k.p17400;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P17435 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.valueOf(in.readLine());
		int log = 18;
		int[][] arr = new int[log + 1][M + 1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= M; i++) {
			arr[0][i] = Integer.valueOf(st.nextToken());
		}

		for (int i = 1; i < log + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				arr[i][j] = arr[i - 1][arr[i - 1][j]];
			}
		}

		int Q = Integer.valueOf(in.readLine());
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.valueOf(st.nextToken());
			int x = Integer.valueOf(st.nextToken());

			for (int i = 0; i <= log; i++) {
				if ((n & (1 << i)) != 0) {
					x = arr[i][x];
				}
			}

			out.write(x + "\n");
		}
		out.flush();
	}

}
