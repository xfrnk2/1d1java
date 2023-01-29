package boj.p5k.p5700;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class P5719 {

	static int N, M, S, D;
	static List<Node>[] graph;
	static List<Integer>[] trackList;
	static Set<Point> path;
	static int[] dp, parent;

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
			return String.format("Node [to=%s, cost=%s]", to, cost);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		boolean isContinue = true;
		while (isContinue) {
			st = new StringTokenizer(in.readLine());
			N = Integer.valueOf(st.nextToken());
			M = Integer.valueOf(st.nextToken());

			if (N == 0 && M == 0)
				return;

			dp = new int[N];
			graph = new ArrayList[N];
			trackList = new ArrayList[N];
			path = new HashSet<>();

			for (int i = 0; i < N; i++) {
				graph[i] = new ArrayList<>();
				trackList[i] = new ArrayList<>();
			}

			st = new StringTokenizer(in.readLine());
			S = Integer.valueOf(st.nextToken());
			D = Integer.valueOf(st.nextToken());

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				int from = Integer.valueOf(st.nextToken());
				int to = Integer.valueOf(st.nextToken());
				int cost = Integer.valueOf(st.nextToken());

				graph[from].add(new Node(to, cost));
			}

			dijkstra();
			pathInit(D); // D에서 Top-Down으로 tracing하여 최적의 경로를 추적한다.
			secondDijkstra();

			System.out.println(dp[D] == Integer.MAX_VALUE ? -1 : dp[D]);
		}

	}

	public static void dpInit() {
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[S] = 0;
	}

	public static void dijkstra() {

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(S, 0));

		dpInit();

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (dp[cur.to] < cur.cost)
				continue;

			for (Node node : graph[cur.to]) {

				int nextCost = dp[cur.to] + node.cost;
				if (dp[node.to] == nextCost) {

					trackList[node.to].add(cur.to);
					continue;
				}

				if (dp[node.to] > nextCost) {
					dp[node.to] = nextCost;
					trackList[node.to].clear();
					trackList[node.to].add(cur.to);
					pq.add(new Node(node.to, nextCost));
				}

			}
		}

	}

	public static void pathInit(int now) {
		for (Integer elem : trackList[now]) {
			if (path.contains(new Point(elem, now)))
				continue;

			path.add(new Point(elem, now));
			if (elem != S) {
				pathInit(elem);
			}
		}
	}

	public static void secondDijkstra() {

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(S, 0));

		dpInit();

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (dp[cur.to] < cur.cost)
				continue;
			for (Node node : graph[cur.to]) {

				if (path.contains(new Point(cur.to, node.to))) { // 방문한 최단경로를 제외해야 거의 최단경로를 찾을 수 있다.
					continue;
				}
				if (dp[node.to] > dp[cur.to] + node.cost) {
					dp[node.to] = dp[cur.to] + node.cost;
					pq.add(new Node(node.to, dp[cur.to] + node.cost));
				}
			}
		}

	}
}
