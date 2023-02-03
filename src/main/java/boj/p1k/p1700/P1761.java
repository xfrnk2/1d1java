package boj.p1k.p1700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1761 {
	static int N, M, height;
	static int[] depths;
	static ArrayList<Node>[] tree;
	static int[] dis;
	static int[][] dp, parents;

	static class Node {
		int to, cost;

		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.valueOf(in.readLine());

		depths = new int[N + 1];
		tree = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			int d = Integer.valueOf(st.nextToken());

			tree[from].add(new Node(to, d));
			tree[to].add(new Node(from, d));
		}

		int temp = 1;
		height = 0;

		while (temp <= N) {
			temp <<= 1;
			height++;

		}

		dp = new int[N + 1][height];
		dis = new int[N + 1];

		parents = new int[N + 1][height];

		initDfs(1, 1, 0);
		parentsInit();
		M = Integer.valueOf(in.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());

			sb.append((dis[a] + dis[b] - 2 * dis[lca(a, b)]) + "\n");
			// https://loosie.tistory.com/422
		}
		System.out.println(sb.toString());
	}

	public static void parentsInit() {

		for (int i = 1; i < height; i++) {
			for (int j = 1; j <= N; j++) {
				dp[j][i] = dp[dp[j][i - 1]][i - 1];
			}
		}
	}

	public static void initDfs(int cur, int depth, int parent) {

		depths[cur] = depth;
		for (Node node : tree[cur]) {
			if (node.to != parent) {
				dis[node.to] = dis[cur] + node.cost;
				initDfs(node.to, depth + 1, cur);
				dp[node.to][0] = cur;
			}
		}

	}

	static int lca(int a, int b) {
		int aD = depths[a];
		int bD = depths[b];

		if (aD < bD) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		for (int i = height - 1; i >= 0; i--) {
			if (Math.pow(2, i) <= depths[a] - depths[b]) {
				a = dp[a][i];
			}
		}

		if (a == b)
			return a;

		for (int i = height - 1; i >= 0; i--) {
			if (dp[a][i] != dp[b][i]) {
				a = dp[a][i];
				b = dp[b][i];
			}
		}
		return dp[a][0];
	}

}
