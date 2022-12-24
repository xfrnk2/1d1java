package boj.p2k.p2500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2533 {
	static int N, ans = 0;
	static ArrayList<Integer>[] nodes;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(in.readLine());
		nodes = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		for (int j = 0; j <= N; j++) {
			nodes[j] = new ArrayList<Integer>();
		}

		StringTokenizer st;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			nodes[from].add(to);

		}

		visit[1] = true;
		dfs(1);
		System.out.println(ans);

	}

	public static void dfs(int cur) {
		if (nodes[cur].size() > 0) {

			for (Integer next : nodes[cur]) {
				if (visit[next])
					continue;
				visit[next] = true;
				if (nodes[next].size() != 0) {
					ans++;
				}
				dfs(next);
			}
		}

	}

}
