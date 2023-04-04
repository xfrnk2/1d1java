package boj.p8k.p8000;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P8012 {

	static int N, maxLev;
	static ArrayList<Integer>[] adj;
	static int[] depth;
	static int[][] parent;
	
	public static int getMaxLev() {
		return (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
	}

	public static void initTree(int cur, int dep, int par) {
		depth[cur] = dep;
		for (Integer elem : adj[cur]) {
			if (elem != par) {
				parent[elem][0] = cur;
				initTree(elem, dep + 1, cur);
			}
		}
	}

	public static void initParent() {
		for (int i = 1; i < maxLev; i++) {
			for (int j = 1; j <= N; j++) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];
			}
		}
	}

	public static int lca(int a, int b) {
		if (depth[b] > depth[a]) {
			int temp = a;
			a = b;
			b = temp;
		}

		for (int i = maxLev - 1; i >= 0; i--) {
			if (Math.pow(2, i) <= depth[a] - depth[b]) {
				a = parent[a][i];

			}
		}

		if (a == b)
			return a;

		for (int i = maxLev - 1; i >= 0; i--) {
			if (parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		return parent[a][0];

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.valueOf(in.readLine());
//		maxLev = getMaxLev();
		maxLev = 15;

		adj = new ArrayList[N + 1];
		depth = new int[N + 1];
		parent = new int[N + 1][maxLev];

		for (int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}

		initTree(1, 1, 0);
		initParent();

		int m = Integer.valueOf(in.readLine());
		int root = 1, cur = 1, nxt = 0;
		int ans = 0;
		while (m-- > 0) {
			nxt = Integer.valueOf(in.readLine());
			ans += (depth[cur] + depth[nxt]) - 2 * depth[lca(cur, nxt)];
			cur = nxt;

		}
		System.out.println(ans);

	}

}
