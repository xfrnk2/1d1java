package boj.p2k.p2200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2211 {
	static int N, M;
	static ArrayList<Node>[] li;
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		li = new ArrayList[N + 1];
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for (int i = 1; i <= N; i++) {
			li[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			int cost = Integer.valueOf(st.nextToken());
			li[from].add(new Node(to, cost));
			li[to].add(new Node(from, cost));
		}

		dijkstra(1);
		Set<String> set = new HashSet<>();
		for (int i = 2; i <= N; i++) {
			Stack<Integer> stack = new Stack<>();

			int idx = i;
			while (idx != 1) {
				stack.add(idx);
				idx = parent[idx];
			}
			stack.add(1);

			while (1 < stack.size()) {

				int s = stack.pop();
				int e = stack.peek();

				set.add(s + " " + e);
			}
		}
		System.out.println(set.size());
		for (String elem : set) {
			System.out.println(elem);
		}
//		/*
//		 * 경로되추적할 때, 가중치가 변경되는 경우 해당 노드의 부모 노드를 계속 갱신시켜주고, 최종 목표지점에 저장된 부모노드를 타고 내려가면
//		 * 최종적으로 그 노드에 다다른다.
//		 */

	}

	public static void dijkstra(int start) {

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int idx = cur.to;
			int cost = cur.cost;

			if (dp[idx] < cost) {
				continue;
			}

			for (int i = 0; i < li[idx].size(); i++) {
				int c = li[idx].get(i).cost + dp[idx];
				if (dp[li[idx].get(i).to] > c) {
					dp[li[idx].get(i).to] = c;
					parent[li[idx].get(i).to] = idx;
					pq.add(new Node(li[idx].get(i).to, c));
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int to, cost;

		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		public int compareTo(Node object) {
			return this.cost - object.cost;
		}
	}

}
