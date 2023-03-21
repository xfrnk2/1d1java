package boj.p1k.p1600;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1647 {

	static int N, M;
	static int[] parents;

	static void make() {
		parents = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parents[i] = i;
		}

	}

	static int find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}

	static boolean union(int a, int b) {
		int aR = find(a);
		int bR = find(b);

		if (aR == bR)
			return false;

		parents[aR] = bR;
		return true;
	}

	static class Node {
		int from, to, cost;

		public Node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		make();
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}

		});
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			pq.add(new Node(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()),
					Integer.valueOf(st.nextToken())));
		}

		int sum = 0;
		int cnt = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (union(cur.from, cur.to)) {
				sum += cur.cost;
				cnt++;
				if (cnt == N - 2) {
					break;
				}
			}
		}

		System.out.println(sum);

	}

}
