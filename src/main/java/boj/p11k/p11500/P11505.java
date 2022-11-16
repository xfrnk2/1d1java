package boj.p11k.p11500;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11505 {

	static long[] arr, tree; // 입력값 배열과, 구간합 트리
	static int N, M, K;
	static int MOD = 1000000007;
	/*
	 * a가 1이면 해당 위치를 바꾼다. b번째 수를 c로 a가 2이면 b에서 c까지 구간합을 구한다.
	 */

	private static long init(int start, int end, int node) {
		if (start == end)
			return tree[node] = arr[start];
		int mid = (start + end) / 2;
		return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % MOD;
	};

	private static long mul(int start, int end, int node, int left, int right) {
		// 범위 밖인 경우
		if (left > end || right < start)
			return 1;
		// 범위 안인 경우
		if (left <= start && end <= right)
			return tree[node];

		// 아니라면 두 부분으로 나누어 합을 구한다.
		int mid = (start + end) / 2;
		return (mul(start, mid, node * 2, left, right) * mul(mid + 1, end, node * 2 + 1, left, right)) % MOD;
	}

	private static long update(int start, int end, int node, int idx, long val) {

		if (idx < start || end < idx)
			return tree[node];
		if (start == end)
			return tree[node] = val;
		int mid = (start + end) / 2;
		return tree[node] = (update(start, mid, node * 2, idx, val) * update(mid + 1, end, node * 2 + 1, idx, val))
				% MOD;
	}

	private static int getSize() {
		int k = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
		return (int) Math.pow(2, k);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		arr = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(in.readLine());
		}

		int size = getSize();
		tree = new long[size];
		init(1, N, 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				arr[b] = c;

				// init(1, N, 1);
				update(1, N, 1, b, c);
			} else {
				out.write(mul(1, N, 1, b, (int) c) + "\n");
			}
		}
		out.flush();

	}

}
