package boj.18k.18300;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P18352 {

	static int N, M, K, X, INF = Integer.MAX_VALUE;

	static ArrayList<Integer>[] graph;

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

		@Override
		public String toString() {
			return "Node [to=" + to + ", cost=" + cost + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		X = Integer.valueOf(st.nextToken());

		graph = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			graph[from].add(to);
		}

		int[] dp = new int[N + 1];
		Arrays.fill(dp, INF);
		dp[X] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dp[cur.to] < cur.cost)
				continue;
			// System.out.println(cur);

			for (Integer nxt : graph[cur.to]) {
				if (dp[nxt] > cur.cost + 1) {
					dp[nxt] = cur.cost + 1;
					pq.add(new Node(nxt, cur.cost + 1));
				}
			}

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			if (dp[i] != K)
				continue;
			sb.append(i + "\n");
		}
		if (sb.length() == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sb.toString());
		}
	}

}
