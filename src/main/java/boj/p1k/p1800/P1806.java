package boj.p1k.p1800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1806 {
	static int N, S;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int p1 = 0, p2 = 1, sum = arr[0], ans = Integer.MAX_VALUE;

		while (p1 <= N) {
			if (S <= sum) { // 크면 p1을 좁힘

				ans = Math.min(ans, p2 - p1);
				sum -= arr[p1];
				p1++;
				continue;
			}
			if (S > sum) { // 작으면 p2를 늘림
				if (N <= p2)
					break; // 주의
				sum += arr[p2];
				p2++;
			}
		}
		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);

	}

}
