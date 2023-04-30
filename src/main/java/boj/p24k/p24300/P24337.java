package boj.p24k.p24300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P24337 {
	static int N, a, b;
	static int highest;

	public static int[] exec(StringBuilder sb) {
		int[] arr = new int[N];
		Arrays.fill(arr, 1);
		arr[highest] = Math.max(a, b);
		int min, lev;
		min = lev = Math.min(a, b);

		for (int i = 1; lev-- > 1; i++) {
			arr[highest - i] = --a;
			arr[highest + i] = --b;
		}
		for (int i = highest + min; --b > 1; i++) {
			arr[i] = b;
		}
		for (int i = highest - min; --a > 1; i--) {
			arr[i] = a;
		}
		return arr;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		highest = a == 1 ? 0 : N - b;
		int nextIdx = 1;
		int idx = highest + b;

		if (a + b - (N + 1) > 0) {
			sb.append(-1);
		} else {
			int[] arr = exec(sb);

			sb.append(arr[0] + " ");
			int oneCnt = N - idx;
			while (oneCnt-- > 0) {
				sb.append(1 + " ");
			}

			while (nextIdx < idx) {
				sb.append(arr[nextIdx++] + " ");
			}
		}
		System.out.println(sb);
	}

}
