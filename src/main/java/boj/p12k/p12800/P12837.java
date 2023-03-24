package boj.p12k.p12800;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12837 {

	static int N, Q;
	static long tree[];

	public static void update(int node, int start, int end, int idx, int val) {
		if (idx < start || idx > end)
			return;
		tree[node] += val;

		if (start != end) {
			int mid = (start + end) / 2;
			update(node * 2, start, mid, idx, val);
			update(node * 2 + 1, mid + 1, end, idx, val);

		}
	}

	public static long sum(int node, int start, int end, int left, int right) {
		if (right < start || left > end)
			return 0;
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.valueOf(st.nextToken());
		Q = Integer.valueOf(st.nextToken());
		tree = new long[N * 4];

		StringBuilder sb = new StringBuilder();
		while (Q-- > 0) {
			st = new StringTokenizer(in.readLine());
			int qn = Integer.valueOf(st.nextToken());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());

			if (qn == 1) {
				// 생후 p일에 x를 추가한다.
				update(1, 1, N, a, b);

			} else {
				// 생후 p부터 q일까지 변화한 양을 출력한다.
				if (b < a) {
					int temp = b;
					b = a;
					a = temp;
				}
				long res = sum(1, 1, N, a, b);
				sb.append(res + "\n");
			}

		}
		System.out.println(sb.toString());
	}

}
