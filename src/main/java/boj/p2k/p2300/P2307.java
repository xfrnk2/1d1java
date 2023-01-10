package boj.p2k.p2300;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2307 {
	static int N, M, INF = Integer.MAX_VALUE;
	static int[] parents;
	static long ans;
	static List<Node>[] rec;

	public static void main(String[] args) throws Exception {
		/*
		 * 다익스트라로 최단경로 구하기(1 to N) M회 순회하여 모든 간선을 없애고, 최단경로(1 to N)을 구하되, INF가 있는 경우 -1을
		 * 출력하고 종료 M회 순회하는동안 지연시간의 최대를 구해야 하므로, 경찰이 없을떄를 a, 있을때를 b라고 한다면, Max(ans, b -
		 * a)로 갱신해주기
		 */

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		rec = new ArrayList[N + 1];
		parents = new int[N + 1];
		ans = 0;

		for (int i = 0; i < N + 1; i++) {
			rec[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			int time = Integer.valueOf(st.nextToken());
			rec[from].add(new Node(to, time));
			rec[to].add(new Node(from, time));
		}

		long normal = dijkstra(1);
		trace(normal, N, parents[N]);
		System.out.println(ans == INF ? -1 : ans - normal);

	}

	public static long dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		long[] dp = new long[N + 1];
		Arrays.fill(dp, INF);
		dp[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int idx = cur.idx;
			long time = cur.time;
			if (dp[idx] < time)
				continue;
			for (Node node : rec[idx]) {
				if (dp[node.idx] > dp[idx] + node.time) {
					dp[node.idx] = dp[idx] + node.time;
					pq.add(new Node(node.idx, dp[idx] + node.time));
					parents[node.idx] = idx;
				}
			}
		}
		return dp[N];
	}

	// N으로부터 거슬러 오르기
	public static void trace(long normal, int from, int to) {
		if (to == 0) {
			return;
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		long[] dp = new long[N + 1];
		Arrays.fill(dp, INF);
		dp[1] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int idx = cur.idx;
			long time = cur.time;
			if (dp[idx] < time)
				continue;
			for (Node node : rec[idx]) {
				if ((idx == from && node.idx == to) || (idx == to && node.idx == from))
					continue;
				if (dp[node.idx] > dp[idx] + node.time) {
					dp[node.idx] = dp[idx] + node.time;
					pq.add(new Node(node.idx, dp[idx] + node.time));
				}
			}
		}

		ans = Math.max(ans, dp[N]);
		trace(normal, to, parents[to]);

	}

	static class Node implements Comparable<Node> {
		int idx;
		long time;

		public Node(int idx, long time) {
			super();
			this.idx = idx;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return (int) (this.time - o.time);
		}
	}
}
