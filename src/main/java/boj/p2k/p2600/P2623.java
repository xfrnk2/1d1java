package boj.p2k.p2600;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2623 {
	static int N, M;
	static int indegree[];
	static ArrayList<Integer>[] edges;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		indegree = new int[N + 1];
		edges = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>(N);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int c = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			for (int j = 1; j < c; j++) {
				int cur = Integer.parseInt(st.nextToken());

				edges[prev].add(cur);
				prev = cur;
				indegree[cur]++;
			}

		}

		System.out.print(topologySort() == N ? sb : 0);

	}

	public static int topologySort() {
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				q.offer(i);
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			cnt++;
			sb.append(cur).append("\n");

			for (int k = 0, size = edges[cur].size(); k < size; k++) {
				int nxt = edges[cur].get(k);
				indegree[nxt]--;
				if (indegree[nxt] == 0)
					q.offer(nxt);
			}
		}
		return cnt;
	}

}
