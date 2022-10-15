package boj.p13k.p13300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P13308 {

	static int N, M;
	static int[] cost;

	private static class Edge {
		int to, cost;

		public Edge(int to, int cost) {
			super();

			this.to = to;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return String.format("Edge [to=%s, cost=%s]", to, cost);
		}

	}

	private static class Vertex implements Comparable<Vertex> {
		int no, minCost;
		long totalCost;

		public Vertex(int no, int totalCost, long dst) {
			this.no = no;
			this.minCost = totalCost;
			this.totalCost = dst;
		}

		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.totalCost, o.totalCost);
		}

		@Override
		public String toString() {
			return String.format("Vertex [no=%s, minCost=%s, totalCost=%s]", no, minCost, totalCost);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cost = new int[N];
		List<Edge>[] edges = new ArrayList[N];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int len = Integer.parseInt(st.nextToken());

			edges[from].add(new Edge(to, len));
			edges[to].add(new Edge(from, len));
		}
		long[][] dp = new long[N][2501];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], Long.MAX_VALUE);
		}

		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(0, cost[0], 0));

		while (!pq.isEmpty()) {
			Vertex current = pq.poll();

			if (current.no == N - 1) {
				System.out.println(current.totalCost);

				break;
			}

			for (Edge e : edges[current.no]) {

				if (dp[e.to][current.minCost] <= current.totalCost + (current.minCost * e.cost))
					continue;
				dp[e.to][current.minCost] = current.totalCost + current.minCost * e.cost;
				pq.offer(new Vertex(e.to, Math.min(cost[e.to], current.minCost), dp[e.to][current.minCost]));
			}
		}

	}

}