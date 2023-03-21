package boj.p9k.p9400;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P9463 {

	static int N;
	static int[] aArr, bArr;
	static long[] tree;

	public static long sum(int node, int start, int end, int left, int right) {

		if (end < left || right < start)
			return 0;
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
	}

	public static void update(int node, int start, int end, int idx) {
		if (end < idx || idx < start)
			return;
		if (start == end) {
			tree[node] = 1;
			return;
		}
		int mid = (start + end) / 2;
		update(node * 2, start, mid, idx);
		update(node * 2 + 1, mid + 1, end, idx);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.valueOf(in.readLine());

		while (t-- > 0) {
			N = Integer.valueOf(in.readLine());
			aArr = new int[N + 1];
			bArr = new int[100001];
			tree = new long[N * 4];

			st = new StringTokenizer(in.readLine());

			for (int i = 1; i <= N; i++) {
				aArr[i] = Integer.valueOf(st.nextToken());
			}

			st = new StringTokenizer(in.readLine());

			for (int i = 1; i <= N; i++) {
				int input = Integer.valueOf(st.nextToken());
				bArr[input] = i;
			}

			long ans = 0;
			for (int i = 1; i <= N; i++) {
				ans += sum(1, 1, N, bArr[aArr[i]] + 1, N);
				update(1, 1, N, bArr[aArr[i]]);
			}
			out.write(ans + "\n");

		}
		out.flush();

	}

}
