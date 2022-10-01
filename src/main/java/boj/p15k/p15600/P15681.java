package boj.p15k.p15600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15681 {
	static int N, R, Q, V;
	static ArrayList<Integer>[] nodes;
	static int[] queries;
	static int[] dp;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		V = N - 1;
		nodes = new ArrayList[N + 1];

		dp = new int[N + 1];
		visit = new boolean[N + 1];
		Arrays.fill(dp, 1);

		for (int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<Integer>(2);
		}

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			nodes[from].add(to);
			nodes[to].add(from);
		}

		visit[R] = true;
		dfs(R);

		for (int i = 0; i < Q; i++) {
			System.out.println(dp[Integer.parseInt(in.readLine())]);

		}

	}

	public static int dfs(int cur) {
		for (Integer next : nodes[cur]) {
			if (visit[next])
				continue;
			visit[next] = true;
			dp[cur] += dfs(next);
		}
		return dp[cur];
	}

}
