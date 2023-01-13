package boj.p2k.p2600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2610 {
	static int N, M;
	static int[] parent;
	static int[][] matrix;

	public static void make() {

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			Arrays.fill(matrix[i], 101);
			matrix[i][i] = 0;
		}
	}

	public static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	public static void union(int a, int b) {
		int aR = find(a);
		int bR = find(b);
		if (aR == bR)
			return;
		for (int i = 1; i <= N; i++) {
			if (parent[i] == bR) {
				parent[i] = aR;
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(in.readLine());
		M = Integer.valueOf(in.readLine());
		matrix = new int[N + 1][N + 1];
		StringTokenizer st;
		make();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			matrix[from][to] = matrix[to][from] = 1;
			union(from, to);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					matrix[j][k] = Math.min(matrix[j][k], matrix[j][i] + matrix[i][k]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}

		});

		for (int i = 1; i <= N; i++) {
			if (!map.containsKey(parent[i])) {
				ArrayList<Integer> li = new ArrayList<Integer>();
				li.add(i);
				map.put(parent[i], li);
			} else {
				map.get(parent[i]).add(i);
			}
		}

		for (Integer key : map.keySet()) {
			ArrayList<Integer> numbers = map.get(key);
			int size = numbers.size();
			int res = Integer.MAX_VALUE;
			int idx = Integer.MAX_VALUE;
			for (int i = 0; i < size; i++) {
				int sum = 0;
				for (int j = 0; j < size; j++) {
					sum = Math.max(sum, matrix[numbers.get(i)][numbers.get(j)]);
				}
				if (sum < res) {
					res = sum;
					idx = numbers.get(i);
				}
			}
			pq.add(idx);

		}
		sb.append(pq.size() + "\n");
		while (!pq.isEmpty()) {
			sb.append(pq.poll() + "\n");
		}
		System.out.println(sb.toString());
	}

}
