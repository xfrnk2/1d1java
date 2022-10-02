package boj.p2k.p2400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2467 {
	static int n;
	static long[] arr;
	static long v = Long.MAX_VALUE;
	static long[] ans = new long[2];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		arr = new long[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int lhs = 0, rhs = n - 1;
		while (lhs < rhs) {

			long cal = arr[lhs] + arr[rhs];

			if (Math.abs(cal) < v) {
				v = Math.abs(cal);
				ans[0] = arr[lhs];
				ans[1] = arr[rhs];

			}
			;

			if (cal < 0) {
				lhs++;
			} else {
				rhs--;
			}

		}
		StringBuilder sb = new StringBuilder();
		for (Long i : ans) {
			sb.append(i + " ");
		}
		System.out.println(sb.toString());

	}
}
