package boj.p1k.p1500;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1517 {

	static int N;
	static Point[] arr;// (idx, value)
	static int[] tree;

	public static int cntLess(int start, int end, int node, int left, int right) {
		if (left > end || start > right)
			return 0;
		if (left <= start && end <= right)
			return tree[node];
		int mid = (start + end) / 2;
		int lc = cntLess(start, mid, node * 2, left, right);
		int rc = cntLess(mid + 1, end, node * 2 + 1, left, right);
		return lc + rc;
	}

	public static void update(int start, int end, int node, int idx) {
		if (start == end) {
			tree[node] = 1;
			return;
		}

		int mid = (start + end) / 2;
		if (idx <= mid) {
			update(start, mid, node * 2, idx);
		} else {
			update(mid + 1, end, node * 2 + 1, idx);
		}
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new Point[N + 1];
		StringTokenizer st = new StringTokenizer(in.readLine());

		arr[0] = new Point(0, -1);
		for (int i = 1; i < N + 1; i++) {
			arr[i] = new Point(i, Integer.parseInt(st.nextToken()));
		}

		tree = new int[N * 4];
		Arrays.sort(arr, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return o1.y - o2.y;
			}

		});

		long answer = 0;
		for (int i = 1; i < N + 1; i++) {
			answer += (long) cntLess(1, N, 1, arr[i].x + 1, N);
			update(1, N, 1, arr[i].x);
		}
		System.out.println(answer);

	}

}
