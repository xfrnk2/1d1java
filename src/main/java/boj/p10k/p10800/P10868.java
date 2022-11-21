package boj.p10k.p10800;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P10868 {

	static int N, M;
	static int[] arr, tree;

	private static int init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start + end) / 2;
		return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
	}

	private static int find(int start, int end, int left, int right, int node) {
		if (right < start || left > end) {
			return Integer.MAX_VALUE;
		}
		if (start >= left && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		return Math.min(find(start, mid, left, right, node * 2), find(mid + 1, end, left, right, node * 2 + 1));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		arr = new int[N + 1];
		tree = new int[N * 4];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}

		init(1, N, 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			out.write(find(1, N, a, b, 1) + "\n");
		}
		out.flush();
	}

}
