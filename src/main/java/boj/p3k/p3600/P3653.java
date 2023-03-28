package boj.p3k.p3600;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3653 {

	static int N, M;
	static int[] idxArr, tree;

	public static void init(int node, int start, int end) {

		if (start == end) {
			if (start <= M)
				return;
			tree[node] = 1;
			return;
		}
		int mid = (start + end) / 2;
		init(node * 2, start, mid);
		init(node * 2 + 1, mid + 1, end);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	public static void update(int node, int start, int end, int idx, int val) {
		if (end < idx || idx < start)
			return;
		tree[node] += val;
		if (start != end) {
			int mid = (start + end) / 2;
			update(node * 2, start, mid, idx, val);
			update(node * 2 + 1, mid + 1, end, idx, val);
		}
	}

	public static int sum(int node, int start, int end, int left, int right) {
		if (right < start || end < left)
			return 0;
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		int l = sum(node * 2, start, mid, left, right);
		int r = sum(node * 2 + 1, mid + 1, end, left, right);
		return l + r;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;// = new StringTokenizer(in.readLie());
		int t = Integer.valueOf(in.readLine());
		while (t-- > 0) {

			st = new StringTokenizer(in.readLine());
			N = Integer.valueOf(st.nextToken());
			M = Integer.valueOf(st.nextToken());
			idxArr = new int[N + 1];
			for (int i = 1; i < N + 1; i++) {
				idxArr[i] = i + M;
			}

			tree = new int[(N + M) * 4];
			init(1, 1, N + M);
			int idx = M;
//			System.out.println(Arrays.toString(tree));
//			System.out.println(Arrays.toString(idxArr));
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				int cur = Integer.valueOf(st.nextToken());
				int res = sum(1, 1, N + M, 1, idxArr[cur] - 1);
				out.write(res + " ");
				update(1, 1, N + M, idxArr[cur], -1);
				idxArr[cur] = idx;
				update(1, 1, N + M, idx--, 1);

			}
			out.write("\n");
		}
		out.flush();
	}

}
