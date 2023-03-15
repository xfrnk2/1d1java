package boj.p6k.p6500;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class P6549 {

	static int n;
	static int[] arr;
	static int[] tree;

	public static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = start;
			return;
		}

		int mid = (start + end) / 2;
		init(node * 2, start, mid);
		init(node * 2 + 1, mid + 1, end);
		if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
			tree[node] = tree[node * 2];

		} else {

			tree[node] = tree[node * 2 + 1];
		}

	}

	public static int getMin(int node, int start, int end, int left, int right) {
		if (right < start || left > end) {
			return -1;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		int lc = getMin(node * 2, start, mid, left, right);
		int rc = getMin(node * 2 + 1, mid + 1, end, left, right);

		if (lc == -1)
			return rc;
		else if (rc == -1)
			return lc;
		else
			return arr[lc] <= arr[rc] ? lc : rc;

	}

	public static long getMax(int start, int end) {

		int idx = getMin(1, 1, n, start, end);
		long m = ((long) (end - start + 1) * (long) arr[idx]);

		if (start < idx) {
			long tmp = getMax(start, idx - 1);
			if (m < tmp)
				m = tmp;

		}
		if (idx < end) {
			long tmp = getMax(idx + 1, end);
			if (m < tmp)
				m = tmp;

		}

		return m;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {

			st = new StringTokenizer(in.readLine());

			n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;

			arr = new int[n + 1];
			tree = new int[n * 4];

			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			init(1, 1, n);

			sb.append(getMax(1, n) + "\n");

		}
		System.out.println(sb.toString());

	}

}
