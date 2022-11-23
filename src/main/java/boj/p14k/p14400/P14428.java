package boj.p14k.p14400;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class P14428 {

	static int N, M;
	static int[] arr, tree;

	private static void init(int start, int end, int node) {
		if (start == end) {
			tree[node] = start;
			return;
		}

		int mid = (start + end) / 2;
		init(start, mid, node * 2);
		init(mid + 1, end, node * 2 + 1);

		if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
			tree[node] = tree[node * 2];
		} else {
			tree[node] = tree[node * 2 + 1];
		}
	}

	private static void update(int start, int end, int node, int idx, int val) {
		if (idx < start || idx > end) {
			return;
		}

		if (start == end) {
			tree[node] = idx;
			arr[idx] = val;
			return;
		}

		int mid = (start + end) / 2;

		update(start, mid, node * 2, idx, val);
		update(mid + 1, end, node * 2 + 1, idx, val);

		if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
			tree[node] = tree[node * 2];
		} else {
			tree[node] = tree[node * 2 + 1];
		}

	}

	private static int getMinIdx(int start, int end, int node, int left, int right) {

		if (right < start || left > end) {
			return -1;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = (start + end) / 2;
		int v1 = getMinIdx(start, mid, node * 2, left, right);
		int v2 = getMinIdx(mid + 1, end, node * 2 + 1, left, right);
		if (v1 == -1) {
			return v2;
		} else if (v2 == -1) {
			return v1;
		} else {
			if (arr[v1] <= arr[v2]) {
				return v1;
			} else {
				return v2;
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(in.readLine());
		arr = new int[N + 1];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		tree = new int[N * 4];
		init(1, N, 1);
		M = Integer.valueOf(in.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				update(1, N, 1, b, c);
			} else {
				int res = getMinIdx(1, N, 1, b, c);
				sb.append(res + "\n");
			}
		}
		System.out.println(sb.toString());
	}

}
