package boj.p1k.p1900;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class P1922 {

	static int N, M;
	static int[] parents;

	public static int find(int a) {

		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aR, bR;
		aR = find(a);
		bR = find(b);

		if (aR == bR)
			return false;

		parents[bR] = aR;

		return true;
	}

	static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();

			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return String.format("Edge [from=%s, to=%s, weight=%s]", from, to, weight);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		Edge[] edges = new Edge[M];
		parents = new int[N + 1];
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(from, to, weight);
		}
		make();

		Arrays.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}

		});

		int cnt = 0;
		int ans = 0;
		for (Edge edge : edges) {

			if (union(edge.from, edge.to)) {
				ans += edge.weight;
				if (++cnt == N - 1) {
					break;
				}
			}
		}
		System.out.println(ans);

	}

	public static void make() {

		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}

	}

}
