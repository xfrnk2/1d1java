package boj.p2k.p2300;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2357 {
	static int N, M;
	static int[] arr;
	static int[][] tree;

	private static int maxInit(int start, int end, int node) {
		if (start == end) {
			return tree[node][1] = arr[start];

		}
		int mid = (start + end) / 2;
		return tree[node][1] = Math.max(maxInit(start, mid, node * 2), maxInit(mid + 1, end, node * 2 + 1));
	}

	private static int minInit(int start, int end, int node) {
		if (start == end) {
			return tree[node][0] = arr[start];

		}
		int mid = (start + end) / 2;
		return tree[node][0] = Math.min(minInit(start, mid, node * 2), minInit(mid + 1, end, node * 2 + 1));
	}

	private static int getMin(int start, int end, int node, int left, int right) {
		if (right < start || left > end) {
			return Integer.MAX_VALUE;
		}
		if (left <= start && end <= right) {
			return tree[node][0];
		}
		int mid = (start + end) / 2;
		return Math.min(getMin(start, mid, node * 2, left, right), getMin(mid + 1, end, node * 2 + 1, left, right));
	}

	private static int getMax(int start, int end, int node, int left, int right) {
		if (right < start || left > end) {
			return Integer.MIN_VALUE;
		}
		if (left <= start && end <= right) {
			return tree[node][1];
		}
		int mid = (start + end) / 2;
		return Math.max(getMax(start, mid, node * 2, left, right), getMax(mid + 1, end, node * 2 + 1, left, right));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		tree = new int[N * 4][2]; // 0인덱스가 최소, 1인덱스가 최대

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}

		minInit(1, N, 1);
		maxInit(1, N, 1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			out.write(getMin(1, N, 1, a, b) + " " + getMax(1, N, 1, a, b) + "\n");
		}
		out.flush();

	}

}
