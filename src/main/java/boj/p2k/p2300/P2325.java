package boj.p2k.p2300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2325 {
	static ArrayList<Node>[] adj;
	static int N, M, INF = Integer.MAX_VALUE, ans = 0;
	static int[] parent;

	static class Node implements Comparable<Node> {
		int to, cost;

		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());

		adj = new ArrayList[N + 1];
		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			int cost = Integer.valueOf(st.nextToken());
			adj[from].add(new Node(to, cost));
			adj[to].add(new Node(from, cost));
		}

		dijkstra(1);
		trace(1, N, parent[N]);
		System.out.println(ans);

	}

	public static void dijkstra(int start) {
		int[] dp = new int[N + 1];
		Arrays.fill(dp, INF);
		dp[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (dp[cur.to] < cur.cost)
				continue;

			for (Node node : adj[cur.to]) {
				if (dp[node.to] > dp[cur.to] + node.cost) {
					dp[node.to] = dp[cur.to] + node.cost;
					pq.add(new Node(node.to, dp[cur.to] + node.cost));
					parent[node.to] = cur.to;
				}
			}

		}

	}

	public static void trace(int start, int from, int to) {

		if (to == 0)
			return;

		int[] dp = new int[N + 1];
		Arrays.fill(dp, INF);
		dp[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (dp[cur.to] < cur.cost)
				continue;

			for (Node node : adj[cur.to]) {
				if ((cur.to == from && node.to == to) || (cur.to == to && node.to == from))
					continue;
				if (dp[node.to] > dp[cur.to] + node.cost) {
					dp[node.to] = dp[cur.to] + node.cost;
					pq.add(new Node(node.to, dp[cur.to] + node.cost));
				}
			}

		}
		ans = Math.max(ans, dp[N]);
		trace(start, to, parent[to]);

	}

}
