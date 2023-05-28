package boj.p15k.p15700;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P15708 {

	static int N, T, P;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long acc = -P;
		int ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			acc += arr[i] + P;
			pq.add(arr[i]);

			if (acc > T) { // 초과시?
				while (!pq.isEmpty() && acc > T) {
					int v = pq.poll();
					acc -= v;
				}
			}
			ans = Math.max(pq.size(), ans);
		}

		System.out.println(ans);

	}

}
