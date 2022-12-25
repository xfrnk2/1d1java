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
	static int[][] record;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(in.readLine());
		nodes = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		record = new int[N + 1][2];

		for (int j = 0; j <= N; j++) {
			nodes[j] = new ArrayList<Integer>();
		}

		StringTokenizer st;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			nodes[from].add(to);
			nodes[to].add(from);

		}

		dfs(1);
		System.out.println(Math.min(record[1][0], record[1][1]));

	}

	public static void dfs(int cur) {

		visit[cur] = true;
		record[cur][0] = 0; // not ealry adaptor
		record[cur][1] = 1;

		for (Integer next : nodes[cur]) {
			if (visit[next])
				continue;
			dfs(next);
			record[cur][0] += record[next][1];
			record[cur][1] += Math.min(record[next][0], record[next][1]);
		}

	}

}
