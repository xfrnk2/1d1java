package boj.p14k.p14300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14391 {
	static int N, M, ans;
	static byte[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		map = new byte[N * M];

		for (int i = 0; i < N; i++) {
			String input = in.readLine();
			for (int j = 0; j < input.length(); j++) {
				map[i * M + j] = Byte.valueOf(input.charAt(j) + "");
			}
		}

		solve();
	}

	public static void solve() {
		int ans = 0;
		int size = N * M;
		int bitSize = 1 << size;
		int horizontal, vertical;

		for (int i = 0; i < bitSize; i++) {
			horizontal = vertical = 0;

			// 세로
			for (int j = 0; j < M; j++) {
				int idx = j;
				int temp = 0;
				while (size > idx) {
					if ((i & (1 << idx)) != 0) {
						temp *= 10;
						temp += map[idx];
					} else {
						vertical += temp;
						temp = 0;
					}
					idx += M;
				}
				vertical += temp;
			}
			// 가로
			for (int j = 0; j < size; j += M) {
				int idx = j;
				int temp = 0;
				while (j + M > idx) {
					if ((i & (1 << idx)) == 0) {
						temp *= 10;
						temp += map[idx];
					} else {
						horizontal += temp;
						temp = 0;
					}
					idx += 1;
				}
				horizontal += temp;
			}
			ans = Math.max(horizontal + vertical, ans);
		}
		System.out.println(ans);
	}

}
