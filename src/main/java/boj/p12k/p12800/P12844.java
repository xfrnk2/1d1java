package boj.p12k.p12800;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12844 {

	static int N, M;
	static long[] lazy, tree;

	public static void init(int node, int start, int end, long idx, long value) {
		if (idx < start || end < idx)
			return;
		tree[node] ^= value;
		if (start == end) {
			return;
		}

		int mid = (start + end) / 2;
		init(node * 2, start, mid, idx, value);
		init(node * 2 + 1, mid + 1, end, idx, value);
	}

	public static void update_lazy(int node, int start, int end) {
		if (lazy[node] != 0) {

			if (start != end) {
				lazy[node * 2] ^= lazy[node];
				lazy[node * 2 + 1] ^= lazy[node];
			}
			tree[node] ^= ((end - start + 1) % 2) * lazy[node];
			lazy[node] = 0;
		}
	}

	public static void update(int node, int start, int end, int left, int right, int k) {
		update_lazy(node, start, end);
		if (right < start || end < left)
			return;
		if (left <= start && end <= right) {
			lazy[node] ^= k;
			update_lazy(node, start, end);
			return;
		}
		int mid = (start + end) / 2;
		update(node * 2, start, mid, left, right, k);
		update(node * 2 + 1, mid + 1, end, left, right, k);
		tree[node] = tree[node * 2] ^ tree[node * 2 + 1];

	}

	public static long sum(int node, int start, int end, int left, int right) {
		update_lazy(node, start, end);
		if (end < left || right < start)
			return 0;
		if (left <= start && end <= right)
			return tree[node];
		int mid = (start + end) / 2;
		return sum(node * 2, start, mid, left, right) ^ sum(node * 2 + 1, mid + 1, end, left, right);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		// arr = new int[N + 1];
		tree = new long[N * 4];
		lazy = new long[N * 4];

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());

		M = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			init(1, 0, N - 1, i, Integer.parseInt(st.nextToken()));
		}
		while (M-- > 0) {
			st = new StringTokenizer(in.readLine());
			int qn = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			switch (qn) {

			case 1:
				// 1 i j k: Ai, Ai+1, ..., Aj에 k를 xor한다.

				int k = Integer.parseInt(st.nextToken());
				update(1, 0, N - 1, i, j, k);

				break;
			case 2:
				// 2 i j: Ai, Ai+1, ..., Aj를 모두 xor한 다음 출력한다.
				long res = sum(1, 0, N - 1, i, j);
				sb.append(res + "\n");
				break;

			}

		}
		System.out.println(sb.toString());

	}

}
