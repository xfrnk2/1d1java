package boj.p10k.p10200;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P10217 {
	static int N, M, K;
	static int INF = 10000000;
	static ArrayList<Node>[] graph;
	static int[][] dis;

	static class Node {
		int to, c, d;

		public Node(int to, int c, int d) {
			super();
			this.to = to;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", c=" + c + ", d=" + d + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			graph = new ArrayList[N + 1];
			dis = new int[N + 1][M + 1];
			for (int i = 0; i < N + 1; i++) {
				graph[i] = new ArrayList<>();
				Arrays.fill(dis[i], INF);
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				graph[u].add(new Node(v, c, d));

			}

			int ans = INF;
			dijkstra(1);
			for (int i = 0; i <= M; i++) {
				if (dis[N][i] < ans) {
					ans = dis[N][i];
				}

			}

			out.write((ans == INF ? "Poor KCM" : ans) + "\n");

		}
		out.flush();
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				int t = o1.d - o2.d;
				if (t == 0) {
					return o1.c - o2.c;
				}
				return t;
			}

		});
		dis[start][0] = 0;
		pq.add(new Node(start, 0, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.d > dis[cur.to][cur.c])
				continue;

			for (Node nxt : graph[cur.to]) {
				int nxtD = cur.d + nxt.d;
				int nxtC = cur.c + nxt.c;
				if (nxtC > M)
					continue;
				if (nxtD < dis[nxt.to][nxtC]) {
					dis[nxt.to][nxtC] = nxtD;
					pq.add(new Node(nxt.to, nxtC, nxtD));
				}
			}

		}

	}

}
