package boj.p14k.p14900;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P14938 {

	static int N, M, R;
	static int[] arr;
	static ArrayList<Node>[] dist;

	static class Node implements Comparable<Node> {
		int idx, cost;

		public Node(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return cost - o.cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		R = Integer.valueOf(st.nextToken());

		st = new StringTokenizer(in.readLine());
		arr = new int[N + 1];
		dist = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
			dist[i] = new ArrayList<>();
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			int cost = Integer.valueOf(st.nextToken());
			dist[from].add(new Node(to, cost));
			dist[to].add(new Node(from, cost));
		}

		int ans = 0;
		for (int start = 1; start <= N; start++) {
			ans = Math.max(ans, dijkstra(start));
		}
		System.out.println(ans);

	}

	public static int dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int idx = cur.idx;
			int cost = cur.cost;

			if (dp[idx] < cost)
				continue;

			for (Node node : dist[idx]) {
				if (dp[node.idx] > dp[idx] + node.cost) {
					dp[node.idx] = dp[idx] + node.cost;
					pq.add(new Node(node.idx, dp[idx] + node.cost));
				}
			}
		}
		int res = 0;
		for (int i = 1; i < N + 1; i++) {
			if (M >= dp[i])
				res += arr[i];

		}
		return res;

	}

}
