package boj.p14k.p14400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14438 {
	static int N, M;
	static int[] arr, tree;
	
	
	
	private static int init (int start, int end, int node) {
		if (start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start + end) / 2;
		return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end , node * 2 + 1));
	}
	
	private static int getMin(int start, int end, int node, int left, int right) {
		if (right < start || left > end) {
			return Integer.MAX_VALUE;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end ) /2;
		return Math.min(getMin(start, mid, node * 2, left, right), 
				getMin(mid + 1, end, node * 2 + 1, left, right));
	}
	
	private static int update(int start, int end, int node, int idx, int val) {
		if (idx < start || idx > end) {
			return tree[node];
		}
		
		if (start == end) {
			return tree[node] = val;
		}
		
		int mid = (start + end ) /2;
		return tree[node] = Math.min(update(start, mid, node * 2, idx, val), update(mid + 1, end, node * 2 + 1, idx, val)); 
	} 
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N+1];
		tree = new int[N * 4];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		init(1, N, 1);
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(in.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 1) { //update
				update(1, N, 1, b, c);
			} else if (a == 2) { // getMin
				sb.append(getMin(1, N, 1, b, c) + "\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	

}
