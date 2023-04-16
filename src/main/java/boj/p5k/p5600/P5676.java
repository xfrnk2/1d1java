package boj.p5k.p5600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5676 {

	static int N, K;
	static int[] arr;
	static int[] tree;

	public static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		init(node * 2, start, mid);
		init(node * 2 + 1, mid + 1, end);
		tree[node] = tree[node * 2] * tree[node * 2 + 1];
	}

	public static int change(int node, int start, int end, int idx, int value) {
		if (idx < start || end < idx)
			return 1;
		if (start == end) {

			return tree[node] = value;
		}
		int mid = (start + end) / 2;
		return tree[node] = change(node * 2, start, mid, idx, value) * change(node * 2 + 1, mid + 1, end, idx, value);
	}

	public static int mul(int node, int start, int end, int left, int right) {
		if (right < start || end < left)
			return 1;
		if (left <= start && end <= right)
			return tree[node];
		int mid = (start + end) / 2;
		return mul(node * 2, start, mid, left, right) * mul(node * 2 + 1, mid + 1, end, left, right);
	}

	public static void main(String[] args) throws IOException {

		String input = "";

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while ((input = in.readLine()) != null) {
			st = new StringTokenizer(input);
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N + 1];
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= N; i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i] = num == 0 ? 0 : num < 0 ? -1 : 1;

			}
			tree = new int[N * 4];
			init(1, 1, N);

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				String s = st.nextToken();

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (s.equals("C")) {
					b = b == 0 ? 0 : b < 0 ? -1 : 1;
					arr[a] = b;
					change(1, 1, N, a, b);
				} else if (s.equals("P")) {
					int res = mul(1, 1, N, a, b);
					sb.append(res == 0 ? "0" : res == 1 ? "+" : "-");

				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

}
