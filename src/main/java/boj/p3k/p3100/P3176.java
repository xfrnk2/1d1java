package boj.p3k.p3100;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3176 {

	static int N, K, maxLev;
	static ArrayList<Node>[] adj;
	static int[] depths;
	static int[][] parents, minA, maxA;

	static class Node {
		int to, cost;

		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

	}

	public static int getMaxLev() {
		return (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
	}

	public static void initTree(int cur, int depth, int pa) {
		depths[cur] = depth;
		for (Node item : adj[cur]) {
			if (item.to != pa) {
				initTree(item.to, depth + 1, cur);
				minA[item.to][0] = item.cost;
				maxA[item.to][0] = item.cost;
				parents[item.to][0] = cur;
			}
		}
	}

	public static void initParents() {
		for (int i = 1; i < maxLev; i++) {
			for (int j = 1; j <= N; j++) {
				parents[j][i] = parents[parents[j][i - 1]][i - 1];
				minA[j][i] = Math.min(minA[j][i - 1], minA[parents[j][i - 1]][i - 1]);
				maxA[j][i] = Math.max(maxA[j][i - 1], maxA[parents[j][i - 1]][i - 1]);
			}
		}
	}

	public static void printParents() {

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < maxLev; j++) {
				System.out.println("i, j: " + i + " " + j + ", p:" + parents[i][j]);

			}
		}
	}

	public static int[] lca(int a, int b) {
		if (depths[a] < depths[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		int minV = Integer.MAX_VALUE;
		int maxV = Integer.MIN_VALUE;
		for (int i = maxLev - 1; i >= 0; i--) {
			if (Math.pow(2, i) <= depths[a] - depths[b]) {
				minV = Math.min(minA[a][i], minV);
				maxV = Math.max(maxA[a][i], maxV);
				a = parents[a][i];
			}
		}

		if (a == b) {
			return new int[] { minV, maxV };
		}

		for (int i = maxLev - 1; i >= 0; i--) {
			if (parents[a][i] != parents[b][i]) {
				minV = Math.min(minV, Math.min(minA[a][i], minA[b][i]));
				maxV = Math.max(maxV, Math.max(maxA[a][i], maxA[b][i]));
				a = parents[a][i];
				b = parents[b][i];
			}
		}
		minV = Math.min(minV, Math.min(minA[a][0], minA[b][0]));
		maxV = Math.max(maxV, Math.max(maxA[a][0], maxA[b][0]));
//		System.out.println("---");
		return new int[] { minV, maxV };

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.valueOf(in.readLine());
		adj = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}
		maxLev = getMaxLev();
		depths = new int[N + 1];
		parents = new int[N + 1][maxLev];
		minA = new int[N + 1][maxLev];
		maxA = new int[N + 1][maxLev];
		boolean[] root = new boolean[N + 1];
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine());

			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			adj[a].add(new Node(b, c));
			adj[b].add(new Node(a, c));
			root[b] = true;

		}

		int rIdx = 0;
		for (int i = 1; i < N + 1; i++) {
			if (!root[i]) {
				rIdx = i;
				break;
			}
		}

		initTree(rIdx, 1, 0);
		initParents();

		// printParents();
		StringBuilder sb = new StringBuilder();
		K = Integer.valueOf(in.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());

			int d = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			int[] res = lca(d, e);
			sb.append(res[0] + " " + res[1] + "\n");
		}
		System.out.println(sb.toString());

	}

}
