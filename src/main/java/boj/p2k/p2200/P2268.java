package boj.p2k.p2200;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2268 {
	static int N, K;
	static long[] arr, tree;

//	
//	private static long init(int start, int end, int node) {
//		if (start == end) {
//			return tree[node] = start;
//		}
//		int mid = (start + end) / 2;
//		return tree[node] = init(start, mid, node * 2) + init(mid+1, end, node * 2 + 1);
//	}

	private static long sum(int start, int end, int node, int left, int right) {
		// 범위 밖인 경우
		if (left > end || right < start)
			return 0;
		// 범위 안인 경우
		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}

	private static long modify(int start, int end, int node, int idx, int val) {
		if (idx < start || idx > end)
			return tree[node];

		if (start == end) {
			return tree[node] = val;
		}
		int mid = (start + end) / 2;

		return tree[node] = modify(start, mid, node * 2, idx, val) + modify(mid + 1, end, node * 2 + 1, idx, val);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());

		tree = new long[N * 4];
//		for (int i = 1; i <= N; i++) {
//			tree[i] = i;
//		}

		// init(1, N, 1);
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());

			if (a == 1) { // modify

				modify(1, N, 1, b, c);
			} else { // sum

				if (b > c) {
					int temp = b;
					b = c;
					c = temp;

				}
				out.write(sum(1, N, 1, b, c) + "\n");

			}
		}
		out.flush();
	}

}
