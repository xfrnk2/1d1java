package boj.p7k.p7500;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P7578 {

	static int N;
	static int[] aArr, bArr;
	static long[] tree;

	private static long sum(int node, int start, int end, int left, int right) {
		if (end < left || start > right)
			return 0;

		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;

		return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
	}

	private static void update(int node, int start, int end, int idx) {
		if (start > idx || idx > end)
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
		N = Integer.parseInt(in.readLine());
		aArr = new int[1000001];
		bArr = new int[1000001];

		tree = new long[N * 4];

		StringTokenizer st = new StringTokenizer(in.readLine());

		for (int i = 1; i <= N; i++) {
			aArr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(in.readLine());

		for (int i = 1; i <= N; i++) {
			bArr[Integer.parseInt(st.nextToken())] = i;
		}

		long ans = 0;

		for (int i = 1; i <= N; i++) {
			ans += sum(1, 1, N, bArr[aArr[i]] + 1, N);
			update(1, 1, N, bArr[aArr[i]]);
		}
		System.out.println(ans);

	}

}
