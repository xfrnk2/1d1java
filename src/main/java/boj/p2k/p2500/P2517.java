package boj.p2k.p2500;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2517 {

	static int N;
	static int[] tree, ans;
	static Point[] players;

	public static void update(int node, int start, int end, int idx) {
		if (end < idx || idx < start)
			return;
		if (start == end) {
			tree[node] += 1;
			return;
		}

		int mid = (start + end) / 2;
		update(node * 2, start, mid, idx);
		update(node * 2 + 1, mid + 1, end, idx);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];

	}

	public static int sum(int node, int start, int end, int left, int right) {
		if (right < start || end < left)
			return 0;
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(in.readLine());
		tree = new int[n * 4];
		players = new Point[n + 1];
		ans = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int cur = Integer.valueOf(in.readLine());
			players[i] = new Point(i, cur);
		}
		players[0] = new Point(0, 0);
		Arrays.sort(players, (a, b) -> b.y - a.y);
		// System.out.println(Arrays.toString(players));

		for (int j = 0; j < n; j++) {

			update(1, 1, n, players[j].x);
			int res = sum(1, 1, n, 1, players[j].x);
			ans[players[j].x] = res;

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(ans[i] + "\n");
		}

		System.out.println(sb.toString());

	}

}
