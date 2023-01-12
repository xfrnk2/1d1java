package boj.p2k.P2100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2156 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(in.readLine());
		int[] arr = new int[N];
		int[][] d = new int[N + 1][3];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.valueOf(in.readLine());
		}
		d[0][1] = arr[0];
		d[0][0] = d[0][2] = 0;

		for (int i = 1; i < N; i++) {
			d[i][0] += Math.max(Math.max(d[i - 1][0], d[i - 1][1]), d[i - 1][2]);
			d[i][1] += d[i - 1][0] + arr[i];
			d[i][2] += d[i - 1][1] + arr[i];

		}
		System.out.println(Math.max(Math.max(d[N - 1][0], d[N - 1][1]), d[N - 1][2]));
	}

}
