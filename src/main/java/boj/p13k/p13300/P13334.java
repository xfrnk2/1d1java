package boj.p13k.p13300;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P13334 {

	static class Pair implements Comparable<Pair> {
		int start, end;

		public Pair(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Pair pair) {
			int p = this.end - pair.end;
			if (p == 0) {
				return this.start - pair.start;
			}
			return p;

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		int N = Integer.valueOf(in.readLine());

		Pair[] pairs = new Pair[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int start = Integer.valueOf(st.nextToken());
			int end = Integer.valueOf(st.nextToken());
			int mi = Math.min(start, end);
			int mx = Math.max(start, end);

			pairs[i] = new Pair(mi, mx);

		}
		int D = Integer.valueOf(in.readLine());

		Arrays.sort(pairs);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (Pair pair : pairs) {
			if (Math.abs(pair.end - pair.start) <= D) {

				pq.add(pair.start);
			} else
				continue;

			while (!pq.isEmpty()) {
				if (pair.end - pq.peek() <= D)
					break;
				else
					pq.poll();
			}
			ans = Math.max(ans, pq.size());
		}
		System.out.println(ans);
	}

}
