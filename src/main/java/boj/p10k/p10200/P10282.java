package boj.p10k.p10200;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P10282 {
	static int T, N;
	static List<Node>[] matrix;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.valueOf(in.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(in.readLine());
			N = Integer.valueOf(st.nextToken());
			int d = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			matrix = new ArrayList[N + 1];
			for (int i = 1; i < N + 1; i++) {
				matrix[i] = new ArrayList<>();
			}
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.valueOf(st.nextToken());
				int b = Integer.valueOf(st.nextToken());
				int s = Integer.valueOf(st.nextToken());
				matrix[b].add(new Node(a, s));

			}

			dijkstra(c);
		}
		System.out.println(sb.toString());

	}

	public static void dijkstra(int c) {

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(c, 0));
		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[c] = 0;

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int idx = node.to;
			int weight = node.weight;

			if (dp[idx] < weight)
				continue;

			for (int j = 0; j < matrix[idx].size(); j++) {
				int cost = matrix[idx].get(j).weight + dp[idx];
				if (dp[matrix[idx].get(j).to] > cost) {
					dp[matrix[idx].get(j).to] = cost;

					pq.add(new Node(matrix[idx].get(j).to, cost));
				}
			}
		}
		int infectedCnt = 0;
		int lastest = 0;
		for (int i = 0; i < N + 1; i++) {
			if (dp[i] != Integer.MAX_VALUE) {
				infectedCnt++;
				lastest = Math.max(lastest, dp[i]);
			}
		}
		sb.append(infectedCnt + " " + lastest + "\n");
	}

	static class Node implements Comparable<Node> {
		int to, weight;

		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		public int compareTo(Node object) {
			return this.weight - object.weight;
		}
	}

}
