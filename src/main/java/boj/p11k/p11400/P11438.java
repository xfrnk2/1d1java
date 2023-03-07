package boj.p11k.p11400;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11438 {

	static ArrayList<Integer>[] tree;
	static int N, K;
	static int[] depths;
	static int[][] parents;

	public static int getMaxDepth() {
		int ans = 0;
        int n = N;
		while (0 < n) {
			n >>= 1;
			ans += 1;
		}
		return ans;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(in.readLine());
		K = getMaxDepth();
		StringTokenizer st;

		tree = new ArrayList[N + 1];
		depths = new int[N + 1];
		parents = new int[N + 1][K];

		for (int i = 0; i < N + 1; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			tree[from].add(to);
			tree[to].add(from);

		}
		StringBuilder sb = new StringBuilder();
		initTree(1, 1);
		initParents();
		int M = Integer.valueOf(in.readLine());

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
		if (aD < bD) { // a를 더 깊은 것으로 한다.
			int temp = a;
			a = b;
			b = temp;
		}

		for (int i = K - 1; i >= 0; i--) {
			if (Math.pow(2, i) <= depths[a] - depths[b]) {
				a = parents[a][i];

			}
		}

		if (a == b)
			return a;

		for (int i = K - 1; i >= 0; i--) {
			if (parents[a][i] != parents[b][i]) {
				a = parents[a][i];
				b = parents[b][i];
			}
		}

		return parents[a][0];

	}

	public static void initTree(int cur, int depth) {
		depths[cur] = depth;
		for (Integer item : tree[cur]) {
			if (depths[item] == 0) {
				initTree(item, depth + 1);
				parents[item][0] = cur;
			}
		}
	}

	public static void initParents() {
        for (int i = 1; i < K; i++) { 
            for (int j = 1; j <= N; j++) {
                parents[j][i] = parents[ parents[j][i - 1] ][i - 1];
            }
        }
	}

}
