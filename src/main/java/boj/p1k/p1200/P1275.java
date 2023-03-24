package boj.p1k.p1200;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1275 {
	static int N, M;
	static long[] arr;
	static long[] tree;

	public static long init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];

		}

		int mid = (start + end) / 2;
		return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
//		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	public static long sum(int node, int start, int end, int left, int right) {

		if (right < start || end < left)
			return 0;
		if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = (start + end) / 2;
		return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
	}

	public static void update(int node, int start, int end, int idx, long val) {
		if (end < idx || idx < start) {
			return;
		}

		tree[node] += val;
		if (start != end) {
			int mid = (start + end) / 2;
			update(node * 2, start, mid, idx, val);
			update(node * 2 + 1, mid + 1, end, idx, val);
		}
		// tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());

		st = new StringTokenizer(in.readLine());
		arr = new long[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}

		tree = new long[N * 4 + 10];
		init(1, 1, N);
		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());

			if (y < x) {
				int t = y;
				y = x;
				x = t;
			}

			long sumRes = sum(1, 1, N, x, y);
			sb.append(sumRes + "\n");
			long diff = b - arr[a];
			arr[a] = b;

			update(1, 1, N, a, diff);

		}
		System.out.println(sb.toString());

	}

}
