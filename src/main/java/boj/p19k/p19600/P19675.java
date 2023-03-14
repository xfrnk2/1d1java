package boj.p19k.p19600;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P19675 {

	static int N, M;
	static int[] arr;
	static long[] tree;

	private static void init(int start, int end, int node) {
		if (start == end) {
			tree[node] = arr[start];
			return;
		}
		tree[node] = 0;
		int mid = (start + end) / 2;
		init(start, mid, node * 2);
		init(mid + 1, end, node * 2 + 1);
	}

	private static void update(int node, int start, int end, int left, int right, long val) {

		if (right < start || left > end)
			return;
		if (left <= start && end <= right) {
			tree[node] += val;
			return;
		}

		int mid = (start + end) / 2;
		update(node * 2, start, mid, left, right, val);
		update(node * 2 + 1, mid + 1, end, left, right, val);
	}

	private static long getX(int node, int start, int end, int idx, long res) {

		if (idx < start || end < idx)
			return 0;
		res += tree[node];
		if (start == end) {
			return res;
		}
		int mid = (start + end) / 2;
		long ls = getX(node * 2, start, mid, idx, res);
		long rs = getX(node * 2 + 1, mid + 1, end, idx, res);
		return ls + rs;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());

		arr = new int[N + 1];
		tree = new long[N * 4];

		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		init(1, N, 1);

		M = Integer.parseInt(in.readLine());
		for (int z = 0; z < M; z++) {
			st = new StringTokenizer(in.readLine());
			int qn = Integer.parseInt(st.nextToken());

			/*
			 * 1 i j k: Ai, Ai+1, ..., Aj에 k를 더한다. 2 x: Ax 를 출력한다.
			 */
			if (qn == 1) {
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				update(1, 1, N, i, j, k);
			} else {
				int x = Integer.parseInt(st.nextToken());
				out.write(getX(1, 1, N, x, 0) + "\n");

			}

		}
		out.flush();

	}

}
