package boj.p2k.p2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2042 {

	static long[] arr, tree; // 입력값 배열과, 구간합 트리
	static int N, M, K;
	/*
	 * a가 1이면 해당 위치를 바꾼다. b번째 수를 c로 a가 2이면 b에서 c까지 구간합을 구한다.
	 */

	private static long init(int start, int end, int node) {
		if (start == end)
			return tree[node] = arr[start];
		int mid = (start + end) / 2;
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	};

	private static long sum(int start, int end, int node, int left, int right) {
		// 범위 밖인 경우
		if (left > end || right < start)
			return 0;
		// 범위 안인 경우
		if (left <= start && end <= right)
			return tree[node];

		// 아니라면 두 부분으로 나누어 합을 구한다.
		int mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}

	private static void update(int start, int end, int node, int idx, long dif) {
		// 범위 밖인 경우
		if (idx < start || idx > end)
			return;
		// 범위 안인 경우 아래로 내려가며 갱신
		tree[node] += dif;
		if (start == end)
			return;
		int mid = (start + end) / 2;
		update(start, mid, node * 2, idx, dif);
		update(mid + 1, end, node * 2 + 1, idx, dif);

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

		int size = N * 4;
		tree = new long[size];
		init(1, N, 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				long dif = c - arr[b];
				arr[b] = c;
				update(1, N, 1, b, dif);
			} else {
				out.write(sum(1, N, 1, b, (int) c) + "\n");
			}
		}
		out.flush();

	}

}
