package boj.p1k.p1600;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1626 {
	static int V, E;
	static int[] parent, depth;
	static Queue<Node> unused;
	static ArrayList<Path>[] adjList;
	static Path[] parentLCA;

	static class Node implements Comparable<Node> {
		int from, to, cost;

		public Node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		public int compareTo(Node target) {
			int p = this.cost - target.cost;
			if (p == 0) {
				return this.from - target.from; 
			}
			return p;
		}

	}

	static class Path {
		int to, cost;

		public Path(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

	}

	static void initParent() {
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

	}

	static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot != bRoot) {
			parent[aRoot] = bRoot;
			return true;
		}
		return false;
	}

	static void initLCA(int cur, int d) {
		depth[cur] = d;
		for (int i = 0; i < adjList[cur].size(); i++) {
			if (depth[adjList[cur].get(i).to] == -1) {
				parentLCA[adjList[cur].get(i).to] = new Path(cur, adjList[cur].get(i).cost);

				initLCA(adjList[cur].get(i).to, d + 1);
			}
		}

	}

	static int LCA(int a, int b, int prevCost) {
		int change = Integer.MAX_VALUE;

		if (depth[a] < depth[b]) {
			while (depth[a] != depth[b]) {
				int curCost = parentLCA[b].cost;
				b = parentLCA[b].to;
				if (prevCost == curCost)
					continue;
				change = Math.min(change, prevCost - curCost);
			}
		} else if (depth[a] > depth[b]) {
			while (depth[a] != depth[b]) {
				int curCost = parentLCA[a].cost;
				a = parentLCA[a].to;
				if (prevCost == curCost)
					continue;
				change = Math.min(change, prevCost - curCost);
			}
		}
		while (a != b) {

			if (parentLCA[a].cost != prevCost) {
				change = Math.min(change, prevCost - parentLCA[a].cost);
			}
			if (parentLCA[b].cost != prevCost) {
				change = Math.min(change, prevCost - parentLCA[b].cost);
			}
			a = parentLCA[a].to;
			b = parentLCA[b].to;

		}
		return change;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		unused = new LinkedList<>();
		initParent();

		PriorityQueue<Node> pq = new PriorityQueue<>();
		adjList = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		parentLCA = new Path[V + 1];
		depth = new int[V + 1];
		Arrays.fill(depth, -1);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			pq.add(new Node(from, to, cost));
		}

		int ret = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (union(cur.from, cur.to)) {
				ret += cur.cost;
				adjList[cur.from].add(new Path(cur.to, cur.cost));
				adjList[cur.to].add(new Path(cur.from, cur.cost));
			} else {
				unused.add(cur);
			}
		}

		int root = find(1);
		for (int i = 2; i <= V; i++) {
			if (find(i) != root) {
				System.out.println(-1); // not mst
				return;
			}
		}

		initLCA(root, 0);
		int change = Integer.MAX_VALUE;

		while (!unused.isEmpty()) {
			Node cur = unused.poll();
			change = Math.min(change, LCA(cur.from, cur.to, cur.cost));
		}

		System.out.println(change == Integer.MAX_VALUE ? -1 : ret + change);
	}

}
