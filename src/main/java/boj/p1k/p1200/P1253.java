package boj.p1k.p1200;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}

		Arrays.sort(arr);
		int ans = 0;
		for (int i = 0; i < N; i++) {

			int p1 = 0;
			int p2 = N - 1;
			while (p1 < p2) {
				long res = arr[p1] + arr[p2];
				if (p1 == i) {
					p1++;
					continue;
				}
				if (p2 == i) {
					p2--;
					continue;
				}

				if (res == arr[i]) {

					ans++;
					break;
				}
				if (res > arr[i]) {
					// 합이 arr[i]보다 크면... p2를 하나 줄인다.
					p2--;
					continue;
				}
				if (res < arr[i]) { // 합이 arr[i]보다 작으면... p1을 늘린다.
					p1++;
					continue;

				}

			}

		}
		System.out.println(ans);

	}

}
