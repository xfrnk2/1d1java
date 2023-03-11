package boj.p14k.p14400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14427 {

	static int N, M;
	static int[] arr, tree;
	static StringBuilder sb = new StringBuilder();

	public static int init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = start;
		}
		int mid = (start + end) / 2;
		int a = init(start, mid, node * 2);
		int b = init(mid + 1, end, node * 2 + 1);

		if (arr[a] == arr[b]) {
			return tree[node] = a < b ? a : b;
		} else if (arr[a] < arr[b]) {
			return tree[node] = a;
		} else {
			return tree[node] = b;
		}

	}

	public static int update(int start, int end, int node, int idx) {

		if (idx < start || end < idx)
			return tree[node];
		if (start == end) {

			return tree[node] = idx;

		}

		int mid = (start + end) / 2;
		int a = update(start, mid, node * 2, idx);
		int b = update(mid + 1, end, node * 2 + 1, idx);

		if (arr[a] == arr[b]) {
			return tree[node] = a < b ? a : b;
		}

		else if (arr[a] < arr[b]) {
			return tree[node] = a;
		} else {
			return tree[node] = b;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(in.readLine());
		arr = new int[N + 1];
		tree = new int[N * 4];
		arr[0] = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}

		init(1, N, 1);

		M = Integer.valueOf(in.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int qn = Integer.valueOf(st.nextToken());
			if (qn == 2) {
				sb.append(tree[1] + "\n");
			} else {
				int a = Integer.valueOf(st.nextToken());
				int b = Integer.valueOf(st.nextToken());
				arr[a] = b;
				update(1, N, 1, a);
			}

		}
		System.out.println(sb.toString());

	}

}
