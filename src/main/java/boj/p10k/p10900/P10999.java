package boj.p10k.p10900;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P10999 {

	static int N, M, K;
	static long[] arr, tree, lazy;

	public static void init(int start, int end, int node) {
		if (start == end) {
			tree[node] = arr[start];
			return;
		}

		int mid = (start + end) / 2;
		init(start, mid, node * 2);
		init(mid + 1, end, node * 2 + 1);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	public static void update_lazy(int node, int start, int end) {
		if (lazy[node] != 0) {

			tree[node] += (end - start + 1) * lazy[node];
			if (start != end) {
				lazy[node * 2] += lazy[node];
				lazy[node * 2 + 1] += lazy[node];
			}
			lazy[node] = 0;
		}
	}

	public static void update(int node, int start, int end, int left, int right, long val) {
		update_lazy(node, start, end);
		if (start > right || end < left)
			return;
		if (left <= start && end <= right) {
			tree[node] += ((long) end - start + 1) * val;
			if (start != end) {
				lazy[node * 2] += val;
				lazy[node * 2 + 1] += val;
			}

			return;
		}

		int mid = (start + end) / 2;
		update(node * 2, start, mid, left, right, val);
		update(node * 2 + 1, mid + 1, end, left, right, val);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	public static long sum(int node, int start, int end, int left, int right) {
		update_lazy(node, start, end);

		if (right < start || left > end)
			return 0;
		if (left <= start && end <= right)
			return tree[node];
		int mid = (start + end) / 2;
		return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new long[N + 1];
		tree = new long[N * 4];
		lazy = new long[N * 4];

		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(in.readLine());
		}

		init(1, N, 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(in.readLine());

			int qn = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (qn == 1) {
				// qn이 1인 경우 b번째 수부터 c번째 수에 d를 더하고,

				long d = Long.parseLong(st.nextToken());
				update(1, 1, N, b, c, d);

			} else {
				// qn이 2인 경우에는 b번째 수부터 c번째 수의 합을 구하여 출력하면 된다.

				out.write(sum(1, 1, N, b, c) + "\n");
			}
		}
		out.flush();
	}

}
