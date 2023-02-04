package boj.p11k.p11400;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11437 {
	static int N, M;
	static ArrayList<Integer>[] tree;
	static int[] depths, parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.valueOf(in.readLine());
		tree = new ArrayList[N + 1];
		depths = new int[N + 1];
		parents = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			tree[from].add(to);
			tree[to].add(from);
		}

		M = Integer.valueOf(in.readLine());
		StringBuilder sb = new StringBuilder();
		initDfs(1, 1, 0);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			sb.append(lca(a, b) + "\n");
		}

		System.out.println(sb.toString());

	}

	public static int lca(int a, int b) {
		int aD = depths[a];
		int bD = depths[b];

		while (aD > bD) {
			a = parents[a];
			aD--;
		}

		while (aD < bD) {
			b = parents[b];
			bD--;
		}

		while (a != b) {
			a = parents[a];
			b = parents[b];
		}

		return a;

	}

	public static void initDfs(int cur, int depth, int parent) {
		parents[cur] = parent;
		depths[cur] = depth;
		for (Integer item : tree[cur]) {
			if (item != parent) {
				initDfs(item, depth + 1, cur);
			}
		}
	}

}
